package com.example.ark.myapplication;

/**
 * Created by Nicolas on 3/26/2017.
 */

public class Products {

    //private variables
    int _cspc;
    float _price;
    String _brand;
    String _name;
    int _quantity;
    String _discount;
    int _offeredBy;

    public Products(){

    }

    public Products(int cspc, float price, String brand, String name, int quantity, String discount, int offeredBy){
        this._cspc = cspc;
        this._price = price;
        this._brand = brand;
        this._name = name;
        this._quantity = quantity;
        this._discount = discount;
        this._offeredBy = offeredBy;
    }



    //getting and setting the attributes
    public int getCspc(){
        return this._cspc;
    }

    public void setCspc(int cspc){
        this._cspc = cspc;
    }

    public float getPrice(){
        return this._price;
    }

    public void setPrice(float price){
        this._price = price;
    }

    public String getBrand(){
        return this._brand;
    }

    public void setBrand(String brand){
        this._brand = brand;
    }

    public String getName(){
        return this._name;
    }

    public void setName(String name){
        this._name = name;
    }

    public int getQuantity(){
        return this._quantity;
    }

    public void setQuantity(int quantity){
        this._quantity = quantity;
    }

    public String getDiscount(){
        return this._discount;
    }

    public void setDiscount(String discount){
        this._discount = discount;
    }

    //Relationships
    public int getOfferedBy(){return this._offeredBy;}

    public void setOfferedBy(int offeredBy){this._offeredBy = offeredBy;}
}
