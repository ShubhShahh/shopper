package com.sshop.shopper.entities;

import java.util.LinkedList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Product {

    String productImage;
    String productName;
    float productPrice;
    String productDescription;
    @Id
    String productId;
    @Enumerated(EnumType.STRING)
    CATEGORY productCategory;
    @Enumerated(EnumType.STRING)
    STATUS productStatus;

    
    @OneToMany  //Mapped productId from Product entity to Cart entity
    @JoinColumn(name = "productId", referencedColumnName = "productId")  //Join Column to combine productId of Cart entity
    public List<Cart> cartsObj = new LinkedList<>();
    
    //Constructor Using all fields
    public Product(String productImage, String productName, float productPrice, String productDescription, String productId, CATEGORY productCategory, STATUS productStatus) {
        this.productImage = productImage;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productId = productId;
        this.productCategory = productCategory;
        this.productStatus = productStatus;
    }


    // Zero Args Constructor 
    public Product() {
    }


    //getter method for productImage
    public String getProductImage() {
        return this.productImage;
    }


    //setter method for productImage
    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }


    //getter method for productName
    public String getProductName() {
        return this.productName;
    }


    //setter method for productName
    public void setProductName(String productName) {
        this.productName = productName;
    }


    //getter method for productPrice
    public float getProductPrice() {
        return this.productPrice;
    }


    //setter method for productPrice
    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }


    //getter method for productDescription
    public String getProductDescription() {
        return this.productDescription;
    }


    //setter method for productDescription
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }


    //getter method for productId
    public String getProductId() {
        return this.productId;
    }


    //setter method for productId
    public void setProductId(String productId) {
        this.productId = productId;
    }


    //getter method for productCategory
    public CATEGORY getProductCategory() {
        return this.productCategory;
    }


    //setter method for productCategory
    public void setProductCategory(CATEGORY productCategory) {
        this.productCategory = productCategory;
    }


    //getter method for productStatus
    public STATUS getProductStatus() {
        return this.productStatus;
    }


    //setter method for productStatus
    public STATUS setProductStatus(STATUS productStatus) {
        return this.productStatus = productStatus;
        
    }


    //to convert fetched values into string
    public String toString() {
        return "{" +
            " productImage='" + getProductImage() + "'" +
            ", productName='" + getProductName() + "'" +
            ", productPrice='" + getProductPrice() + "'" +
            ", productDescription='" + getProductDescription() + "'" +
            ", productId='" + getProductId() + "'" +
            ", productCategory='" + getProductCategory() + "'" +
            ", productStatus='" + getProductStatus() + "'" +
            "}";
    }

    
}
