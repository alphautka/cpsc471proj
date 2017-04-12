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

import java.util.ArrayList;
import java.util.List;

public class EmployeeList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);
        List<Employee> eList = null;
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


        eList = new ArrayList<Employee>();
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
        try {
            eList = MainActivity.db.getAllEmployees();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }

        LinearLayout empLayout = (LinearLayout)findViewById(R.id.employeeList);

        for(Employee e : eList){
            final int eid = e.getSsn();
            EmployeeItem temp = new EmployeeItem(this);
            temp.setName(e);
            temp.setEID(e);
            (temp.findViewById(R.id.deleteButton)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view){
                    removeFromList(eid);
                }
            });

            empLayout.addView(temp);
        }

    }



    private void addCustomerDialog(){
        //make pop-up appear with editable text fields
        //set the text fields' default text to whatever the current values are
        //when OK is hit, send changes to db and update the labels
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Edit Employee Info");
        final LinearLayout dLayout = new LinearLayout(this);
        dLayout.setOrientation(LinearLayout.VERTICAL);


        //all the input fields
        final EditText fn = new EditText(this);
        fn.setHint("First Name");
        final EditText ln = new EditText(this);
        ln.setHint("Last Name");
        final EditText custID = new EditText(this);
        custID.setHint("Employee SSN");
        //final EditText pNum = new EditText(this);
        /*
        pNum.setHint("Phone Number");
        final EditText disc = new EditText(this);
        disc.setHint("Customer Specific Discount");
        */

        //add to layout
        dLayout.addView(fn);
        dLayout.addView(ln);
        dLayout.addView(custID);
        //dLayout.addView(pNum);
        //dLayout.addView(disc);

        builder.setView(dLayout);
        //set buttons and listeners
        builder.setPositiveButton("Save Changes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which){
                String fn = ((EditText)dLayout.getChildAt(0)).getText().toString();
                String ln = ((EditText)dLayout.getChildAt(1)).getText().toString();
                String cid = ((EditText)dLayout.getChildAt(2)).getText().toString();
                //String pn = ((EditText)dLayout.getChildAt(3)).getText().toString();
                //String disc = ((EditText)dLayout.getChildAt(4)).getText().toString();

                addCust(fn, ln, cid);
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

    private void addCust(String in_Fname, String in_Lname, String in_ID) {
        LinearLayout custLayout = (LinearLayout)findViewById(R.id.employeeList);

        Employee c = new Employee();
        c.setSsn(Integer.parseInt(in_ID));

        //c.setDiscount(in_disc + "%");
        c.setFname(in_Fname);
        c.setLname(in_Lname);
        //c.setPhoneNumber(in_PN);

        EmployeeItem temp = new EmployeeItem(this);
        temp.setName(c);
        temp.setEID(c);
        final int eid = c.getSsn();
        ((ImageButton)(temp.findViewById(R.id.deleteButton))).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                removeFromList(eid);
            }
        });

        custLayout.addView(temp);
//
//        ((TextView)findViewById(R.id.custID)).setText("Customer ID: " + in_ID);
//        ((TextView)findViewById(R.id.phoneNum)).setText("Phone Number: " + in_PN);
//        ((TextView)findViewById(R.id.name)).setText(in_Fname + " " + in_Lname);
//        ((TextView)findViewById(R.id.discount)).setText("Customer Specific Discount: " + in_disc);
        //Customer cust = new Customer(in_Fname, in_Lname, in_PN, in_disc);
        MainActivity.db.addEmployee(c);
    }

    private void removeFromList(int eid){
        LinearLayout custLayout = (LinearLayout)findViewById(R.id.employeeList);
        for(int i = 0; i < custLayout.getChildCount(); i++){
            EmployeeItem ci = (EmployeeItem)custLayout.getChildAt(i);
            TextView t = (TextView)ci.findViewById(R.id.EID);
            String s = t.getText().toString();
            if(Integer.parseInt(s) == eid) {
                custLayout.removeView(custLayout.getChildAt(i));
                MainActivity.db.deleteEmployee(eid);
            }
        }
    }
}
