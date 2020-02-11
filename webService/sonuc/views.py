# -*- coding: utf-8 -*-

from __future__ import unicode_literals

from django.shortcuts import render,HttpResponse

from rest_framework.response import Response
from rest_framework.views import APIView
from .forms import *
from .models import ihale_sonuc



def add_sonuc(request):

     form=sonucForm()
     ihaleAdi=request.POST.get('ihaleAdi')
     urunAdi=request.POST.get('urunAdi')
     baslangicFiyati=request.POST.get('baslangicFiyati',None)
     sonFiyat=request.POST.get('sonFiyat',None)
     kimdeKaldi=request.POST.get('kimdeKaldi')


     ihale_sonuc.objects.create(ihaleAdi=ihaleAdi,urunAdi=urunAdi,baslangicFiyati=baslangicFiyati,sonFiyat=sonFiyat,kimdeKaldi=kimdeKaldi)

     return HttpResponse("Sonuç Eklendi...")
