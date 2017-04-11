package com.example.ark.myapplication;

/**
 * Created by Nicolas on 4/10/2017.
 */

public class LoginInfo {

    private String un;
    private String pw;

    public LoginInfo(){}

    public LoginInfo(String un, String pw){
        this.un = un;
        this.pw = pw;
    }

    public String getUn(){return this.un;}

    public void setUn(String un){this.un = un;}

    public String getPw() {return this.pw;}

    public void setPw(String pw) {this.pw = pw;}

}
