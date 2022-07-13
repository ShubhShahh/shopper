package com.sshop.shopper.controller;



import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sshop.shopper.entities.Cart;
import com.sshop.shopper.services.CartImplementation;




@RestController
public class cartcontroller {
    @Autowired
    private CartImplementation cartSrvObj;

    @GetMapping(value = "/api/cart")
    public ArrayList fetchAll()throws NoSuchElementException{
        return cartSrvObj.fetchAll();
    }
    @PostMapping(value="/api/addtocart")
    public String addToCart(@RequestBody Cart cartObj)throws IllegalArgumentException{
        return cartSrvObj.addToCart(cartObj);
    }
    @DeleteMapping(value="/api/delete/{id}")
    public String deleteByCartId(@PathVariable("id")String cart_product_Id){
        return cartSrvObj.deleteByCartId( cart_product_Id);
    }
    @GetMapping(value="/api/cart/{id}")
    public String findById(@PathVariable("id")String productId){
        return cartSrvObj.findById(productId);
    }
    @DeleteMapping(value="/api/delete/cart/{id}")
    public String deleteByProductId(@PathVariable("id")String productId){
        return cartSrvObj.deleteByProductId(productId);
    }
    @PutMapping(value="api/cart/{id}/items")
    public String updateProductByCartId(@PathVariable("id") Cart cartsObj){
        return cartSrvObj.updateProductByCartId(cartsObj);
    }
    

}
