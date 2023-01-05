package com.javatest.SpringbootTest.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Inventory {

    String productid;
    String prodName;
    String UOM;
    Double availQty;
    Date availDate;

    public Inventory() {
    }

    // public Inventory(String productid, String prodName, String uOM, Double
    // availQty, Date availDate) {
    // this.productid = productid;
    // this.prodName = prodName;
    // this.UOM = uOM;
    // this.availQty = availQty;
    // this.availDate = availDate;
    // }

    public Inventory(String productid, String prodName, String uOM, Double availQty, String availDate) {
        this.productid = productid;
        this.prodName = prodName;
        this.UOM = uOM;
        this.availQty = availQty;
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.availDate = simple.parse(availDate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getUOM() {
        return UOM;
    }

    public void setUOM(String uOM) {
        UOM = uOM;
    }

    public Double getAvailQty() {
        return availQty;
    }

    public void setAvailQty(Double availQty) {
        this.availQty = availQty;
    }

    
    public java.util.Date getAvailDate() {
        return availDate;
    }

    public void setAvailDate(java.util.Date availDate) {
        this.availDate = availDate;
    }

    
}
