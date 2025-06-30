from django.shortcuts import render
from rest_framework.viewsets import ModelViewSet

from .models import Post
from .serializers import PostModelSerializer, PostListSerializer, PostRetrieveSerializer, CommentListModelSerializer, CommentCreateModelSerializer
from rest_framework import generics
from rest_framework.decorators import action, api_view
from rest_framework.response import Response
from django.contrib.auth import authenticate
from rest_framework.authtoken.models import Token
from rest_framework.permissions import AllowAny, IsAuthenticated, IsAdminUser

# Create your views here.
class PostModelViewSet(ModelViewSet):
    queryset = Post.objects.all()
    serializer_class = PostListSerializer

    @action(detail=True, methods=['GET'])
    def get_comment_all(self, request, pk=None):
        post = self.get_object()
        comment_all = post.comment_set.all()
        serializer = CommentListModelSerializer(comment_all, many=True)
        return Response(serializer.data)

    @action(detail=True, methods=['POST'])
    def create_comment(self, request, pk=None):
        post = self.get_object()
        data = request.data.copy()
        data['post'] = post.id
        
        serializer = CommentCreateModelSerializer(data=data)
        if serializer.is_valid():
            serializer.save()
            return Response(serializer.data, status=201)
        else:
            return Response(serializer.errors, status=400)
        
    def get_permissions(self):  #메서드에 따른 권한
        action = self.action
        if action == 'list':
            permission_classes = [AllowAny]
        elif action == 'create':
            permission_classes = [IsAuthenticated]
        elif action == 'retrieve':
            permission_classes = [IsAuthenticated]
        elif action == 'update':
            permission_classes = [IsAdminUser]
        elif action == 'partial_update':
            permission_classes = [IsAdminUser]
        elif action == 'destroy':
            permission_classes = [IsAdminUser]
        return [permission() for permission in permission_classes]
        

class PostListView(generics.ListAPIView, generics.CreateAPIView):
    queryset = Post.objects.all()
    serializer_class = PostListSerializer

class PostRetrieveView(generics.RetrieveAPIView, generics.UpdateAPIView, generics.DestroyAPIView):
    queryset = Post.objects.all()
    serializer_class = PostRetrieveSerializer

@api_view(['POST'])
def login_view(request):
    username = request.POST.get('username')
    password = request.POST.get('password')
    user = authenticate(request,
                        username = username,
                        password = password)
    
    if user : 
        token, _ = Token.objects.get_or_create(user=user)
        return Response({'token': token.key})
    
    else:
        return Response(status=401)