package com.example.ark.myapplication;

/**
 * Created by Nicolas on 3/29/2017.
 */

public class Liquor extends Products {

    String _concentration;
    String _volume;
    String _ltype;

    public Liquor(){

    }

    public Liquor(int cspc, String concentration, String volume, String ltype){
        this._cspc = cspc;
        this._concentration = concentration;
        this._volume = volume;
        this._ltype = ltype;
    }

    public Liquor(int cspc, float price, String brand, String name, int quantity, String discount, int offeredBy){
        this._cspc = cspc;
        this._price = price;
        this._brand = brand;
        this._name = name;
        this._quantity = quantity;
        this._discount = discount;
        this._offeredBy = offeredBy;
    }

    public String getConcentration() {return this._concentration;}

    public void setConcentration(String concentration){this._concentration = concentration;}

    public String getVolume(){return this._volume;}

    public void setVolume(String volume){this._volume = volume;}

    public String getLtype(){return this._ltype;}

    public void setLtype(String ltype){this._ltype = ltype;}

}
