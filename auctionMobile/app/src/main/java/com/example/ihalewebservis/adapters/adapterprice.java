package com.example.ihalewebservis.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ihalewebservis.Models.Price;
import com.example.ihalewebservis.R;

import java.util.List;

public class adapterprice extends BaseAdapter {

    List<Price> guncel;
    Context context;

    public adapterprice(List<Price> guncel, Context context) {
        this.guncel = guncel;
        this.context = context;
    }


    @Override
    public int getCount() {
        return guncel.size();
    }

    @Override
    public Object getItem(int i) {
        return guncel.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.ihale_list,viewGroup,false);

        TextView guncel_Fiyat=(TextView)view.findViewById(R.id.guncel_fiyat);

        guncel_Fiyat.setText(guncel_Fiyat.getText()+" "+guncel.get(i).getPrice());

        return view;
    }
}
