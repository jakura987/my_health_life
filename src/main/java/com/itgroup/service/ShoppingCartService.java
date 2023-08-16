package com.itgroup.service;

import com.itgroup.domain.Product;
import com.itgroup.domain.ShoppingCart;

public interface ShoppingCartService {
    void addItemToShoppingCart(Product product);
}
