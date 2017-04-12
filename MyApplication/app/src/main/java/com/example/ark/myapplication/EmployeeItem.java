package com.example.ark.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class EmployeeItem extends RelativeLayout {

    public EmployeeItem(Context context) {
        super(context);
        initializeViews(context);
    }

    public EmployeeItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeViews(context);
    }

    public EmployeeItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initializeViews(context);
    }

    private void initializeViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.activity_employee_item, this);
    }

    public void setName(Employee e) {
        TextView mTextLabel = (TextView) this.findViewById(R.id.nameLabel);
        String cName = e.getFname() + " " + e.getLname();
        mTextLabel.setText(cName);
    }

    public void setEID(Employee e){
        TextView cidLabel = (TextView)findViewById(R.id.EID);
        cidLabel.setText(Integer.toString(e.getSsn()));
    }

}
