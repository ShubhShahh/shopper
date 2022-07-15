package com.sshop.shopper.services;

import java.util.List;
import java.util.Optional;

import com.sshop.shopper.entities.Product;

public interface ProductInterface {
    
    public List<Product> fetchAll();
    public String addproduct(Product productObj);
    public Optional<Product> fetchById(String productId);
    public Optional<Product> fetchByProductName(String productName);
    public String updateProductById(Product productObj);
    public String deleteProductById(Product productsObj);
    public String updateStatusById(Product productsObj);
    
}
