package com.itgroup;

import com.itgroup.domain.Product;
import com.itgroup.domain.ShoppingCart;
import com.itgroup.service.ProductService;
import com.itgroup.service.ShoppingCartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Date;

@SpringBootTest
public class ShoppingCartTest {
    @Autowired
    private ShoppingCartService shoppingCartService;
//    @Autowired
//    private ProductService productService;

    @Test
    void addToShoppingCastTest(){
        ShoppingCart shoppingCart = ShoppingCart.builder()
                .userId(1L)
                .productId(1432981736189098762L)
                .quantity(2)
                .totalAmount(40.0)
                .createTime(new Date())
                .build();
        shoppingCartService.addItemToShoppingCart(shoppingCart);

//        Product product = productService.getProductById(1782736178908173618L);
//        System.out.println(product);

//        shoppingCartService.addItemToShoppingCart(product);

    }
}
