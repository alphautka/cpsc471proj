package com.example.ark.myapplication;

/**
 * Created by Nicolas on 3/26/2017.
 */

public class Store {

    //private variables
    int _sid;
    String _location;
    int _mgrssn;

    public Store(){

    }

    public Store(int sid, String location, int mgrssn){
        this._sid = sid;
        this._location = location;
        this._mgrssn = mgrssn;
    }

    //Getters and Setters for attributes

    public int getSid(){
        return this._sid;
    }

    public void setSid(int sid){
        this._sid = sid;
    }

    public String getLocation(){
        return this._location;
    }

    public void setLocation(String location){
        this._location = location;
    }

    public int getMgrssn(){
        return this._mgrssn;
    }

    public void setMgrssn(int mgrssn){
        this._mgrssn = mgrssn;
    }
}
