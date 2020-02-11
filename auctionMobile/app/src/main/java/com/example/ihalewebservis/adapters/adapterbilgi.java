package com.example.ihalewebservis.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ihalewebservis.Models.Bilgiler;
import com.example.ihalewebservis.Models.Price;
import com.example.ihalewebservis.R;

import java.util.List;

public class adapterbilgi  extends BaseAdapter {

    List<Bilgiler> list;

    Context context;


    public adapterbilgi(List<Bilgiler> list, Context context) {
        this.list = list;

        this.context = context;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.ihale_list,viewGroup,false);

        TextView ihale_Adi=(TextView) view.findViewById(R.id.ihale_adi);
        TextView urun_Adi=(TextView) view.findViewById(R.id.urun_adi);
        TextView baslangic_Fiyat=(TextView)view.findViewById(R.id.baslangic_fiyat);

        ihale_Adi.setText(""+list.get(i).getIhaleAdi());
        urun_Adi.setText(""+list.get(i).getUrunAdi());
        baslangic_Fiyat.setText(""+list.get(i).getBaslangicFiyati());


        return view;
    }
}
