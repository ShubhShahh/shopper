package com.sshop.shopper.services;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sshop.shopper.entities.Cart;
import com.sshop.shopper.entities.STATUS;
import com.sshop.shopper.entities.products;
import com.sshop.shopper.repository.CartRepository;
import com.sshop.shopper.repository.ProductRepository;

@Service
@Transactional
public class CartImplementation implements CartInterface{
    
    @Autowired
    public CartRepository cartRepoObj;
    @Autowired
    public ProductRepository productRepoObj;

    public ArrayList fetchAll() throws NoSuchElementException{
        float totalPrice=0;
        int i=0;
        ArrayList list = new ArrayList();
        List<Cart> c1 = cartRepoObj.findAll();
        for(i = 0; i<c1.size();i++){
            
            Optional<products> c2 = productRepoObj.findById(c1.get(i).getProductId());
            int c3 = c1.get(i).getCart_product_qty();
            totalPrice = totalPrice + (c3*c2.get().getProductPrice()); 
            list.add(Arrays.asList(c1.get(i).getCart_product_id(),c1.get(i).getCart_product_qty(),c2.get().getProductImage(),c2.get().getProductName(),c2.get().getProductPrice(),c2.get().getProductCategory(),c2.get().getProductDescription(),c2.get().getProductStatus()));  
            list.add(totalPrice);
            
    }
        return list;

        
    
    
}
            
    public String addToCart(Cart cartObj) throws IllegalArgumentException{
        Optional<products> c1 = productRepoObj.findById(cartObj.getProductId());
        if(c1.isPresent()){
            if(c1.get().getProductStatus()==STATUS.ACTIVE){
                cartRepoObj.save(cartObj);
                return "Product created successfully";
            }
            else{
               return  "Product is unavailable";
            }

        }
        else{
            return "Product does not exists";
        }
    }
    public String deleteByCartId(String  cart_product_Id){
        cartRepoObj.deleteById( cart_product_Id);
        return "Product deleted successfully from cart";
    }
    public String findById(String productId){
        cartRepoObj.findById(productId);
        return "Cart Product Deleted Successfully";
    }
    public String deleteByProductId(String productId){
        cartRepoObj.deleteByProductId(productId);
        return "Product Deleted Successfully from Cart";
    }
    public String updateProductByCartId(Cart cartsObj){
        if(cartsObj.getCart_product_id() == null) {
            return "Enter a Valid Id";
        }
        else{
            Optional<Cart> c1 = cartRepoObj.findById(cartsObj.getCart_product_id());
            c1.get().setCart_product_qty(cartsObj.getCart_product_qty());
            c1.get().setCart_product_id(cartsObj.getCart_product_id());
            c1.get().setProductId(cartsObj.getProductId());
            cartRepoObj.deleteById(cartsObj.getCart_product_id());
            cartRepoObj.save(c1.get());
            return "Product Has been updated";
        }
    }
    
    

    
}
