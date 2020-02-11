
from django import forms

from .models import *



class sonucForm(forms.ModelForm):

      class Meta:
          model = ihale_sonuc

          fields = [
              "ihaleAdi",
              "urunAdi",
              "baslangicFiyati",
              "sonFiyat",
              "kimdeKaldi",

          ]

