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
import java.util.ArrayList;
import java.util.List;

public class MainMenuActivity extends AppCompatActivity {

    Connection conn;
    String un, pass, db, ip;
    DatabaseHandler dbh;
    List<Liquor> liquorList;
    List<Non_Liquor> nliquorList;
    List<Misc> miscList;
    Liquor liquor = new Liquor(1, "14%", "250mL", "Wine");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        ip = "136.159.7.84:50001";    //enter ip address here
        db = "CPSC471_Winter2017";    //emter database name here
        un = "CPSC471_Winter2017";    //enter username here
        pass = "6VXVM_0~rq1F-$W";  //enter password here

        liquorList = new ArrayList<>();
        nliquorList = new ArrayList<>();
        miscList = new ArrayList<>();


        final Button liquorButton = (Button)findViewById(R.id.liquorButton);
        Button nonLiquorButton = (Button)findViewById(R.id.nonLiquorButton);
        Button miscButton = (Button)findViewById(R.id.miscButton);

        liquorButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                conn = connectionclass(un, pass, db, ip);
                TextView t1 = (TextView)findViewById(R.id.result);
                TextView test = (TextView)findViewById(R.id.test);
                if(conn == null){
                    t1.setText("No");
                }else{
                    t1.setText("Yes");

                    dbh = new DatabaseHandler(conn, un, pass, db, ip);

                    try {

                        liquorList = dbh.getAllLiquors();
                        int liquorCount = dbh.getLiquorCount();
                        t1.setText("Retrieved All Liquor");
                        test.setText(String.valueOf(liquorCount));
                    } catch(Exception e){e.printStackTrace();}
               // liquor();
            }
        } });

        nonLiquorButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                conn = connectionclass(un, pass, db, ip);
                TextView t1 = (TextView)findViewById(R.id.result);
                if(conn == null){
                    t1.setText("No");
                }else{
                    t1.setText("Yes");


                    dbh = new DatabaseHandler(conn, un, pass, db, ip);

                    try {
                        nliquorList = dbh.getAllNonLiquors();
                        t1.setText("Retrieved All Non-Liquor");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                //nonLiquor();
            }
        } });

        miscButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                conn = connectionclass(un, pass, db, ip);
                TextView t1 = (TextView)findViewById(R.id.result);
                if(conn == null){
                    t1.setText("No");
                }else{
                    t1.setText("Yes");
                    dbh = new DatabaseHandler(conn, un, pass, db, ip);

                    try{


                        miscList = dbh. getAllMiscs();
                        t1.setText("Retrieved All Misc");

                    }catch (SQLException e) {
                        e.printStackTrace();
                    }

                //miscellaneous();
            }
        } });
    }

    private void miscellaneous(){
        startActivity(new Intent(getApplicationContext(), CatalogListActivity.class));
    }

    private void liquor(){
        startActivity(new Intent(getApplicationContext(), CatalogListActivity.class));
    }
    private void nonLiquor(){
        startActivity(new Intent(getApplicationContext(), CatalogListActivity.class));
    }




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
    }
}
