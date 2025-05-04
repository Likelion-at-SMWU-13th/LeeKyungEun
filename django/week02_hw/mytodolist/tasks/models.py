from django.db import models

class Task(models.Model):
    content = models.TextField(verbose_name='할일')
    start_at = models.DateField(verbose_name='시작일')
    end_at = models.DateField(verbose_name='마감일')
    is_completed = models.BooleanField(verbose_name='종료 여부')
    
