from django.db import models

# Create your models here.

class Image(models.Model):
    image = models.ImageField(verbose_name='이미지')
    description = models.TextField(verbose_name='이미지 설명')
    uploader = models.TextField(verbose_name='업로드한 사람')
    created_at = models.DateTimeField(verbose_name='업로드일')