package com.example.ark.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DetailedItemView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_item_view);



        Button logoutButton = (Button)findViewById(R.id.logoutButton);

        boolean isPriviledged = getIntent().getBooleanExtra("PriviledgedUser", false);

        if (isPriviledged) {
            logoutButton.setVisibility(View.VISIBLE);
            logoutButton.setEnabled(true);
        }


        logoutButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                logout();
            }
        });
    }


    private void logout(){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        i.putExtra("PriviledgedUser", false);
        startActivity(i);
    }
}
