from django.shortcuts import render
from rest_framework.viewsets import ModelViewSet
from django.core.exceptions import ObjectDoesNotExist
from django.http import JsonResponse, response
from rest_framework.response import Response
from rest_framework.decorators import api_view

from .models import User
from .serializers import UserModelSerializer

# Create your views here.

class UserModelViewSet(ModelViewSet):
    queryset = User.objects.all()
    serializer_class = UserModelSerializer

@api_view(['GET'])
def get_user_detail(request):
    try:
        userId = request.GET.get('userId', 0)
        user = User.objects.get(id=userId)
        serializer = UserModelSerializer(user)
        return Response(serializer.data)
    except ObjectDoesNotExist:
        return JsonResponse({'error': 'User not found'}, status=404)
    