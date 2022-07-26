package com.sshop.shopper.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sshop.shopper.entities.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, String> {
    
    public String deleteByProductId(String productId);
}

