from rest_framework.serializers import ModelSerializer
from .models import Post, Comment

class PostModelSerializer(ModelSerializer):
    class Meta:
        model = Post
        fields = '__all__'
        #fields = ['id','writer','content']z

class PostListSerializer(PostModelSerializer):
    class Meta(PostModelSerializer.Meta):
        depth = 1

class PostRetrieveSerializer(PostModelSerializer):
    class Meta(PostModelSerializer.Meta):
            depth = 1

class CommentListModelSerializer(ModelSerializer):
    class Meta:
        model = Comment
        fields = '__all__'