package com.sshop.shopper.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sshop.shopper.entities.STATUS;
import com.sshop.shopper.entities.Product;
import com.sshop.shopper.repository.ProductRepository;
@Service
public class ProductImplementation implements ProductInterface {
    
    @Autowired
    public ProductRepository productRepoObj;
    

    // method to fetch all Products 
    public List<Product> fetchAll() {
        return productRepoObj.findAll();
    }


    //method to add Product 
    public String addproduct(Product productObj) {
        productRepoObj.save(productObj);
            return "Product added successfully";

    }


    //Fetch Product by productId
    public Optional<Product> fetchById(String productId){
        Optional<Product> ret = productRepoObj.findById(productId);
            return ret;
     }


    //Fetch Product by productName
    public Optional<Product> fetchByProductName(String productName){
        Optional<Product> ret = productRepoObj.findByProductName(productName);
            return ret;
     }


    //Update Product by productId
    public String updateProductById(Product productObj){
        if(productObj.getProductId() == null) {
            return "Enter a Valid Id";
        }
            else{
                Optional<Product> p1 = productRepoObj.findById(productObj.getProductId());
                p1.get().setProductImage(productObj.getProductImage());
                p1.get().setProductName(productObj.getProductName());
                p1.get().setProductPrice(productObj.getProductPrice());
                p1.get().setProductCategory(productObj.getProductCategory());
                productRepoObj.deleteById(productObj.getProductId());
                productRepoObj.save(p1.get());
                return "Product Has been updated";
            }
     }



    //Delete Product by productId
    public String deleteProductById(Product productsObj){
        if(productsObj.getProductId() == null) {
            return "Enter a Valid Id";
        }
            else{
                Optional<Product> d1 = productRepoObj.findById(productsObj.getProductId());
                    if(d1.get().getProductStatus() ==STATUS.ACTIVE){
                        d1.get().setProductStatus(STATUS.INACTIVE);
                        productRepoObj.save(d1.get());
                        return "Object Deleted Successfully";
                
                    }
                    else{
                        return "Object does not exists";
                    }
            }
    }


    //Update Status by productId
    public String updateStatusById(Product productsObj){
        Optional<Product> statusObj =  productRepoObj.findById(productsObj.getProductId());
        if(productsObj.getProductId() == null) {
            return "Enter a Valid Id";
        }
            else {
                if(statusObj.get().getProductStatus() ==STATUS.INACTIVE){
                    statusObj.get().setProductStatus(STATUS.ACTIVE);
                    productRepoObj.save(statusObj.get());
                    return "Product's Status has been Updated Successfully";
                }
                    else{
                        return "Product is available";
                    }
        }
            
    }
}
