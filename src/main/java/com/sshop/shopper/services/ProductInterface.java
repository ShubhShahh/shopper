package com.sshop.shopper.services;

import java.util.List;
import java.util.Optional;

import com.sshop.shopper.entities.products;

public interface ProductInterface {
    public List<products> fetchAll();
    public String addproduct(products productObj);
    public Optional<products> fetchById(String productId);
    public Optional<products> fetchByProductName(String productName);
    public String updateProductById(products productObj);
    public String deleteProductById(products productsObj);
    // public String updateStatusById(products productsObj);
    
}
