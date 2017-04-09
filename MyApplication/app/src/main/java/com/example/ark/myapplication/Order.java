package com.example.ark.myapplication;

/**
 * Created by Nicolas on 3/26/2017.
 */

public class Order {

    //private variables
    int _oid = -1;
    int _createdBy;
    int _fulfilledBy;
    String _approved;

    public Order(){

    }

    public Order(String approved, int createdBy, int fulfilledBy) {
        this._approved = approved;
        this._createdBy = createdBy;
        this._fulfilledBy = fulfilledBy;

    }

    public Order(int oid, String approved, int createdBy, int fulfilledBy){
        this._oid = oid;
        this._approved = approved;
        this._createdBy = createdBy;
        this._fulfilledBy = fulfilledBy;

    }

    //Getters and Setters for attributes
    public int getOid(){
        return this._oid;
    }

    public void setOid(int oid){
        this._oid = oid;
    }

    public String getApproved(){return this._approved;}

    public void setApproved(String approved){this._approved = approved;}

    //Relationships
    public int getCreatedBy(){return this._createdBy;}

    public void setCreatedBy(int createdBy){
        this._createdBy = createdBy;
    }

    public int getFulfilledBy() {return this._fulfilledBy;}

    public void setFulfilledBy(int fulfilledBy){this._fulfilledBy = fulfilledBy;}
}
