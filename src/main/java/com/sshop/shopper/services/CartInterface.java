package com.sshop.shopper.services;



import java.util.*;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sshop.shopper.entities.Cart;



@Service
@Transactional
public interface CartInterface {
    public ArrayList fetchAll()throws NoSuchElementException;
    public String addToCart(Cart cartObj)throws IllegalArgumentException;
    public String deleteByCartId(String  cart_product_Id);
    public String findById(String productId);
    public String deleteByProductId(String productId);
    public String updateProductByCartId(Cart cartsObj);
}
