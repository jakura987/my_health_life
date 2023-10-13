package com.itgroup.service;

import com.itgroup.domain.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    List<ShoppingCart> getShoppingCartByUserId(Long id);
    void addItemToShoppingCart(ShoppingCart shoppingCart);
    void removeItemInShoppingCartById(Long id);
    void removeAllItemsInShoppingCartByUserId(Long userId);
    void ChangeItemQuality(ShoppingCart shoppingCart);

}
