package com.example.ark.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

        TextView nameLabel = (TextView)findViewById(R.id.itemNameLabel);
        TextView brandLabel = (TextView)findViewById(R.id.brandLabel);
        TextView priceLabel = (TextView)findViewById(R.id.priceLabel);
        TextView discLabel = (TextView)findViewById(R.id.discountLabel);
        TextView qtyLabel = (TextView)findViewById(R.id.discountLabel);
        TextView volumeLabel = (TextView)findViewById(R.id.volumeLabel);
        TextView concentrationLabel = (TextView)findViewById(R.id.concentrationLabel);

        String name = getIntent().getStringExtra("name");
        String price = getIntent().getStringExtra("price");
        String discount = getIntent().getStringExtra("discount");
        String qty = getIntent().getStringExtra("qty");
        String brand = getIntent().getStringExtra("brand");
        String cspc = getIntent().getStringExtra("cspc");

        String volume = "";
        String concentration = "";

        String prod_type = getIntent().getStringExtra("prod_type");

        nameLabel.setText(name);
        brandLabel.setText(brand);
        priceLabel.setText(price);
        discLabel.setText(discount);
        qtyLabel.setText(qty);

        if(prod_type.equals("Liquor")){
            Liquor item = (Liquor)MainActivity.db.getLiquor(Integer.parseInt(cspc));
            concentration = item.getConcentration();
            volume = item.getVolume();
        }else if(prod_type.equals("Non-Liquor")){
            Non_Liquor item = MainActivity.db.getNonLiquor(Integer.parseInt(cspc));
            volume = item.getVolume();
        }

        volumeLabel.setText(volume);
        concentrationLabel.setText(concentration);
    }


    private void logout(){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        i.putExtra("PriviledgedUser", false);
        startActivity(i);
    }
}
