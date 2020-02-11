# -*- coding: utf-8 -*-
from __future__ import unicode_literals, division
import os,time,django,sys
script_path = os.path.dirname(__file__)
os.environ['DJANGO_SETTINGS_MODULE']='webservice.settings'
django.setup()
from threading import Timer

from ihale.models import *
from sonuc.models import *
from users.models import *
try:
   azalis_miktari=int(sys.argv[1])
except:
    print("Parametre olarak bir sayı girmelisiniz.")
x=True
ihale=Ihale.objects.get(aktifMi=True)
ihale_kapat=Ihale.objects.get(ihaleAdi=ihale.ihaleAdi)
while x:
    price = Price.objects.all()
    price = price[0]
    time.sleep(1)
    if len(Ihale.objects.filter(aktifMi=True))==0:
        print("Aktif ihale yok")
        break
    else:

       if len(User.objects.all())==0:

          price.price -=float(azalis_miktari)
          price.save()
          print(price.price)
       elif len(User.objects.all())==1:
           time.sleep(5)

           if len(User.objects.all()) == 1:
               user=User.objects.all()
               user=user[0]
               ihale_sonuc.objects.create(ihaleAdi=ihale.ihaleAdi, urunAdi=ihale.urunAdi,
                                          baslangicFiyati=ihale.baslangicFiyati, sonFiyat=price.price,
                                          kimdeKaldi=user.username)
               User.objects.all().delete()
               ihale.aktifMi = False
               ihale.save()

               x=False

           elif len(User.objects.all()) == 0:
               price.price -=float(azalis_miktari)
               price.save()
               print(price.price)
           else:
               price.price +=(len(User.objects.all())/2)*3
               price.save()
               print(price.price)
       else:
           price.price+=(len(User.objects.all())/2)*3
           price.save()
           print(price.price)


print("ihale sona erdi")




