from django.shortcuts import render, get_object_or_404, redirect, HttpResponse
from .models import Task
from django.views.generic import ListView
from django.views.decorators.csrf import csrf_exempt

# Create your views here.
def task_detail_view(request, taskid):
    task = get_object_or_404(Task, id=taskid)
    return render(request, 'task_detail.html', {'task':task})

class task_list_class_view(ListView):
    model = Task
    template_name = 'task_list.html'

@csrf_exempt
def index(request):
    if request.method == 'GET':
        return redirect('/tasks/')
    elif request.method == 'POST':
        content = request.POST.get('content')
        start_at = request.POST.get('start_at')
        end_at = request.POST.get('end_at')

        Task.objects.create(
            content=content,
            start_at=start_at,
            end_at=end_at,
            is_completed=False
        )

        return HttpResponse('등록 완료')
    return render(request, 'index.html')