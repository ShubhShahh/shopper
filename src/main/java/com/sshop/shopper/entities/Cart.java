package com.sshop.shopper.entities;

import javax.persistence.*;


@Entity(name = "Cart")
public class Cart{
    
    @Id
    String cartProductId; 
    int cartProductQty;

    //Column used to create a simiar object and attach the productId from entity Product and use as a foreign key to fetch the details.
    @Column(name="productId", nullable = true,insertable = true, updatable = true)
    public String productId;
    
 
    //Construtor using all fields
    public Cart(String cartProductId, int cartProductQty, String productId) {
        this.cartProductId = cartProductId;
        this.cartProductQty = cartProductQty;
        this.productId = productId;
    }


    // Zero Args Constructor
    public Cart() {
    }


    //to convert fetched values into string
    public String toString() {
        return "{" +
            " cartProductId='" + getcartProductId() + "'" +
            ", cartProductQty='" + getcartProductQty() + "'" +
            ", productId='" + getProductId() + "'" +
            "}";
    }


    //getter method for cartProductId
    public String getcartProductId() {
        return this.cartProductId;
    }


    //setter method for cartProductId
    public void setcartProductId(String cartProductId) {
        this.cartProductId = cartProductId;
    }


    //getter method for cartProductQty
    public int getcartProductQty() {
        return this.cartProductQty;
    }


    //setter method for cartProductQty
    public void setcartProductQty(int cartProductQty) {
        this.cartProductQty = cartProductQty;
    }


    //getter method for productId
    public String getProductId() {
        return this.productId;
    }


    //setter method for productId
    public void setProductId(String productId) {
        this.productId = productId;
    }
    
}

