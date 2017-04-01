package com.example.ark.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


        Button liquorButton = (Button)findViewById(R.id.liquorButton);
        Button nonLiquorButton = (Button)findViewById(R.id.nonLiquorButton);
        Button miscButton = (Button)findViewById(R.id.miscButton);

        liquorButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                liquor();
            }
        } );

        nonLiquorButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                nonLiquor();
            }
        } );

        miscButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                miscellaneous();
            }
        } );
    }

    private void miscellaneous(){
        startActivity(new Intent(getApplicationContext(), CatalogActivity.class));
    }

    private void liquor(){
        startActivity(new Intent(getApplicationContext(), CatalogActivity.class));
    }
    private void nonLiquor(){
        startActivity(new Intent(getApplicationContext(), CatalogActivity.class));
    }
}
