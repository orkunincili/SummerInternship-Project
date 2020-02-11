
from django import forms

from .models import *



class UserForm(forms.ModelForm):

      class Meta:
          model = User

          fields = [
              "username",
              "price",
              "user_id",
              
          ]

class deleteForm(forms.ModelForm):
      class Meta:
          model=User

          fields=[
              "user_id",
          ]
