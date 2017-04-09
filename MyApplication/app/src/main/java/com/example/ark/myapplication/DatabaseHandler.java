package com.example.ark.myapplication;

import android.provider.ContactsContract;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicolas on 4/7/2017.
 */

public class DatabaseHandler {

    Connection conn;
    String username, pass, db, ip;

    public DatabaseHandler(){}

    public DatabaseHandler(Connection connection, String username, String pass, String db, String ip){
        this.conn = connection;
        this.username = username;
        this.pass = pass;
        this.db  = db;
        this.ip = ip;
    }

    private static final String TABLE_PRODUCTS = "PRODUCTS";
    private static final String TABLE_LIQUOR = "LIQUOR";
    private static final String TABLE_NON_LIQUOR = "NON_LIQUOR";
    private static final String TABLE_MISC = "MISC";
    private static final String TABLE_STORE = "STORE";
    private static final String TABLE_EMPLOYEE = "EMPLOYEE";
    private static final String TABLE_CUSTOMER = "CUSTOMER";
    private static final String TABLE_DISTRIBUTOR = "DISTRIBUTOR";
    private static final String TABLE_ORDER = "ORDER";
    private static final String TABLE_CONTAINS = "CONTAINS";
    private static final String TABLE_MANAGES = "MANAGES";
    private static final String TABLE_PROVIDES = "PROVIDES";
    private static final String TABLE_SEARCHES = "SEARCHES";
    private static final String TABLE_EMPLOYEE_SELECTION = "EMPLOYEE_SELECTION";


     /*
    Insert
     */


    public void addProduct (Products product){
        try {
            String query = "INSERT INTO " + db + "." + TABLE_PRODUCTS + " VALUES (" + product.getCspc() + ", " + product.getPrice() + ", '" + product.getBrand() + "', '" + product.getName() + "', " + product.getQuantity() + ", '" + product.getDiscount() + "', " + product.getOfferedBy() + ");";
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    //Add specific products to specific tables

    public void addLiquor(Liquor liquor) {
        try {
            String query = "INSERT INTO " + db + ".dbo." + TABLE_LIQUOR + " VALUES (" + liquor.getCspc() + ", '" + liquor.getConcentration() + "', '" + liquor.getVolume() + "', '" + liquor.getLtype() + "');";
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addNonLiquor(Non_Liquor nliquor) {
        try {
            String query = "INSERT INTO " + db + ".dbo." + TABLE_NON_LIQUOR + " VALUES (" + nliquor.getCspc() + ", '" + nliquor.getVolume() + "');";
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addMisc(Misc misc) {
        try {
            String query = "INSERT INTO " + db + ".dbo." + TABLE_MISC + " VALUES (" + misc.getCspc() + ", '" + misc.getMtype() + "');";
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addStore(Store store) {
        try {
            String query = "INSERT INTO " + db + "." + TABLE_STORE + " VALUES (" + store.getSid() + ", '" + store.getLocation() + "', " + store.getMgrssn() + ");";
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addEmployee(Employee employee) {
        try {
            String query = "INSERT INTO " + db + "." + TABLE_EMPLOYEE + " VALUES (" + employee.getSsn() + ", '" + employee.getFname() + "', '" + employee.getMname() + "', '" + employee.getLname() + "', " + employee.getMgrssn() + ", " + employee.getWorksFor() + ");";
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCustomer(Customer customer) {
        try {
            String query = "INSERT INTO " + db + "." + TABLE_CUSTOMER + " VALUES (" + customer.getCid() + ", '" + customer.getFname() + "', '" + customer.getLname() + "', '" + customer.getPhoneNumber() + "', '" + customer.getDiscount() + "');";
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addDistributor(Distributor distributor) {
        try {
            String query = "INSERT INTO " + db + "." + TABLE_DISTRIBUTOR + " VALUES (" + distributor.getDid() + ", '" + distributor.getName() + "', " + distributor.getSupplies() + ");";
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addOrder(Order order) {
        try {
            String query = "INSERT INTO " + db + "." + TABLE_ORDER + " VALUES (" + order.getOid() + ", '" + order.getApproved() + "', " + order.getCreatedBy() + ", " + order.getFulfilledBy() + ");";
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //TODO make objects?


    public void addContains(int cpcspc, int ooid){
        try {
            String query = "INSERT INTO " + db + "." + TABLE_CONTAINS + " VALUES (" + cpcspc + ", " + ooid + ");";
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addManages(int essn, int mgrssn){
        try {
            String query = "INSERT INTO " + db + "." + TABLE_MANAGES + " VALUES (" + essn + ", " + mgrssn + ");";
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addProvides(int ppcspc, int ddid){
        try {
            String query = "INSERT INTO " + db + "." + TABLE_PROVIDES + " VALUES (" + ppcspc + ", " + ddid + ");";
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addSearches(int essn, int cusid, int spcspc){
        try {
            String query = "INSERT INTO " + db + "." + TABLE_SEARCHES + " VALUES (" + essn + ", " + cusid + ", " + spcspc + ");";
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //TODO?
    public void addEmployeeSelection(int essn, Products product){
        try {
            String query = "INSERT INTO " + db + "." + TABLE_EMPLOYEE_SELECTION + " VALUES (" + essn + ", " + product.getCspc() + ", " + product.getPrice() + ", '" + product.getBrand() + "', '" + product.getName() + "', " + product.getQuantity() + ", '" + product.getDiscount() + "', " + product.getOfferedBy() + ");";
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /*
    Retrieve One
     */

    public Products getProduct(int cspc){
        String query = "SELECT * FROM " + db + ".dbo." + TABLE_PRODUCTS + " WHERE CSPC = " + cspc + ";";
        Products product = new Products();
        try {

            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);


            product.setCspc(result.getInt("CSPC"));
            product.setPrice(result.getFloat("PRICE"));
            product.setBrand(result.getString("BRAND"));
            product.setName(result.getString("NAME"));
            product.setQuantity(result.getInt("QUANTITY"));
            product.setDiscount(result.getString("DOUBLE"));
            product.setOfferedBy(result.getInt("OFFERED_BY"));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }


    //Get specific product from specific tables
    public Products getLiquor(int cspc){
        String query = "SELECT * FROM " + db + ".dbo." + TABLE_LIQUOR + " WHERE CSPC = " + cspc + ";";
        Products product = new Products();
        try {

            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);


            product.setCspc(result.getInt("CSPC"));
            product.setPrice(result.getFloat("PRICE"));
            product.setBrand(result.getString("BRAND"));
            product.setName(result.getString("NAME"));
            product.setQuantity(result.getInt("QUANTITY"));
            product.setDiscount(result.getString("DOUBLE"));
            product.setOfferedBy(result.getInt("OFFERED_BY"));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public Products getNonLiquor(int cspc){
        String query = "SELECT * FROM " + db + ".dbo." + TABLE_NON_LIQUOR + " WHERE CSPC = " + cspc + ";";
        Products product = new Products();
        try {

            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);


            product.setCspc(result.getInt("CSPC"));
            product.setPrice(result.getFloat("PRICE"));
            product.setBrand(result.getString("BRAND"));
            product.setName(result.getString("NAME"));
            product.setQuantity(result.getInt("QUANTITY"));
            product.setDiscount(result.getString("DOUBLE"));
            product.setOfferedBy(result.getInt("OFFERED_BY"));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }


    public Products getMisc(int cspc){
        String query = "SELECT * FROM " + db + ".dbo." + TABLE_MISC + " WHERE CSPC = " + cspc + ";";
        Products product = new Products();
        try {

            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);


            product.setCspc(result.getInt("CSPC"));
            product.setPrice(result.getFloat("PRICE"));
            product.setBrand(result.getString("BRAND"));
            product.setName(result.getString("NAME"));
            product.setQuantity(result.getInt("QUANTITY"));
            product.setDiscount(result.getString("DOUBLE"));
            product.setOfferedBy(result.getInt("OFFERED_BY"));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public Store getStore(int sid){
        String query = "SELECT * FROM " + db + "." + TABLE_STORE + " WHERE SID = " + sid + ";";
        Store store = new Store();
        try {

            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);

            store.setSid(result.getInt("SID"));
            store.setLocation(result.getString("LOCATION"));
            store.setMgrssn(result.getInt("MGRSSN"));



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return store;
    }


    public Employee getEmployee(int ssn){
        String query = "SELECT * FROM " + db + "." + TABLE_EMPLOYEE + " WHERE SSN = " + ssn + ";";
        Employee employee = new Employee();
        try {

            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);

            employee.setSsn(result.getInt("SSN"));
            employee.setFname(result.getString("FNAME"));
            employee.setMname(result.getString("MNAME"));
            employee.setLname(result.getString("LNAME"));
            employee.setMgrssn(result.getInt("MGRSSN"));
            employee.setWorksFor(result.getInt("WORKS_FOR"));




        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }


    public Customer getCustomer(int cid){
        String query = "SELECT * FROM " + db + "." + TABLE_CUSTOMER + " WHERE CID = " + cid + ";";
        Customer customer = new Customer();
        try {

            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);


            customer.setCid(result.getInt("CID"));
            customer.setFname(result.getString("FNAME"));
            customer.setLname(result.getString("LNAME"));
            customer.setPhoneNumber(result.getString("PHONE_NUMBER"));
            customer.setDiscount(result.getString("DISCOUNT"));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public Distributor getDistributor(int did){
        String query = "SELECT * FROM " + db + "." + TABLE_DISTRIBUTOR + " WHERE DID = " + did + ";";
        Distributor distributor = new Distributor();
        try {

            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);


            distributor.setDid(result.getInt("DID"));
            distributor.setName(result.getString("NAME"));
            distributor.setSupplies(result.getInt("SUPPLIES"));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return distributor;
    }


    public Order getOrder(int oid){
        String query = "SELECT * FROM " + db + "." + TABLE_ORDER + " WHERE OID = " + oid + ";";
        Order order = new Order();
        try {

            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);

            order.setOid(result.getInt("OID"));
            order.setApproved(result.getString("APPROVED"));
            order.setCreatedBy(result.getInt("CREATED_BY"));
            order.setFulfilledBy(result.getInt("FULFILLED_BY"));



        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    //TODO make relationship getters

    //TODO?
    public Products getEmployeeSelection(int ssn){
        String query = "SELECT * FROM " + db + "." + TABLE_EMPLOYEE_SELECTION + " WHERE ESSN = " + ssn + ";";
        Products product = new Products();
        try {

            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);


            product.setCspc(result.getInt("CSPC"));
            product.setPrice(result.getFloat("PRICE"));
            product.setBrand(result.getString("BRAND"));
            product.setName(result.getString("NAME"));
            product.setQuantity(result.getInt("QUANTITY"));
            product.setDiscount(result.getString("DOUBLE"));
            product.setOfferedBy(result.getInt("OFFERED_BY"));


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    /*
    Retrieve All
     */

    public List<Products> getAllProducts() throws SQLException{
        String query = "SELECT * FROM " + db + ".dbo." + TABLE_PRODUCTS + ";";
        List<Products> productList = new ArrayList<Products>();

        Statement stmt = null;
        try {

            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while(result.next()){
                Products product = new Products();
                product.setCspc(result.getInt("CSPC"));
                product.setPrice(result.getFloat("PRICE"));
                product.setBrand(result.getString("BRAND"));
                product.setName(result.getString("NAME"));
                product.setQuantity(result.getInt("QUANTITY"));
                product.setDiscount(result.getString("DOUBLE"));
                product.setOfferedBy(result.getInt("OFFERED_BY"));
                productList.add(product);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {stmt.close();}
        }
        return productList;
    }


    //Special cases
    public List<Liquor> getAllLiquors() throws SQLException{
        String query = "SELECT * FROM " + db + ".dbo." + TABLE_LIQUOR + ";";
        List<Liquor> productList = new ArrayList<Liquor>();

        Statement stmt = null;
        try {

            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while(result.next()){
                Liquor product = new Liquor();
                product.setCspc(result.getInt("CSPC"));
                product.setConcentration(result.getString("CONCENTRATION"));
                product.setVolume(result.getString("VOLUME"));

                productList.add(product);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {stmt.close();}
        }
        return productList;
    }

    public List<Non_Liquor> getAllNonLiquors() throws SQLException{
        String query = "SELECT * FROM " + db + ".dbo." + TABLE_NON_LIQUOR + ";";
        List<Non_Liquor> productList = new ArrayList<Non_Liquor>();

        Statement stmt = null;
        try {

            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while(result.next()){
                Non_Liquor product = new Non_Liquor();
                product.setCspc(result.getInt("CSPC"));
                product.setVolume(result.getString("VOLUME"));
                productList.add(product);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {stmt.close();}
        }
        return productList;
    }

    public List<Misc> getAllMiscs() throws SQLException{
        String query = "SELECT * FROM " + db + ".dbo." + TABLE_MISC + ";";
        List<Misc> productList = new ArrayList<Misc>();

        Statement stmt = null;
        try {

            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while(result.next()){
                Misc product = new Misc();
                product.setCspc(result.getInt("CSPC"));
                product.setMtype(result.getString("MTYPE"));
                productList.add(product);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {stmt.close();}
        }
        return productList;
    }


    public List<Store> getAllStores() throws SQLException {
        String query = "SELECT * FROM " + db + "." + TABLE_STORE + ";";
        List<Store> storeList = new ArrayList<Store>();

        Statement stmt = null;
        try {

            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while(result.next()){
                Store store = new Store();
                store.setSid(result.getInt("SID"));
                store.setLocation(result.getString("LOCATION"));
                store.setMgrssn(result.getInt("MGRSSN"));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {stmt.close();}
        }
        return storeList;
    }

    public List<Employee> getAllEmployees() throws SQLException {
        String query = "SELECT * FROM " + db + "." + TABLE_EMPLOYEE + ";";
        List<Employee> employeeList = new ArrayList<Employee>();

        Statement stmt = null;
        try {

            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while(result.next()){
                Employee employee = new Employee();
                employee.setSsn(result.getInt("SSN"));
                employee.setFname(result.getString("FNAME"));
                employee.setMname(result.getString("MNAME"));
                employee.setLname(result.getString("LNAME"));
                employee.setMgrssn(result.getInt("MGRSSN"));
                employee.setWorksFor(result.getInt("WORKS_FOR"));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {stmt.close();}
        }
        return employeeList;
    }


    public List<Customer> getAllCustomers() throws SQLException {
        String query = "SELECT * FROM " + db + "." + TABLE_CUSTOMER + ";";
        List<Customer> customerList = new ArrayList<Customer>();

        Statement stmt = null;
        try {

            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while(result.next()){
                Customer customer = new Customer();
                customer.setCid(result.getInt("CID"));
                customer.setFname(result.getString("FNAME"));
                customer.setLname(result.getString("LNAME"));
                customer.setPhoneNumber(result.getString("PHONE_NUMBER"));
                customer.setDiscount(result.getString("DISCOUNT"));


            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {stmt.close();}
        }
        return customerList;
    }

    public List<Distributor> getAllDistributors() throws SQLException {
        String query = "SELECT * FROM " + db + "." + TABLE_DISTRIBUTOR + ";";
        List<Distributor> distributorList = new ArrayList<Distributor>();

        Statement stmt = null;
        try {

            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while(result.next()){
                Distributor distributor = new Distributor();
                distributor.setDid(result.getInt("DID"));
                distributor.setName(result.getString("NAME"));
                distributor.setSupplies(result.getInt("SUPPLIES"));


            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {stmt.close();}
        }
        return distributorList;
    }


    public List<Order> getAllOrders() throws SQLException {
        String query = "SELECT * FROM " + db + "." + TABLE_ORDER + ";";
        List<Order> orderList = new ArrayList<Order>();

        Statement stmt = null;
        try {

            stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);

            while(result.next()){
                Order order = new Order();
                order.setOid(result.getInt("OID"));
                order.setApproved(result.getString("APPROVED"));
                order.setCreatedBy(result.getInt("CREATED_BY"));
                order.setFulfilledBy(result.getInt("FULFILLED_BY"));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {stmt.close();}
        }
        return orderList;
    }

    //TODO make relationship getters

    //TODO? have to make object??
    public List<Products> getAllEmployeeSelections() throws SQLException {
        List<Products> selectionList = new ArrayList<Products>();
        return selectionList;
    }

    /*
    Retrieve number of rows within a table
     */

    public int getProductCount(){
        int count = 0;
        String query = "SELECT COUNT(*) AS rowcount FROM " + db + "." + TABLE_PRODUCTS + ";";
        try {
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            result.next();
            count = result.getInt("rowcount");
            result.close();


        }catch (SQLException e) {e.printStackTrace();}
        return count;
    }


    //For specific products
    public int getLiquorCount(){
        int count = 0;
        String query = "SELECT COUNT(*) AS rowcount FROM " + db + "." + TABLE_LIQUOR + ";";
        try {
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            result.next();
            count = result.getInt("rowcount");
            result.close();


        }catch (SQLException e) {e.printStackTrace();}
        return count;
    }


    public int getNonLiquorCount(){
        int count = 0;
        String query = "SELECT COUNT(*) AS rowcount FROM " + db + "." + TABLE_NON_LIQUOR + ";";
        try {
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            result.next();
            count = result.getInt("rowcount");
            result.close();


        }catch (SQLException e) {e.printStackTrace();}
        return count;
    }

    public int getMiscCount(){
        int count = 0;
        String query = "SELECT COUNT(*) AS rowcount FROM " + db + "." + TABLE_MISC + ";";
        try {
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            result.next();
            count = result.getInt("rowcount");
            result.close();


        }catch (SQLException e) {e.printStackTrace();}
        return count;
    }

    public int getStoreCount(){
        int count = 0;
        String query = "SELECT COUNT(*) AS rowcount FROM " + db + "." + TABLE_STORE + ";";
        try {
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            result.next();
            count = result.getInt("rowcount");
            result.close();


        }catch (SQLException e) {e.printStackTrace();}
        return count;
    }


    public int getEmployeeCount(){
        int count = 0;
        String query = "SELECT COUNT(*) AS rowcount FROM " + db + "." + TABLE_EMPLOYEE + ";";
        try {
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            result.next();
            count = result.getInt("rowcount");
            result.close();


        }catch (SQLException e) {e.printStackTrace();}
        return count;
    }


    public int getCustomerCount(){
        int count = 0;
        String query = "SELECT COUNT(*) AS rowcount FROM " + db + "." + TABLE_CUSTOMER + ";";
        try {
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            result.next();
            count = result.getInt("rowcount");
            result.close();


        }catch (SQLException e) {e.printStackTrace();}
        return count;
    }

    public int getDistributorCount(){
        int count = 0;
        String query = "SELECT COUNT(*) AS rowcount FROM " + db + "." + TABLE_DISTRIBUTOR + ";";
        try {
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            result.next();
            count = result.getInt("rowcount");
            result.close();


        }catch (SQLException e) {e.printStackTrace();}
        return count;
    }

    public int getOrderCount(){
        int count = 0;
        String query = "SELECT COUNT(*) AS rowcount FROM " + db + "." + TABLE_ORDER + ";";
        try {
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            result.next();
            count = result.getInt("rowcount");
            result.close();


        }catch (SQLException e) {e.printStackTrace();}
        return count;
    }

    //TODO make relationship counts

    public int getEmployeeSelectionCount(){
        int count = 0;
        String query = "SELECT COUNT(*) AS rowcount FROM " + db + "." + TABLE_EMPLOYEE_SELECTION + ";";
        try {
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            result.next();
            count = result.getInt("rowcount");
            result.close();


        }catch (SQLException e) {e.printStackTrace();}
        return count;
    }

    /*
    Updates
     */

    public void updateProduct(Products product) {
        String query = "UPDATE " + db + "." + TABLE_PRODUCTS + " SET PRICE = " + product.getPrice() + ", BRAND = '" + product.getBrand() + "', NAME = '" + product.getName() + "', QUANTITY = " + product.getQuantity() + ", DISCOUNT = '" + product.getDiscount() + "', OFFERED_BY = " + product.getOfferedBy()+ " WHERE CSPC = " + product.getCspc() + ";";
        try{
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    //Special cases
    public void updateLiquor(Products product) {
        String query = "UPDATE " + db + "." + TABLE_LIQUOR + " SET PRICE = " + product.getPrice() + ", BRAND = '" + product.getBrand() + "', NAME = '" + product.getName() + "', QUANTITY = " + product.getQuantity() + ", DISCOUNT = '" + product.getDiscount() + "', OFFERED_BY = " + product.getOfferedBy() + " WHERE CSPC = " + product.getCspc() + ";";
        try{
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateNonLiquor(Products product) {
        String query = "UPDATE " + db + "." + TABLE_NON_LIQUOR + " SET PRICE = " + product.getPrice() + ", BRAND = '" + product.getBrand() + "', NAME = '" + product.getName() + "', QUANTITY = " + product.getQuantity() + ", DISCOUNT = '" + product.getDiscount() + "', OFFERED_BY = " + product.getOfferedBy() + " WHERE CSPC = " + product.getCspc() + ";";
        try{
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateMisc(Products product) {
        String query = "UPDATE " + db + "." + TABLE_MISC + " SET PRICE = " + product.getPrice() + ", BRAND = '" + product.getBrand() + "', NAME = '" + product.getName() + "', QUANTITY = " + product.getQuantity() + ", DISCOUNT = '" + product.getDiscount() + "', OFFERED_BY = " + product.getOfferedBy() + " WHERE CSPC = " + product.getCspc() + ";";
        try{
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void updateStore(Store store) {
        String query = "UPDATE " + db + "." + TABLE_STORE + " SET LOCATION = '" + store.getLocation() + "', MGRSSN = " + store.getMgrssn()  + " WHERE SID = " + store.getSid() + ";";
        try{
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateEmployee(Employee employee) {
        String query = "UPDATE " + db + "." + TABLE_EMPLOYEE + " SET FNAME = '" + employee.getFname() + "', MNAME = '" + employee.getMname()  + "', LNAME = '" + employee.getLname() + "', MGRSSN = " + employee.getMgrssn() + ", WORKS_FOR = " + employee.getWorksFor() + " WHERE SSN = " + employee.getSsn() + ";";
        try{
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void updateCustomer(Customer customer) {
        String query = "UPDATE " + db + "." + TABLE_CUSTOMER + " SET FNAME = '" + customer.getFname() + "', LNAME = '" + customer.getLname() + "', PHONE_NUMBER = '" + customer.getPhoneNumber() + "', DISCOUNT = '" + customer.getDiscount() + "' WHERE CID = " + customer.getCid() + ";";
        try{
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void updateDistributor(Distributor distributor) {
        String query = "UPDATE " + db + "." + TABLE_DISTRIBUTOR + " SET NAME = '" + distributor.getName() + "', SUPPLIES = " + distributor.getSupplies() + " WHERE DID = " + distributor.getDid() + ";";
        try{
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void updateOrder(Order order) {
        String query = "UPDATE " + db + "." + TABLE_ORDER + " SET APPROVED = '" + order.getApproved() + "', CREATED_BY = " + order.getCreatedBy()  + ", FULFILLED_BY = " + order.getFulfilledBy() + " WHERE OID = " + order.getOid() + ";";
        try{
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    //TODO make relationship updates

    public void updateEmployeeSelection(int essn, Products product){
        String query = "UPDATE " + db + "." + TABLE_EMPLOYEE_SELECTION + " SET CSPC = " + product.getCspc() + ", PRICE = " + product.getPrice() + ", BRAND = '" + product.getBrand() + "', NAME = '" + product.getName() + "', QUANTITY = " + product.getQuantity() + ", DISCOUNT = '" + product.getDiscount() + "', OFFERED_BY = " + product.getOfferedBy()+ " WHERE ESSN = " + essn + ";";
        try{
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    /*
    Delete
     */

    public void deleteProduct(Products product){
        String query = "DELETE FROM " + db + ".dbo." + TABLE_PRODUCTS + " WHERE CSPC = " + product.getCspc() + ";";
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    //Special cases
    public void deleteLiquor(Products product){
        String query = "DELETE FROM " + db + ".dbo." + TABLE_PRODUCTS + " WHERE CSPC = " + product.getCspc() + ";";
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteNonLiquor(Products product){
        String query = "DELETE FROM " + db + ".dbo." + TABLE_NON_LIQUOR + " WHERE CSPC = " + product.getCspc() + ";";
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMisc(Products product){
        String query = "DELETE FROM " + db + "." + TABLE_MISC + " WHERE CSPC = " + product.getCspc() + ";";
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteStore(Store store){
        String query = "DELETE FROM " + db + "." + TABLE_STORE + " WHERE SID = " + store.getSid() + ";";
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(Employee employee){
        String query = "DELETE FROM " + db + "." + TABLE_EMPLOYEE + " WHERE SSN = " + employee.getSsn() + ";";
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteCustomer(Customer customer){
        String query = "DELETE FROM " + db + "." + TABLE_CUSTOMER + " WHERE CID = " + customer.getCid() + ";";
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDistributor(Distributor distributor){
        String query = "DELETE FROM " + db + "." + TABLE_DISTRIBUTOR + " WHERE DID = " + distributor.getDid() + ";";
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOrder(Order order){
        String query = "DELETE FROM " + db + "." + TABLE_ORDER + " WHERE OID = " + order.getOid() + ";";
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    //TODO make delete relationships

    public void deleteEmployeeSelection(int essn, Products product){
        String query = "DELETE FROM " + db + "." + TABLE_EMPLOYEE_SELECTION + " WHERE ESSN = " + essn + ";";
        try {
            Statement stmt = conn.createStatement();
            stmt.execute(query);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

}
