package com.sshop.shopper.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sshop.shopper.entities.STATUS;
import com.sshop.shopper.entities.products;
import com.sshop.shopper.repository.ProductRepository;
@Service
public class ProductImplementation implements ProductInterface {
    @Autowired
    public ProductRepository productRepoObj;
    
    public List<products> fetchAll() {
        return productRepoObj.findAll();
    }
    public String addproduct(products productObj) {
        productRepoObj.save(productObj);
        return "Product added successfully";

    }
    public Optional<products> fetchById(String productId){
        Optional<products> ret = productRepoObj.findById(productId);
        return ret;
     }
     public Optional<products> fetchByProductName(String productName){
        Optional<products> ret = productRepoObj.findByProductName(productName);
        return ret;
     }
     public String updateProductById(products productObj){
        if(productObj.getProductId() == null) {
            return "Enter a Valid Id";
        }
        else{
            Optional<products> p1 = productRepoObj.findById(productObj.getProductId());
            p1.get().setProductImage(productObj.getProductImage());
            p1.get().setProductName(productObj.getProductName());
            p1.get().setProductPrice(productObj.getProductPrice());
            p1.get().setProductCategory(productObj.getProductCategory());
            productRepoObj.deleteById(productObj.getProductId());
            productRepoObj.save(p1.get());
            return "Product Has been updated";
        }
     }

    public String deleteProductById(products productsObj){
        if(productsObj.getProductId() == null) {
            return "Enter a Valid Id";
        }
        else{
            Optional<products> d1 = productRepoObj.findById(productsObj.getProductId());
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
}
