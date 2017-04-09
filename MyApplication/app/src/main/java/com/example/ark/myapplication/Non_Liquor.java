package com.example.ark.myapplication;

/**
 * Created by Nicolas on 3/29/2017.
 */

public class Non_Liquor extends Products {

    String _volume;

    public Non_Liquor(){

    }

    public Non_Liquor(int cspc, String volume){
        this._cspc = cspc;
        this._volume = volume;
    }


    public String getVolume() {return this._volume;}
    public void setVolume(String volume){this._volume = volume;}
}
