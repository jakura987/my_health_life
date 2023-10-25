package com.itgroup;

import com.itgroup.domain.Product;
import com.itgroup.domain.ShoppingCart;
import com.itgroup.service.ProductService;
import com.itgroup.service.ShoppingCartService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class ShoppingCartTest {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private ProductService productService;

    @Test
    void addToEmptyShoppingCartTest() {
        ShoppingCart shoppingCart = ShoppingCart.builder()
                .userId(1L)
                .productId(1432981736189098762L)
                .quantity(2)
                .totalAmount(40.0)
                .createTime(new Date())
                .build();
        shoppingCartService.addItemToShoppingCart(shoppingCart);
    }

    @Test
    void removeItemFromShoppingCartTest() {
        Long itemId = 123456L;
        shoppingCartService.removeItemInShoppingCartById(itemId);
    }

    @Test
    void removeAllItemsForUserTest() {
        Long userId = 1L;
        shoppingCartService.removeAllItemsInShoppingCartByUserId(userId);

    }

    @Test
    void changeItemQuantityTest() {
        ShoppingCart shoppingCart = ShoppingCart.builder()
                .userId(1L)
                .productId(1432981736189098762L)
                .quantity(5)
                .totalAmount(100.0)
                .createTime(new Date())
                .build();
        shoppingCartService.ChangeItemQuality(shoppingCart);
    }
}

