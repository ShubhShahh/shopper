package com.sshop.shopper.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sshop.shopper.entities.products;
@Repository
public interface ProductRepository extends JpaRepository<products, String>{
    public Optional<products> findByProductName(String productName);

    public Optional<products> findById(String productId);

    
}
