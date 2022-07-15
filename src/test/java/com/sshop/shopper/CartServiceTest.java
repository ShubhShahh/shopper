package com.sshop.shopper;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sshop.shopper.entities.Cart;
import com.sshop.shopper.repository.CartRepository;
import com.sshop.shopper.repository.ProductRepository;
import com.sshop.shopper.services.CartImplementation;
import com.sshop.shopper.services.ProductImplementation;
@ExtendWith(MockitoExtension.class)
public class CartServiceTest {
    
    @InjectMocks
    CartImplementation  CartSrvObj;
    
    @InjectMocks
    ProductImplementation productSrvObj;
    
    @Mock
    CartRepository CartRepoObj;
    
    @Mock 
    ProductRepository productRepoObj;
    

    //Add Product to Cart
    @Test
    public void addToCartTest(){
    Cart cartProductOne=new Cart("C1", 2, "P-1");
    CartRepoObj.save(cartProductOne);
    verify(CartRepoObj,times(1)).save(cartProductOne);
    }

    //Delete CartProduct by cartId
    @Test
    public void deleteByCartId(){
        Cart cartProductOne=new Cart("C1", 2, "P-1");
        lenient().when(CartRepoObj.findById("C1")).thenReturn(Optional.of(cartProductOne));
        String msg=CartSrvObj.deleteByCartId("C1");
        assertNotNull(msg, "Product deleted successfully from cart");
        
    }

    //Update CartProduct by cartProductId
    @Test
    public void updateProductByCartId(){
        Cart cartProductOne=new Cart("C1", 1, "P-1");
    
        cartProductOne.setcartProductQty(2);
        cartProductOne.setProductId("P-1");

        Assertions.assertThat(cartProductOne.getcartProductQty()).isEqualTo(2);
        Assertions.assertThat(cartProductOne.getProductId()).isEqualTo("P-1");
    }

    //Delete By Cart By product ID
    @Test
    public void deleteByProductId(){
        Cart cartProductOne = new Cart("C1", 6, "P-1");
        lenient().when(CartRepoObj.findById("P-1")).thenReturn(Optional.of(cartProductOne));
        String msg=CartSrvObj.deleteByProductId("P-1");
        assertNotNull(msg,"Product Deleted Successfully from Cart");
        }
}


