package com.example.ihalewebservis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Toast;


import com.example.ihalewebservis.Models.onlineUser;
import com.example.ihalewebservis.RestApi.ManagerAll;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{

    Button login;
    EditText editText;
    String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=findViewById(R.id.button);
        editText=findViewById(R.id.editText);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = editText.getText().toString();
                online(name);
                Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                intent.putExtra("username",name);
                startActivity(intent);


            }
        });



    }
    public void online(String ad){

        Call<onlineUser> x= ManagerAll.getonline().isOnline(ad);
        x.enqueue(new Callback<onlineUser>() {
            @Override
            public void onResponse(Call<onlineUser> call, Response<onlineUser> response) {


            }

            @Override
            public void onFailure(Call<onlineUser> call, Throwable t) {

            }
        });
    }




}
