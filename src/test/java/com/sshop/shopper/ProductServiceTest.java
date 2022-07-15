package com.sshop.shopper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sshop.shopper.entities.CATEGORY;
import com.sshop.shopper.entities.Product;
import com.sshop.shopper.entities.STATUS;
import com.sshop.shopper.repository.ProductRepository;
import com.sshop.shopper.services.ProductImplementation;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    
    @InjectMocks
    ProductImplementation productSrvObj;
    
    @Mock
    ProductRepository productRepoObj;
    
    
    //fetch every Product 
    @Test
    public void fetchAllTest(){
        List<Product> list = new LinkedList<Product>();
        Product productOne = new Product("url", "iPhone", 60000.0f, "iphone ", "P-1", CATEGORY.ELECTRONICS, STATUS.ACTIVE); 
        Product productTwo = new Product("urls", "Power of Your Subconscious Mind", 600.0f, "Book ", "P-2", CATEGORY.BOOKS, STATUS.ACTIVE); 
         list.add(productOne);
         list.add(productTwo);
        when(productRepoObj.findAll()).thenReturn(list);
        List<Product> productList=productRepoObj.findAll();
        assertEquals(2, productList.size());
        verify(productRepoObj, times(1)).findAll();
    }   
    //Fetch Product by productId
    @Test        
    public void fetchByIdTest(){
        Product productOne = new Product("url", "KeyChain", 80.0f, "Key-Chain", "P-1", CATEGORY.ACCESSORIES, STATUS.ACTIVE);
        when(productRepoObj.findById("P-1")).thenReturn(Optional.of(productOne));
        Optional<Product> productTwo=productSrvObj.fetchById("P-1");
        assertEquals(STATUS.ACTIVE,productTwo.get().getProductStatus());
        assertEquals(productOne.getProductId(),productTwo.get().getProductId());
    }
    //Add a new Product
    @Test
    public void addProduct(){
        Product productOne = new Product("url", "KeyChain", 80.0f, "Key-Chain", "P-1", CATEGORY.ACCESSORIES, STATUS.ACTIVE);
        when(productRepoObj.save(productOne)).thenReturn(productOne);
        String msg=productSrvObj.addproduct(productOne);
        assertNotNull(productOne,"Product added successfully");
    }
    //Update Product by productId
    @Test
    public void updateProductById(){
        Product productOne = new Product("url", "KeyChain", 80.0f, "Key-Chain", "P-1", CATEGORY.ACCESSORIES, STATUS.ACTIVE);
        productOne.setProductImage("urls");
        productOne.setProductName("Shirt");
        productOne.setProductPrice(1200);
        productOne.setProductDescription("Flannel Shirt");
        productOne.setProductCategory(CATEGORY.CLOTHING);
        productOne.setProductStatus(STATUS.ACTIVE);
        
        
        Assertions.assertThat(productOne.getProductImage()).isEqualTo("urls");
        Assertions.assertThat(productOne.getProductName()).isEqualTo("Shirt");
        Assertions.assertThat(productOne.getProductPrice()).isEqualTo(1200);
        Assertions.assertThat(productOne.getProductDescription()).isEqualTo("Flannel Shirt");
        Assertions.assertThat(productOne.getProductCategory()).isEqualTo(CATEGORY.CLOTHING);
        Assertions.assertThat(productOne.getProductStatus()).isEqualTo(STATUS.ACTIVE);

    }
    //Delete Product by productId
    @Test
    public void deleteProductById(){
        Product productOne = new Product("url", "KeyChain", 80.0f, "Key-Chain", "P-1", CATEGORY.ACCESSORIES, STATUS.ACTIVE);
        when(productRepoObj.findById("P-1")).thenReturn(Optional.of(productOne));
        String msg=productSrvObj.deleteProductById(productOne);
        assertEquals( "Object Deleted Successfully",msg);
    }
    @Test
    public void updateStatusById(){
        Product productOne = new Product("url", "KeyChain", 80.0f, "Key-Chain", "P-1", CATEGORY.ACCESSORIES, STATUS.INACTIVE);
        productOne.setProductStatus(STATUS.ACTIVE);
        Assertions.assertThat(productOne.getProductStatus()).isEqualTo(STATUS.ACTIVE);
    }
}
