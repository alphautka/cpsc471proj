package com.example.ark.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EmployeeView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_view);
        boolean isPriviledged = getIntent().getBooleanExtra("PriviledgedUser", false);

        Button 

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                login();
            }
        } );

    }
}
