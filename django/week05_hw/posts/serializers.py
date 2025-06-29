from rest_framework.serializers import ModelSerializer
from .models import Post

class PostModelSerializer(ModelSerializer):
    class Meta:
        model = Post
        fields = '__all__'

class PostListSerializer(PostModelSerializer):
    class Meta(PostModelSerializer.Meta):
        fields = ['id', 'writer', 'content', 'created_at', 'view_count']
        depth = 1

class PostCreateSerializer(PostModelSerializer):
    class Meta(PostModelSerializer.Meta):
        fields = ['image', 'content']

class PostRetrieveSerializer(PostModelSerializer):
    class Meta(PostModelSerializer.Meta):
        depth = 1