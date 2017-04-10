package com.example.ark.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatalogView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog_view);

        String type = getIntent().getStringExtra("prod_type");

        String labelText = "";

        List<? extends Products> list = null;

        if (type.equals("Liquor")){
            labelText = "Liquor";
//            try {
//                list = MainActivity.db.getAllLiquors();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
        }else if(type.equals("Non-Liquor")){
            labelText = "Non-Liquor";
//            try {
//                list = MainActivity.db.getAllNonLiquors();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
        }else if(type.equals("Misc")){
            labelText = "Misc.";
//            try {
//                list = MainActivity.db.getAllMiscs();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
        }else{
            System.out.println("wrong args passed to CatalogView");        }

        TextView typeLabel = (TextView)findViewById(R.id.TypeLabel);
        typeLabel.setText(labelText);

        //TEST LIST
        List<Liquor> testlist = new ArrayList<Liquor>();
        for (int i = 0; i < 10; i++){
            Liquor i1 = new Liquor();
            i1.setConcentration("5%");
            i1.setLtype("Beer");
            i1.setVolume("750 mL");
            i1.setName("Beer");
            i1.setBrand("Marshmallow");
            i1.setPrice(9.99f);
            testlist.add(i1);
        }

        //fill the catalog with items returned from db query
        LinearLayout catalogList = (LinearLayout)findViewById(R.id.catalogLayout);


        for(Products p : testlist){
            CatalogActivity temp = new CatalogActivity(this);
            temp.setName(p);
            temp.setBrand(p);
            temp.setPrice(p);

            catalogList.addView(temp);
        }


    }
}
