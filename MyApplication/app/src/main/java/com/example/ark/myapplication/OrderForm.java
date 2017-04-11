package com.example.ark.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class OrderForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_form);

        Spinner distMenu = (Spinner)findViewById(R.id.DistMenu);
        String[] dists = new String[]{"Distributor 1", "Distributor 2"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, dists);
        distMenu.setAdapter(adapter);

        List<Liquor> testlist = new ArrayList<Liquor>();
        for (int i = 0; i < 10; i++){
            Liquor i1 = new Liquor();
            i1.setConcentration("5%");
            i1.setLtype("Beer");
            i1.setVolume("750 mL");
            i1.setName("Beer");
            i1.setBrand("Marshmallow");
            i1.setPrice(9.99f);
            i1.setCspc(123456);
            testlist.add(i1);
        }

        LinearLayout items = (LinearLayout)findViewById(R.id.itemLayout);
        for(Products p : testlist){
            OrderItem temp = new OrderItem(this);
            temp.setName(p);
            temp.setBrand(p);
            temp.setPrice(p);

            items.addView(temp);
        }
    }
}
