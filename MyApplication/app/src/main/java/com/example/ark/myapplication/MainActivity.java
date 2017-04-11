/*
Manmeet Dhaliwal
471 Demo Project to show how to connect to MS SQL database
 */

package com.example.ark.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    public static final DatabaseHandler dbh = new DatabaseHandler();

    Connection conn;
    String un, pass, db, ip;



    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ip = "136.159.7.84:50001";    //enter ip address here
        db = "CPSC471_Winter2017";    //emter database name here
        un = "CPSC471_Winter2017";    //enter username here
        pass = "6VXVM_0~rq1F-$W";  //enter password here


        Button loginButton = (Button)findViewById(R.id.loginButton);
        Button guestButton = (Button)findViewById(R.id.guestButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                login();
            }
        } );

        guestButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                guest();
            }
        } );


        //NOTE: Fill these attributes before you execute this program
        //NOTE: For ip address, if you are provided with a port number, the format will be "ipaddress:portnumber"
        /*ip = "136.159.7.84:50001";    //enter ip address here
        db = "CPSC471_Winter2017";    //emter database name here
        un = "CPSC471_Winter2017";    //enter username here
        pass = "6VXVM_0~rq1F-$W";  //enter password here*/

        conn = dbh.connectionclass(un, pass, db, ip);
    }

    private void guest() {
        Intent i = new Intent(getApplicationContext(), MainMenuActivity.class);
        i.putExtra("PriviledgedUser", false);
        startActivity(i);
    }

    private void login() {
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);

        String username = "username";
        String password = "password";

        EditText user_in = (EditText) findViewById(R.id.username);
        EditText pass_in = (EditText) findViewById(R.id.password);
        //query db for actual username/pw here

        List<String> uns = new ArrayList<>();
        List<String> pws = new ArrayList<>();

        DatabaseHandler dbh_test = new DatabaseHandler(conn, un, pass, db, ip);

        List<LoginInfo> infoList = new ArrayList<>();

        try {
            infoList = dbh_test.getAllCredentials();
            Log.d("STATE", "succesful retrieve");
            //Log.d("STATE", infoList.get(0).getUn());



        } catch (Exception e) {
            e.printStackTrace();
        }

        String inputuser = user_in.getText().toString();
        String inputpass = pass_in.getText().toString();

        Boolean successful = false;

        for (LoginInfo loginfo: infoList){
            Log.d("DEBUG", loginfo.getUn());
            Log.d("DEBUG", inputuser);
            if (inputuser.equals(loginfo.getUn()) && inputpass.equals(loginfo.getPw())){
                successful = true;
                break;
            }
        }

        //if returned result is empty
            //show login error
        TextView errMsg = (TextView)findViewById(R.id.ErrorMsg);
        if (!successful){
            //show login error
            errMsg.setVisibility(View.VISIBLE);
        }else{
            errMsg.setVisibility(View.INVISIBLE);
            user_in.setText("");
            pass_in.setText("");
            Intent i = new Intent(getApplicationContext(), EmployeeView.class);
            i.putExtra("PriviledgedUser", true);

            startActivity(i);
        }



    }

    //Make sure to link the method to the button using the activity_main.xml file, click on the button, go to properties
    //and add this method under "onClick" property
   /* public void onButtonClickConnect(View v){
        conn = connectionclass(un, pass, db, ip);

        TextView t1 = (TextView)findViewById(R.id.result);
        if(conn == null){
            t1.setText("No");
        }else{
            t1.setText("Yes");

            try {
                //Inserting into the database with db = database name
                //dbo.names is the table name
                //standard format for accessing the sql server provided through Tamer is the following
                String query = "INSERT INTO " + db + ".dbo.names VALUES ('John');";
                Statement stmt = conn.createStatement();
                stmt.execute(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //connection class
    @SuppressLint("NewApi")
    public Connection connectionclass (String user, String pass, String db, String server){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String connectionURL = null;

        try{
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            connectionURL = "jdbc:jtds:sqlserver://" + server + ";" + "databseName=" + db + ";user=" + user + ";password=" + pass + ";";
            connection = DriverManager.getConnection(connectionURL);

        }catch(Exception e){
            Log.e("Error: ", e.getMessage());
        }

        return connection;
    } */
}
