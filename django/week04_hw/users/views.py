from django.shortcuts import render
from rest_framework.viewsets import ModelViewSet
from django.core.exceptions import ObjectDoesNotExist
from django.http import JsonResponse, response
from rest_framework.response import Response
from rest_framework.decorators import api_view
from django.contrib.auth.hashers import make_password

from .models import User
from .serializers import UserModelSerializer, UserModelDetailSerializer

# Create your views here.

class UserModelViewSet(ModelViewSet):
    queryset = User.objects.all()
    serializer_class = UserModelSerializer

@api_view(['GET'])
def get_user_detail(request): #쿼리파라미터
    try:
        userId = request.GET.get('userId', 0)
        user = User.objects.get(id=userId)
        serializer = UserModelDetailSerializer(user)
        return Response(serializer.data)
    except ObjectDoesNotExist:
        return JsonResponse({'error': 'User not found'}, status=404)
    
@api_view(['PATCH'])
def update_user(request):
    user_id = request.data.get('id')
    if not user_id:
        return Response({'error': 'User ID is required'}, status=400)
    
    try:
        user = User.objects.get(id=user_id)
    except ObjectDoesNotExist:
        return JsonResponse({'error': 'User not found'}, status=404)

    serializer = UserModelSerializer(user, data=request.data, partial=True)

    if serializer.is_valid():
        serializer.save()
        return Response(serializer.data)
    else:
        return Response(serializer.errors, status=400)
    
@api_view(['POST'])
def sign_up(request):
    data = request.data

    if not data.get('password1') or not data.get('password2'):
        return JsonResponse({'error': 'Password1 and Password2 required'}, status=400)
    if data.get('password1') != data.get('password2'):
        return JsonResponse({'error': 'Wrong password'}, status=400)
    if not data.get('username') or not data.get('email'):
        return JsonResponse({'error': 'Username and Email required'}, status=400)

    user = User (
            username=data['username'],
            email=data['email'],
            password=make_password(data['password1']),
        )
    user.save()

    serializer = UserModelSerializer(user)
    return Response(serializer.data, status=201)

@api_view(['DELETE'])
def delete_user(request): #쿼리파라미터
    try:
        userId = request.GET.get('userId', 0)
        user = User.objects.get(id=userId)
        user.delete()
        return JsonResponse({'message': 'User deleted', 'user_id': userId}, status=200)
    except ObjectDoesNotExist:
        return JsonResponse({'error': 'User not found'}, status=404)




