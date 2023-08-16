package com.itgroup.service.Impl;

import com.itgroup.domain.Product;
import com.itgroup.domain.ShoppingCart;
import com.itgroup.mapper.ShoppingCartMapper;
import com.itgroup.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    @Override
    public void addItemToShoppingCart(Product product) {
        Long productId = product.getId();
        ShoppingCart shoppingCart = ShoppingCart.builder()
                .productId(productId)
                .userId(2)
                .quantity(2)
                .totalAmount(40.00)
                .createTime(LocalDateTime.now())
                .build();
        shoppingCartMapper.add(shoppingCart);
    }
}
