package com.example.ark.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

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

        Button addButton = (Button)findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                addCustomerDialog();
            }
        } );


        cList = new ArrayList<Customer>();
//        for(int i = 0; i < 10; i++){
//            Customer cTemp = new Customer();
//            cTemp.setCid(123456 + i);
//            cTemp.setDiscount("10%");
//            cTemp.setFname("John");
//            cTemp.setLname("Smith");
//            cTemp.setPhoneNumber("403-123-4567");
//
//
//            cList.add(cTemp);
//        }
        DatabaseHandler db = new DatabaseHandler();
        try {
            cList = db.getAllCustomers();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }

        LinearLayout custLayout = (LinearLayout)findViewById(R.id.customerList);

        for(Customer c : cList){
            final int cid = c.getCid();
            CustomerItem temp = new CustomerItem(this);
            temp.setName(c);
            temp.setCID(c);
            temp.setOnClickListener(new detailOnClickListener(c));
            (temp.findViewById(R.id.deleteButton)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view){
                    removeFromList(cid);
                }
            });

            custLayout.addView(temp);
        }

    }

    private class detailOnClickListener implements View.OnClickListener {

        Customer cust;
        public detailOnClickListener(Customer c){
            cust = c;
        }
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

    private void addCustomerDialog(){
        //make pop-up appear with editable text fields
        //set the text fields' default text to whatever the current values are
        //when OK is hit, send changes to db and update the labels
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Edit Customer Info");
        final LinearLayout dLayout = new LinearLayout(this);
        dLayout.setOrientation(LinearLayout.VERTICAL);


        //all the input fields
        final EditText fn = new EditText(this);
        fn.setHint("First Name");
        final EditText ln = new EditText(this);
        ln.setHint("Last Name");
        final EditText custID = new EditText(this);
        custID.setHint("Customer ID");
        final EditText pNum = new EditText(this);
        pNum.setHint("Phone Number");
        final EditText disc = new EditText(this);
        disc.setHint("Customer Specific Discount");

        //add to layout
        dLayout.addView(fn);
        dLayout.addView(ln);
        dLayout.addView(custID);
        dLayout.addView(pNum);
        dLayout.addView(disc);

        builder.setView(dLayout);
        //set buttons and listeners
        builder.setPositiveButton("Save Changes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which){
                String fn = ((EditText)dLayout.getChildAt(0)).getText().toString();
                String ln = ((EditText)dLayout.getChildAt(1)).getText().toString();
                String cid = ((EditText)dLayout.getChildAt(2)).getText().toString();
                String pn = ((EditText)dLayout.getChildAt(3)).getText().toString();
                String disc = ((EditText)dLayout.getChildAt(4)).getText().toString();

                addCust(fn, ln, cid, pn, disc);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                dialog.cancel();
            }
        });

        builder.show();
    }

    private void addCust(String in_Fname, String in_Lname, String in_ID, String in_PN, String in_disc) {
        LinearLayout custLayout = (LinearLayout)findViewById(R.id.customerList);

        Customer c = new Customer();
        c.setCid(Integer.parseInt(in_ID));
        c.setDiscount(in_disc + "%");
        c.setFname(in_Fname);
        c.setLname(in_Lname);
        c.setPhoneNumber(in_PN);

        CustomerItem temp = new CustomerItem(this);
        temp.setName(c);
        temp.setCID(c);
        temp.setOnClickListener(new detailOnClickListener(c));

        custLayout.addView(temp);
//
//        ((TextView)findViewById(R.id.custID)).setText("Customer ID: " + in_ID);
//        ((TextView)findViewById(R.id.phoneNum)).setText("Phone Number: " + in_PN);
//        ((TextView)findViewById(R.id.name)).setText(in_Fname + " " + in_Lname);
//        ((TextView)findViewById(R.id.discount)).setText("Customer Specific Discount: " + in_disc);
        //Customer cust = new Customer(in_Fname, in_Lname, in_PN, in_disc);
        MainActivity.db.addCustomer(c);
    }

    private void removeFromList(int cid){
        LinearLayout custLayout = (LinearLayout)findViewById(R.id.customerList);
        for(int i = 0; i < custLayout.getChildCount(); i++){
            CustomerItem ci = (CustomerItem)custLayout.getChildAt(i);
            TextView t = (TextView)ci.findViewById(R.id.CID);
            String s = t.getText().toString();
            if(Integer.parseInt(s) == cid) {
                custLayout.removeView(custLayout.getChildAt(i));
                MainActivity.db.deleteCustomer(cid);
            }
        }
    }
}
