# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models




class Ihale(models.Model):

    ihaleAdi = models.CharField(max_length=120)
    urunAdi = models.CharField(max_length=120)
    baslangicFiyati = models.FloatField(default=None)
    aktifMi = models.BooleanField(default=False)

    def __str__(self):
        return self.ihaleAdi


class Price(models.Model):
    ihaleAktif=models.ForeignKey(Ihale,on_delete=models.CASCADE,default=None)
    price=models.FloatField(default=None)

