/*
Manmeet Dhaliwal
471 Demo Project to show how to connect to MS SQL database
 */

package com.example.ark.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    Connection conn;
    String un, pass, db, ip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        ip = "";    //enter ip address here
        db = "";    //emter database name here
        un = "";    //enter username here
        pass = "";  //enter password here
    }

    private void guest() {
        startActivity(new Intent(getApplicationContext(), MainMenuActivity.class));
    }

    private void login() {
        startActivity(new Intent(getApplicationContext(), MainMenuActivity.class));
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
