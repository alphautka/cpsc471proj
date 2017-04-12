package com.example.ark.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_list);
        List<Customer> cList = null;
//        try {
//            cList = MainActivity.db.getAllCustomers();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        cList = new ArrayList<Customer>();
        for(int i = 0; i < 10; i++){
            Customer cTemp = new Customer();
            cTemp.setCid(123456);
            cTemp.setDiscount("10%");
            cTemp.setFname("John");
            cTemp.setLname("Smith");
            cTemp.setPhoneNumber("403-123-4567");

            cList.add(cTemp);
        }

        LinearLayout custLayout = (LinearLayout)findViewById(R.id.customerList);

        for(Customer c : cList){
            CustomerItem temp = new CustomerItem(this);
            temp.setName(c);
            temp.setCID(c);
            temp.setOnClickListener(new detailOnClickListener(c));

            custLayout.addView(temp);
        }

    }

    private class detailOnClickListener implements View.OnClickListener {

        Customer cust;
        public detailOnClickListener(Customer c){
            cust = c;
        }

        @Override
        public void onClick(View view){
            detailCustomer(cust);
        }
    }

    public void detailCustomer(Customer c){
        Intent i = new Intent(getApplicationContext(), DetailedCustomerInfo.class);
        i.putExtra("name", c.getFname() + " " + c.getLname());
        i.putExtra("cid", Integer.toString(c.getCid()));
        i.putExtra("phone", c.getPhoneNumber());
        i.putExtra("discount", c.getDiscount());
        startActivity(i);
    }
}
