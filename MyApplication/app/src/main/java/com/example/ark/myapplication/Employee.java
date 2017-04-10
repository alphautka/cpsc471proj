package com.example.ark.myapplication;

/**
 * Created by Nicolas on 3/26/2017.
 */

public class Employee {

    //private variables
    int _ssn;
    String _fname;
    String _mname;
    String _lname;
    int _mgrssn;
    int _worksFor;

    public Employee(){

    }

    public Employee(int ssn, String fname, String mname, String lname, int mgrssn, int worksFor){
        this._ssn = ssn;
        this._fname = fname;
        this._mname = mname;
        this._lname = lname;
        this._mgrssn = mgrssn;
        this._worksFor = worksFor;
    }

    //Getters and Setters for attributes
    public int getSsn(){
        return this._ssn;
    }

    public void setSsn(int ssn){
        this._ssn = ssn;
    }

    public String getFname(){
        return this._fname;
    }

    public void setFname(String fname){
        this._fname = fname;
    }

    public String getMname() {return this._mname;}

    public void setMname(String mname) {this._mname = mname;}

    public String getLname(){
        return this._lname;
    }

    public void setLname(String lname){
        this._lname = lname;
    }

    public int getMgrssn(){
        return this._mgrssn;
    }

    public void setMgrssn(int mgrssn){
        this._mgrssn = mgrssn;
    }

    //Relationships
    public int getWorksFor(){return this._worksFor;}

    public void setWorksFor(int worksFor) {this._worksFor = worksFor;}

}
