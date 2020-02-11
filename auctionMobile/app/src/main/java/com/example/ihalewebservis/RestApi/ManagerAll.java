package com.example.ihalewebservis.RestApi;

import androidx.constraintlayout.solver.LinearSystem;

import com.example.ihalewebservis.Models.Bilgiler;
import com.example.ihalewebservis.Models.Price;
import com.example.ihalewebservis.Models.deleteUser;
import com.example.ihalewebservis.Models.user;
import com.example.ihalewebservis.Models.onlineUser;

import java.util.List;

import retrofit2.Call;

public class ManagerAll extends BaseManager {

    private static ManagerAll ourInstance = new ManagerAll();
    private static ManagerAll users=new ManagerAll();
    private static ManagerAll onlineUsers=new ManagerAll();
    private static ManagerAll deleteUser=new ManagerAll();
    private static ManagerAll getPrice=new ManagerAll();


    public static synchronized ManagerAll getInstance()
    {
        return ourInstance;
    }
    public static synchronized ManagerAll getusers()
    {
        return users;
    }
    public static synchronized ManagerAll delUser(){return deleteUser;}
    public static synchronized ManagerAll getonline(){return onlineUsers;}
    public static synchronized ManagerAll get_price(){return getPrice;}

    public Call<List<Price>> get_auction_price()
    {
        Call<List<Price>> price =getRestApiClient().getPrice();
        return price;
    }

    public Call<List<Bilgiler>> getirBilgileri()
    {
        Call<List<Bilgiler>> call = getRestApiClient().bilgiGetir();
        return call;
    }
    public Call<user> ekle(String ad,String price,String user_id){
        Call<user> y= getRestApiClient().addUser(ad,price,user_id);
        return y;
    }
    public Call<onlineUser> isOnline(String user){
        Call<onlineUser> u= getRestApiClient().addOnline(user);
        return u;
    }

    public Call<deleteUser> deleteUser(String user_id){
        Call<deleteUser> d=getRestApiClient().deleteUser(user_id);
        return d;
    }

}
