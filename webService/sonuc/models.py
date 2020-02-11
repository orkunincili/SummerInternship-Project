# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models

# Create your models here.


class ihale_sonuc(models.Model):
    ihaleAdi = models.CharField(max_length=120)
    urunAdi = models.CharField(max_length=120)
    baslangicFiyati = models.FloatField(default=None)
    sonFiyat=models.FloatField(default=None)
    kimdeKaldi=models.CharField(max_length=20)
    
    def __str__(self):
        return self.ihaleAdi


