
from rest_framework import serializers
from ihale.models import Ihale

class IhaleSerializer(serializers.ModelSerializer):
      class Meta:
            model=Ihale

            fields=["ihaleAdi","urunAdi","baslangicFiyati","aktifMi"]

class PriceSerializer(serializers.Serializer):

      price = serializers.FloatField(default=None)