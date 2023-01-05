package com.javatest.SpringbootTest.models;

public class Supply {

    String productId;
    double quantity;

    public Supply(String productId, double quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Supply() {
    }
    public String getProductId() {
        return productId;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

}
