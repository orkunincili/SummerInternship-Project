# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.contrib import admin

from .models import *

class ihaleAdmin(admin.ModelAdmin):

    list_display = ['ihaleAdi','baslangicFiyati']
    class Meta:
        model=Ihale

class PriceAdmin(admin.ModelAdmin):

    list_display = ['ihaleAktif','price',]
    list_editable = ['price']
    class Meta:
        model=Price



admin.site.register(Ihale,ihaleAdmin)
admin.site.register(Price,PriceAdmin)

