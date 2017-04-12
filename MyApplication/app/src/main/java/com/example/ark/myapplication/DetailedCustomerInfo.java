package com.example.ark.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailedCustomerInfo extends AppCompatActivity {

    private String in_ID = "";
    private String in_PN = "";
    private String in_disc = "";
    private String in_Fname = "";
    private String in_Lname = "";

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
        in_ID = getIntent().getStringExtra("cid");
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
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Edit Customer Info");
        final LinearLayout dLayout = new LinearLayout(this);
        dLayout.setOrientation(LinearLayout.VERTICAL);


        //all the input fields
        final EditText fn = new EditText(this);
        fn.setHint("First Name");
        final EditText ln = new EditText(this);
        ln.setHint("Last Name");
//        final EditText custID = new EditText(this);
//        custID.setHint("Customer ID");
        final EditText pNum = new EditText(this);
        pNum.setHint("Phone Number");
        final EditText disc = new EditText(this);
        disc.setHint("Customer Specific Discount");

        //add to layout
        dLayout.addView(fn);
        dLayout.addView(ln);
        //dLayout.addView(custID);
        dLayout.addView(pNum);
        dLayout.addView(disc);

        builder.setView(dLayout);
        //set buttons and listeners
        builder.setPositiveButton("Save Changes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which){
                in_Fname = ((EditText)dLayout.getChildAt(0)).getText().toString();
                in_Lname = ((EditText)dLayout.getChildAt(1)).getText().toString();
                //in_ID = ((EditText)dLayout.getChildAt(2)).getText().toString();
                in_PN = ((EditText)dLayout.getChildAt(2)).getText().toString();
                in_disc = ((EditText)dLayout.getChildAt(3)).getText().toString();

                changed();
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

    private void changed() {
        ((TextView)findViewById(R.id.custID)).setText("Customer ID: " + in_ID);
        ((TextView)findViewById(R.id.phoneNum)).setText("Phone Number: " + in_PN);
        ((TextView)findViewById(R.id.name)).setText(in_Fname + " " + in_Lname);
        ((TextView)findViewById(R.id.discount)).setText("Customer Specific Discount: " + in_disc);

        Customer c = new Customer(in_Fname, in_Lname, in_PN, in_disc);
        c.setCid(Integer.parseInt(in_ID));

        MainActivity.db.updateCustomer(c);
    }

}
