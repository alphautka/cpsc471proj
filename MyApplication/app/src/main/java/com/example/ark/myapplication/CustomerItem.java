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

public class CustomerItem extends RelativeLayout {

    public CustomerItem(Context context) {
        super(context);
        initializeViews(context);
    }

    public CustomerItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);
    }

    public CustomerItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initializeViews(context);
    }

    private void initializeViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.activity_customer_item, this);
    }

    public void setName(Customer c) {
        TextView mTextLabel = (TextView) this.findViewById(R.id.nameLabel);
        String cName = c.getFname() + " " + c.getLname();
        mTextLabel.setText(cName);
    }

    public void setCID(Customer c) {
        TextView cidLabel = (TextView)findViewById(R.id.CID);
        cidLabel.setText(Integer.toString(c.getCid()));
    }

}