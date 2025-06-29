from django.shortcuts import render
from rest_framework.viewsets import ModelViewSet

from .models import Post
from .serializers import PostModelSerializer, PostListSerializer, PostRetrieveSerializer
from rest_framework import generics

# Create your views here.
class PostModelViewSet(ModelViewSet):
    queryset = Post.objects.all()
    serializer_class = PostListSerializer

class PostListView(generics.ListAPIView, generics.CreateAPIView):
    queryset = Post.objects.all()
    serializer_class = PostListSerializer

class PostRetrieveView(generics.RetrieveAPIView, generics.UpdateAPIView):
    queryset = Post.objects.all()
    serializer_class = PostRetrieveSerializer