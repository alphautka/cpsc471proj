package com.example.ark.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatalogView extends AppCompatActivity {

    String curProdType = "";
    boolean isPriviledged;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog_view);

        String type = getIntent().getStringExtra("prod_type");

        String labelText = "";



        Button logoutButton = (Button)findViewById(R.id.logoutButton);

        isPriviledged = getIntent().getBooleanExtra("PriviledgedUser", false);

        if (isPriviledged) {
            logoutButton.setVisibility(View.VISIBLE);
            logoutButton.setEnabled(true);
        }


        logoutButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                logout();
            }
        });





        List<? extends Products> list = null;
        ArrayList<Products> plist = new ArrayList();

        if (type.equals("Liquor")){
            curProdType = labelText = "Liquor";
            try {

                list = MainActivity.db.getAllLiquors();

                for (int i = 0; i < list.size(); i++){
                    Products product = MainActivity.db.getProduct(list.get(i).getCspc());
                    System.out.println(product.getBrand());
                    plist.add(product);
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if(type.equals("Non-Liquor")){
            curProdType = labelText = "Non-Liquor";
            try {
                list = MainActivity.db.getAllNonLiquors();


                for (int i = 0; i < list.size(); i++){
                    Products product = MainActivity.db.getProduct(list.get(i).getCspc());
                    System.out.println(product.getBrand());
                    plist.add(product);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if(type.equals("Misc")){
            curProdType = labelText = "Misc.";

            try {
                list = MainActivity.db.getAllMiscs();

                for (int i = 0; i < list.size(); i++){
                    Products product = MainActivity.db.getProduct(list.get(i).getCspc());
                    System.out.println(product.getBrand());
                    plist.add(product);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if(type.equals("Fav")) {
            curProdType = labelText = "Employee Picks";
            try{
                list = MainActivity.db.getAllEmployeeSelections();

                for (int i = 0; i < list.size(); i++){
                    Products product = MainActivity.db.getProduct(list.get(i).getCspc());
                    System.out.println(product.getBrand());
                    plist.add(product);
                }


            }catch(SQLException e){
                e.printStackTrace();
            }
        }

        else{
            System.out.println("wrong args passed to CatalogView");
        }


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


        for(Products p : plist){
            CatalogActivity temp = new CatalogActivity(this);
            temp.setName(p);
            temp.setBrand(p);
            temp.setPrice(p);
            temp.setOnClickListener(new DetailedOnClickListener(p) );

            catalogList.addView(temp);
        }


    }

    void detailView(Products p){
        Intent i = new Intent(getApplicationContext(), DetailedItemView.class);

        i.putExtra("price", Float.toString(p.getPrice()));
        i.putExtra("discount", p.getDiscount());
        i.putExtra("qty", Integer.toString(p.getQuantity()));
        i.putExtra("name", p.getName());
        i.putExtra("brand", p.getBrand());
        i.putExtra("cspc", Integer.toString(p.getCspc()));
        i.putExtra("prod_type", curProdType);


        i.putExtra("PriviledgedUser", isPriviledged);
        startActivity(i);
    }

    private void logout(){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        i.putExtra("PriviledgedUser", false);

        startActivity(i);
    }

    public class DetailedOnClickListener implements View.OnClickListener{

        Products prod;
        public DetailedOnClickListener(Products p){
            prod = p;
        }

        @Override
        public void onClick(View view) {
            detailView(prod);
        }
    }

}
