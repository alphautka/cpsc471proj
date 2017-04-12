package com.example.ark.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainMenuActivity extends AppCompatActivity {

    Connection conn;
    String un, pass, db, ip;
    DatabaseHandler dbh;
    List<Liquor> liquorList;
    List<Non_Liquor> nliquorList;
    List<Misc> miscList;
    Liquor liquor = new Liquor(1, "14%", "250mL", "Wine");
    boolean isPriviledged;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Button logoutButton = (Button)findViewById(R.id.logoutButton);

        isPriviledged = getIntent().getBooleanExtra("PriviledgedUser", false);

        if (isPriviledged) {
            logoutButton.setVisibility(View.VISIBLE);
            logoutButton.setEnabled(true);
        }

        ip = "136.159.7.84:50001";    //enter ip address here
        db = "CPSC471_Winter2017";    //emter database name here
        un = "CPSC471_Winter2017";    //enter username here
        pass = "6VXVM_0~rq1F-$W";  //enter password here

        liquorList = new ArrayList<>();
        nliquorList = new ArrayList<>();
        miscList = new ArrayList<>();

        Button liquorButton = (Button)findViewById(R.id.liquorButton);
        Button nonLiquorButton = (Button)findViewById(R.id.nonLiquorButton);
        Button miscButton = (Button)findViewById(R.id.miscButton);
        Button favButton = (Button)findViewById(R.id.favoritesButton);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                logout();
            }
        });

        liquorButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                liquor();
            }
         });

        nonLiquorButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                nonLiquor();
        } });

        miscButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                miscellaneous();
        } });


        favButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                favs();
            }
        });

    }


    private void logout(){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        i.putExtra("PriviledgedUser", false);
        startActivity(i);

    }

    private void miscellaneous(){
        //startActivity(new Intent(getApplicationContext(), CatalogListActivity.class));
        Intent i = new Intent(getApplicationContext(), CatalogView.class);
        i.putExtra("prod_type", "Misc");

        i.putExtra("PriviledgedUser", isPriviledged);

        startActivity(i);
    }

    private void liquor(){
        //startActivity(new Intent(getApplicationContext(), CatalogListActivity.class));
        Intent i = new Intent(getApplicationContext(), CatalogView.class);
        i.putExtra("prod_type", "Liquor");
        i.putExtra("PriviledgedUser", isPriviledged);
        startActivity(i);
    }
    private void nonLiquor(){
        //startActivity(new Intent(getApplicationContext(), CatalogListActivity.class));
        Intent i = new Intent(getApplicationContext(), CatalogView.class);
        i.putExtra("prod_type", "Non-Liquor");

        startActivity(i);
    }

    private void favs(){
        Intent i = new Intent(getApplicationContext(), CatalogView.class);
        i.putExtra("prod_type", "Fav");
        startActivity(i);


        i.putExtra("PriviledgedUser", isPriviledged);
        startActivity(i);
    }






}
