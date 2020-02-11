# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models

# Create your models here.

class User(models.Model):


       username=models.CharField(max_length=20,blank=True,null=True)
       price=models.CharField(max_length=20,blank=True,null=True)
       user_id=models.CharField(max_length=10,blank=True,null=True)


       def __str__(self):
          return str(self.username)


class onlineUser(models.Model):

       online_user=models.CharField(max_length=20)


       def __str__(self):
          return str(self.online_user)



