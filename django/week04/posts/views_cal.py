from rest_framework.response import Response
from rest_framework.decorators import api_view

#꼭 views.py에 다 넣을 필요 X
@api_view(['GET'])
def calculator_query(request):
    num1 = request.GET.get('num1', 0)  #쿼리 파라미터 가져오기
    num2 = request.GET.get('num2', 0)
    op = request.GET.get('op')

    if op == '+':
        result = int(num1) + int(num2)
    elif op == '-':
        result = int(num1) - int(num2)
    elif op == '*':
        result = int(num1) * int(num2)
    elif op == '/':
        result = int(num1) / int(num2)
    else:
        result = 0

    data = {
        'op' : op,
        'result' : result
    }

    return Response(data)

@api_view(['POST'])
def calculator_body(request):
    data = request.data
    num1 = data.get('num1', 0)  #쿼리 파라미터 가져오기
    num2 = data.get('num2', 0)
    op = data.get('op')

    if op == '+':
        result = int(num1) + int(num2)
    elif op == '-':
        result = int(num1) - int(num2)
    elif op == '*':
        result = int(num1) * int(num2)
    elif op == '/':
        result = int(num1) / int(num2)
    else:
        result = 0

    data = {
        'op' : op,
        'result' : result
    }

    return Response(data)