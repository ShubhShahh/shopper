package com.sshop.shopper.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sshop.shopper.entities.products;
import com.sshop.shopper.services.ProductImplementation;

@RestController
public class productcontroller {
    
    @Autowired
    private ProductImplementation productSrvObj;

    @GetMapping(value="/api/product")
    public List<products> fetchAll(){
        return productSrvObj.fetchAll();
    }
    @PostMapping(value="/api/addproduct")
    public String addproduct(@RequestBody products productObj){
        return productSrvObj.addproduct(productObj);
    }
    @GetMapping(value="/api/product/id/{id}")
    public Optional<products> fetchById(@PathVariable("id") String productId){
        return productSrvObj.fetchById(productId);
    }
    @GetMapping(value="/api/product/name/{name}")
    public Optional<products> fetchByProductName(@PathVariable("name") String productName){
        return productSrvObj.fetchByProductName(productName);
    }
    @PutMapping(value="/api/updateproduct/{id}")
    public String updateProductById(@PathVariable("id") products productObj){
        return productSrvObj.updateProductById(productObj);
    }
    @DeleteMapping(value="/api/deleteproduct/{id}")
    public String deleteProductById(@PathVariable("id") products productsObj){
        return productSrvObj.deleteProductById(productsObj);
    }

    
}
