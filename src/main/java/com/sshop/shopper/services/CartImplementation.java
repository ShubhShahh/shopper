package com.sshop.shopper.services;

import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sshop.shopper.entities.Cart;
import com.sshop.shopper.entities.STATUS;
import com.sshop.shopper.entities.Product;
import com.sshop.shopper.repository.CartRepository;
import com.sshop.shopper.repository.ProductRepository;

@Service
@Transactional
public class CartImplementation implements CartInterface{
    
    @Autowired
    public CartRepository cartRepoObj;
   
    @Autowired
    public ProductRepository productRepoObj;

    //method to fetch the Cart List from Cart Database and via productId fetching Product Details 
    public ArrayList fetchAll() throws NoSuchElementException{
        float totalPrice=0;
        ArrayList list = new ArrayList();
        List<Cart> c1 = cartRepoObj.findAll();
        
            for(int i = 0; i<c1.size();i++){
                Optional<Product> c2 = productRepoObj.findById(c1.get(i).getProductId());
                int c3 = c1.get(i).getcartProductQty();
                totalPrice = totalPrice + (c3*c2.get().getProductPrice()); 
                list.add(Arrays.asList(c1.get(i).getcartProductId(),c1.get(i).getcartProductQty(),c2.get().getProductImage(),c2.get().getProductName(),c2.get().getProductPrice(),c2.get().getProductCategory(),c2.get().getProductDescription(),c2.get().getProductStatus()));  
                list.add(totalPrice);
            
        }
        return list;  
    }
            

    //Adding Existing Product into Cart  
    public String addToCart(Cart cartObj) throws IllegalArgumentException{
        Optional<Product> c1 = productRepoObj.findById(cartObj.getProductId());
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


    //Deleting Product from the Cart
    public String deleteByCartId(String  cartProductId){
        cartRepoObj.deleteById( cartProductId);
            return "Product deleted successfully from cart";
    }


    //Fetching CartProduct by ProductId
    public Optional<Cart> findById(String productId){
        return cartRepoObj.findById(productId);
            
    }


    //Deleting CartProduct by ProductId from Cart
    public String deleteByProductId(String productId){
        cartRepoObj.deleteByProductId(productId);
            return "Product Deleted Successfully from Cart";
    }


    //Update existing CartProduct by CartId
    public String updateProductByCartId(Cart cartsObj){
        if(cartsObj.getcartProductId() == null) {
            return "Enter a Valid Id";
        }
            else{
                Optional<Cart> c1 = cartRepoObj.findById(cartsObj.getcartProductId());
                c1.get().setcartProductQty(cartsObj.getcartProductQty());
                c1.get().setcartProductId(cartsObj.getcartProductId());
                c1.get().setProductId(cartsObj.getProductId());
                cartRepoObj.deleteById(cartsObj.getcartProductId());
                cartRepoObj.save(c1.get());
                return "Product Has been updated";
            }
    }
}
