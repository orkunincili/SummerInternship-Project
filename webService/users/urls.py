
from django.conf.urls import url
from users.views import *
from django.views.decorators.csrf import csrf_exempt

app_name = "users"

urlpatterns = [
    url(r'^users/$',show_user.as_view()),
    url(r'^user/$', csrf_exempt(add_user)),
    url(r'^onlineuser/$',csrf_exempt(add_online_user)),
    url(r'^delete_user/$',csrf_exempt(delete_user)),
    url(r'^(?P<id>\d+)/user_update/$',update_user),
]

