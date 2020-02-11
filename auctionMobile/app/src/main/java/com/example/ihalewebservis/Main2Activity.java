package com.example.ihalewebservis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ihalewebservis.Models.Bilgiler;
import com.example.ihalewebservis.Models.Price;
import com.example.ihalewebservis.Models.deleteUser;
import com.example.ihalewebservis.Models.user;
import com.example.ihalewebservis.RestApi.ManagerAll;
import com.example.ihalewebservis.adapters.adapterbilgi;
import com.example.ihalewebservis.adapters.adapterprice;

import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2Activity extends AppCompatActivity {

    List<Bilgiler> list;
    List<Price> guncel;
    ListView listView;
    ListView listViewPrice;
    Button katil;
    Button cekil;

    String username;
    String user_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        tanimla();
        listViewPrice=(ListView)findViewById(R.id.list_price);
        katil=findViewById(R.id.katil);
        cekil=findViewById(R.id.cekil);

        Bundle intent=getIntent().getExtras();
        username=intent.getString("username");

        Timer timer =new Timer();
        TimerTask say=new TimerTask() {
            @Override
            public void run() {
                Main2Activity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        istek();

                    }
                });
            }};
        timer.schedule(say,0,1000);
        Timer price =new Timer();
        TimerTask price_counter=new TimerTask() {
            @Override
            public void run() {
                Main2Activity.this.runOnUiThread(new Runnable() {
                    public void run() {
                        getprice();



                    }
                });
            }};
        price.schedule(price_counter,0,1000);
        katil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_id=create_id();
                send(username,""+guncel.get(0).getPrice(),user_id);
                katil.setVisibility(View.INVISIBLE);


            }
        });
        cekil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete_user(user_id);
                katil.setVisibility(View.INVISIBLE);
                cekil.setVisibility(View.INVISIBLE);
                Toast.makeText(getApplicationContext(),"İhaleden çıkıldı.Tekrar katılamazsınız.",Toast.LENGTH_LONG).show();

            }
        });


    }


    public void send(String ad,String price,String user_id){

        Call<user> x= ManagerAll.getusers().ekle(ad,price,user_id);
        x.enqueue(new Callback<user>() {
            @Override
            public void onResponse(Call<user> call, Response<user> response) {
                Toast.makeText(getApplicationContext(),"başarılı",Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<user> call, Throwable t) {

            }
        });
    }

    public void delete_user(String user_id){
        Call<deleteUser> dU=ManagerAll.delUser().deleteUser(user_id);
        dU.enqueue(new Callback<deleteUser>() {
            @Override
            public void onResponse(Call<deleteUser> call, Response<deleteUser> response) {


            }

            @Override
            public void onFailure(Call<deleteUser> call, Throwable t) {

            }
        });
    }



    public void tanimla()
    {
        listView = (ListView)findViewById(R.id.list_view);

    }
    public void getprice(){
        final Call<List<Price>> price=ManagerAll.get_price().get_auction_price();
        price.enqueue(new Callback<List<Price>>() {
            @Override
            public void onResponse(Call<List<Price>> call, Response<List<Price>> response) {
                if(response.isSuccessful()){
                    guncel=response.body();
                    adapterprice priceAdapter = new adapterprice(guncel,getApplicationContext());
                    listViewPrice.setAdapter(priceAdapter);
                }
            }



            @Override
            public void onFailure(Call<List<Price>> call, Throwable t) {

            }
        });
    }
    public void istek(){
        Call<List<Bilgiler>> bilgiList= ManagerAll.getInstance().getirBilgileri();
        bilgiList.enqueue(new Callback<List<Bilgiler>>() {
            @Override
            public void onResponse(Call<List<Bilgiler>> call, Response<List<Bilgiler>> response) {
                if(response.isSuccessful())
                {

                    list=response.body();

                    adapterbilgi bilgiAdapter = new adapterbilgi(list,getApplicationContext());
                    listView.setAdapter(bilgiAdapter);
                }

            }

            @Override
            public void onFailure(Call<List<Bilgiler>> call, Throwable t) {

            }
        });
    }

    public static String create_id(){
        Random rand=new Random();
        char[] lower_alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] upper_alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXTZ".toCharArray();
        int id_size=5;
        String id="";
        for(int i=0;i<id_size;i++){
            int x=rand.nextInt(3);
            if(x%2==0){
                if(x==0){
                    int which_letter=rand.nextInt(lower_alphabet.length);
                    id+=lower_alphabet[which_letter];
                }
                else{
                    int which_number=rand.nextInt(10);
                    id+=Integer.toString(which_number);
                }

            }else{

                int which_letter=rand.nextInt(upper_alphabet.length);
                id+=upper_alphabet[which_letter];
            }

        }
        return id;
    }
}
