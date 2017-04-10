package com.example.ark.myapplication;

/**
 * Created by Nicolas on 3/29/2017.
 */

public class Misc extends Products {

    String _mtype;

    public Misc(){

    }

    public Misc(int cspc, String mtype){
        this._cspc = cspc;
        this._mtype = mtype;
    }


    public String getMtype(){return this._mtype;}

    public void setMtype(String mtype){this._mtype = mtype;}
}
