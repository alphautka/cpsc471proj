package com.example.ark.myapplication;

/**
 * Created by Nicolas on 3/26/2017.
 */

public class Distributor {

    //private variables
    int _did = -1;
    String _name;
    int _supplies;

    public Distributor(){

    }

    public Distributor(String name, int supplies){
        this._name = name;
        this._supplies = supplies;
    }

    public Distributor(int did, String name, int supplies){
        this._did = did;
        this._name = name;
        this._supplies = supplies;
    }



    //Getters and Setters for attributes
    public int getDid(){
        return this._did;
    }

    public void setDid(int did){
        this._did = did;
    }

    public String getName(){
        return this._name;
    }

    public void setName(String name){
        this._name = name;
    }

    //Relationships
    public int getSupplies(){return this._supplies;}

    public void setSupplies(int supplies){this._supplies = supplies;}
}
