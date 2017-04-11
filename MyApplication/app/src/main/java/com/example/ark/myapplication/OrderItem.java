package com.example.ark.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DecimalFormat;

public class OrderItem extends RelativeLayout {

    public OrderItem(Context context){
        super(context);
        initializeViews(context);
    }

    public OrderItem (Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);
    }

    public OrderItem(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
        initializeViews(context);
    }

    private void initializeViews(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.activity_order_item, this);
    }

    public void setPrice(Products product){
        TextView mPriceLabel = (TextView) this.findViewById(R.id.priceLabel);
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);
        mPriceLabel.setText("$"+df.format(product.getPrice()));
    }

    public void setBrand(Products product){
        TextView mBrandLabel = (TextView) this.findViewById(R.id.brandLabel);
        mBrandLabel.setText(product.getBrand());
    }

    public void setName(Products product) {
        TextView mTextLabel = (TextView) this.findViewById(R.id.nameLabel);
        mTextLabel.setText(product.getName());
    }

    public void setCSPC(Products product){
        TextView cspcLabel = (TextView)this.findViewById(R.id.cspcLabel);
        cspcLabel.setText(product.getCspc());
    }

    public int getQty(){
        EditText qtyLabel = (EditText) this.findViewById(R.id.qty);
        int qty = Integer.parseInt(qtyLabel.getText().toString());
        return qty;
    }
}
