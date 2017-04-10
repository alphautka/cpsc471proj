package com.example.ark.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EmployeeView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_view);
        boolean isPriviledged = getIntent().getBooleanExtra("PriviledgedUser", false);

        Button browseButton = (Button)findViewById(R.id.browseButton);
        Button customersButton = (Button)findViewById(R.id.customersButton);
        Button orderButton = (Button)findViewById(R.id.orderButton);

        browseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                browse();
            }
        } );

        customersButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                customers();
            }
        } );

        orderButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                order();
            }
        } );

    }

    void browse(){
        Intent i = new Intent(getApplicationContext(), MainMenuActivity.class);
        i.putExtra("PriviledgedUser", true);
        startActivity(i);
    }
    void customers(){

    }
    void order(){}

}
