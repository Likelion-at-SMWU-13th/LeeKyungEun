from rest_framework.serializers import ModelSerializer
from .models import User

class UserModelSerializer(ModelSerializer):
    class Meta:
        model = User
        fields = ['id', 'username', 'email']

class UserModelDetailSerializer(ModelSerializer):
    class Meta:
        model = User
        fields = '__all__'