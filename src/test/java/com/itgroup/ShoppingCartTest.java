package com.itgroup;

import com.itgroup.domain.Product;
import com.itgroup.service.ProductService;
import com.itgroup.service.ShoppingCartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ShoppingCartTest {
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private ProductService productService;

    @Test
    void addToShoppingCastTest(){
        Product product = productService.getProductById(1782736178908173618L);
        System.out.println(product);

        shoppingCartService.addItemToShoppingCart(product);

    }
}
