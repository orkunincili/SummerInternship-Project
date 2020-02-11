
from django.conf.urls import url

from .views import *


app_name = "ihale"

urlpatterns = [
    url(r'^ihaleler/$', ihale_goster.as_view()),
    url(r'^price/$',show_price.as_view()),
    url(r'^ihale/(?P<id>\d+)$', ihale_goster.as_view()),
]
