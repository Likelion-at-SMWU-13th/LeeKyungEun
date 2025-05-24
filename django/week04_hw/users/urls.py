from django.urls import path, include
from django.contrib import admin
from rest_framework import routers

from .views import UserModelViewSet, get_user_detail

app_name = "users"

router_user = routers.DefaultRouter()
router_user.register('', UserModelViewSet)

urlpatterns = [
    #path('', include(router_user.urls)),
    path('admin/', admin.site.urls),
    path('', get_user_detail, name='get_user_detail'),
]