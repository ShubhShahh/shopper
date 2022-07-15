package com.sshop.shopper.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sshop.shopper.entities.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, String>{
   
    public Optional<Product> findByProductName(String productName);
    public Optional<Product> findById(String productId);

    
}
