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

import com.sshop.shopper.entities.Product;
import com.sshop.shopper.services.ProductImplementation;

@RestController
public class ProductController {
    
    @Autowired
    private ProductImplementation productSrvObj;
    
    @GetMapping(value="/api/product")
    public List<Product> fetchAll(){
        return productSrvObj.fetchAll();
    }


    @PostMapping(value="/api/addproduct")
    public String addproduct(@RequestBody Product productObj){
        return productSrvObj.addproduct(productObj);
    }


    @GetMapping(value="/api/product/id/{id}")
    public Optional<Product> fetchById(@PathVariable("id") String productId){
        return productSrvObj.fetchById(productId);
    }


    @GetMapping(value="/api/product/name/{name}")
    public Optional<Product> fetchByProductName(@PathVariable("name") String productName){
        return productSrvObj.fetchByProductName(productName);
    }


    @PutMapping(value="/api/updateproduct/{id}")
    public String updateProductById(@PathVariable("id") Product productObj){
        return productSrvObj.updateProductById(productObj);
    }


    @DeleteMapping(value="/api/deleteproduct/{id}")
    public String deleteProductById(@PathVariable("id") Product productsObj){
        return productSrvObj.deleteProductById(productsObj);
    }


    @PutMapping(value="api/product/status/{id}")
    public String updateStatusById(Product productsObj){
        return productSrvObj.updateStatusById(productsObj);
    }
    
}
