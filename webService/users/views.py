# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.shortcuts import render,HttpResponse

from rest_framework.response import Response
from rest_framework.views import APIView
from .forms import *
from .models import User
from .serializers import *

class show_user(APIView):
     def get(self,request):
         users=User.objects.all()
         serializer = UserSerializer(users,many=True)
         return Response(serializer.data)

def add_user(request):

     form=UserForm()
     username=request.POST.get('username')
     price=request.POST.get('price')
     user_id=request.POST.get('user_id')


     User.objects.create(username=username,price=price,user_id=user_id)


     context={
       'form':form,
     }
     return render(request,"form.html",context)

def delete_user(request):
    form=deleteForm()
    user_id=request.POST.get('user_id')
    userD=User.objects.get(user_id=user_id)
    userD.delete()
    context = {
        'form': form,
    }

    return render(request,"delete.html",context)
    


