from django.contrib import admin
from .models import Task

# Register your models here.
@admin.register(Task)
class TaskModelAdmin(admin.ModelAdmin):
    list_display = ['id', 'content', 'is_completed', 'start_at', 'end_at']
    list_editable = ['is_completed']
    list_filter = ['end_at']
