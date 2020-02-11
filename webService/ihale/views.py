# -*- coding: utf-8 -*-
from __future__ import unicode_literals, division
from threading import Timer
import time

from django.shortcuts import HttpResponse
from rest_framework.response import Response
from rest_framework.views import APIView

from .models import *
from sonuc.models import *
from users.models import *
from ihale.serializers import *


class ihale_goster(APIView):

    def get(self,request):
        ihaleler = Ihale.objects.filter(aktifMi=True)

        serializer = IhaleSerializer(ihaleler, many=True)

        return Response(serializer.data)



class show_price(APIView):

    def get(self,request):

        price=Price.objects.all()
        serializers=PriceSerializer(price,many=True)

        return Response(serializers.data)
