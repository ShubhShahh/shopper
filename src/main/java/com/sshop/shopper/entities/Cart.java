package com.sshop.shopper.entities;



import javax.persistence.*;


@Entity(name = "Cart")
public class Cart{
    @Id
    String cart_product_id;
    int cart_product_qty;

    
    @Column(name="productId", nullable = true,insertable = true, updatable = true)
    public String productId;
    


    public Cart(String cart_product_id, int cart_product_qty, String productId) {
        this.cart_product_id = cart_product_id;
        this.cart_product_qty = cart_product_qty;
        this.productId = productId;
    }

    public Cart() {
    }

    @Override
    public String toString() {
        return "{" +
            " cart_product_id='" + getCart_product_id() + "'" +
            ", cart_product_qty='" + getCart_product_qty() + "'" +
            ", productId='" + getProductId() + "'" +
            "}";
    }

    public String getCart_product_id() {
        return this.cart_product_id;
    }

    public void setCart_product_id(String cart_product_id) {
        this.cart_product_id = cart_product_id;
    }

    public int getCart_product_qty() {
        return this.cart_product_qty;
    }

    public void setCart_product_qty(int cart_product_qty) {
        this.cart_product_qty = cart_product_qty;
    }



    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }


 

    
}

