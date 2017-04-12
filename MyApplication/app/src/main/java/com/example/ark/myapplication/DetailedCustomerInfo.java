package com.example.ark.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailedCustomerInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_customer_info);

        String name = getIntent().getStringExtra("name");
        String cid = "Customer ID: " + getIntent().getStringExtra("cid");
        String phoneNum = "Phone Number: " + getIntent().getStringExtra("phone");
        String disc = "Customer Specific Discount: " + getIntent().getStringExtra("discount");

        TextView nameLabel = (TextView)findViewById(R.id.name);
        TextView cidLabel = (TextView)findViewById(R.id.custID);
        TextView phoneLabel = (TextView)findViewById(R.id.phoneNum);
        TextView discLabel = (TextView)findViewById(R.id.discount);

        nameLabel.setText(name);
        cidLabel.setText(cid);
        phoneLabel.setText(phoneNum);
        discLabel.setText(disc);

        Button add = (Button)findViewById(R.id.editButton);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editInfo();
            }
        });

        System.out.println("here");

    }

    private void editInfo(){
        //make pop-up appear with editable text fields
        //set the text fields' default text to whatever the current values are
        //when OK is hit, send changes to db and update the labels
        System.out.println("hi");
    }
}
