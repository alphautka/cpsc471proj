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
        boolean isOwner = getIntent().getBooleanExtra("isOwner", false);

        if(!isOwner){
            Button emp = (Button)findViewById(R.id.employeeButton);
            emp.setVisibility(View.GONE);
        }

        Button browseButton = (Button)findViewById(R.id.browseButton);
        Button customersButton = (Button)findViewById(R.id.customersButton);
        Button orderButton = (Button)findViewById(R.id.orderButton);
        Button empButton = (Button)findViewById(R.id.employeeButton);

        Button logoutButton = (Button)findViewById(R.id.logoutButton);

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

        logoutButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                logout();
            }
        });

        empButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                employee();
            }
        });

    }

    void browse(){
        Intent i = new Intent(getApplicationContext(), MainMenuActivity.class);
        i.putExtra("PriviledgedUser", true);
        startActivity(i);
    }
    void customers(){
        Intent i = new Intent(getApplicationContext(), CustomerList.class);
        startActivity(i);
    }
    void order(){
        Intent i = new Intent(getApplicationContext(), OrderForm.class);
        startActivity(i);
    }


    void logout(){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        i.putExtra("PriviledgedUser", false);
        startActivity(i);
    }

    void employee(){
        Intent i = new Intent(getApplicationContext(), EmployeeList.class);
        startActivity(i);
    }
}
