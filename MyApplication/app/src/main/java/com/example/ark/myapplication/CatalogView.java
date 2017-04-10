package com.example.ark.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CatalogView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog_view);

        String type = getIntent().getStringExtra("prod_type");

        String labelText = "";

        if (type.equals("Liquor")){
            labelText = "Liquor";
        }else if(type.equals("Non-Liquor")){
            labelText = "Non-Liquor";
        }else if(type.equals("Misc")){
            labelText = "Misc.";
        }

        TextView typeLabel = (TextView)findViewById(R.id.TypeLabel);
        typeLabel.setText(labelText);

        CatalogActivity temp = new CatalogActivity(this);


    }
}
