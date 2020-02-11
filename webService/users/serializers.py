
from rest_framework import serializers


class UserSerializer(serializers.Serializer):


       username=serializers.CharField(max_length=20)
       price=serializers.CharField(max_length=20)
