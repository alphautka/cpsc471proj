package com.example.ark.myapplication;

/**
 * Created by Nicolas on 3/26/2017.
 */

public class Customer {

    //private variables
    int _cid = -1;
    String _fname;
    String _lname;
    String _phone_number;
    String _discount;

    public Customer(){

    }

    public Customer(String fname, String lname, String phone_number, String discount){
        this._fname = fname;
        this._lname = lname;
        this._phone_number = phone_number;
        this._discount = discount;
    }

    public Customer(int cid, String fname, String lname, String phone_number, String discount){
        this._cid = cid;
        this._fname = fname;
        this._lname = lname;
        this._phone_number = phone_number;
        this._discount = discount;
    }

    //Getters and Setters for attributes
    public int getCid(){
        return this._cid;
    }

    public void setCid(int cid){
        this._cid = cid;
    }

    public String getFname(){
        return this._fname;
    }

    public void setFname(String fname){
        this._fname = fname;
    }

    public String getLname(){
        return this._lname;
    }

    public void setLname(String lname){
        this._lname = lname;
    }

    public String getPhoneNumber(){
        return this._phone_number;
    }

    public void setPhoneNumber(String phone_number){
        this._phone_number = phone_number;
    }

    public String getDiscount(){
        return this._discount;
    }

    public void setDiscount(String discount){
        this._discount = discount;
    }
}
