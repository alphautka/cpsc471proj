package com.example.ark.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class CatalogActivity extends RelativeLayout{


    public CatalogActivity(Context context){
        super(context);
        initializeViews(context);
    }

    public CatalogActivity (Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);
    }

    public CatalogActivity(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
        initializeViews(context);
    }

    private void initializeViews(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.activity_catalog, this);
    }

    public void setPrice(Products product){
        TextView mPriceLabel = (TextView) this.findViewById(R.id.priceLabel);
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);
        mPriceLabel.setText(df.format(product.getPrice()));
    }

    public void setBrand(Products product){
        TextView mBrandLabel = (TextView) this.findViewById(R.id.brandLabel);
        mBrandLabel.setText(product.getBrand());
    }

    public void setName(Products product) {
        TextView mTextLabel = (TextView) this.findViewById(R.id.nameLabel);
        mTextLabel.setText(product.getName());
    }
}
