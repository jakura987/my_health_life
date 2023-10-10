package com.itgroup.service.Impl;

import com.itgroup.domain.ShoppingCart;
import com.itgroup.exception.BusinessException;
import com.itgroup.mapper.ShoppingCartMapper;
import com.itgroup.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;


    @Override
    public List<ShoppingCart> getShoppingCartByUserId(Long id) {
        return shoppingCartMapper.getShoppingCartByUserId(id);
    }

    @Override
    public void addItemToShoppingCart(ShoppingCart shoppingCart) {
        try {
            List<ShoppingCart> cartList = shoppingCartMapper.getShoppingCartByUserId(shoppingCart.getUserId());

            if(cartList != null && !cartList.isEmpty()) { //cart is not empty
                boolean productExistsInCart = false;

                for (ShoppingCart cart : cartList) { // cart has same product, update the product
                    if(shoppingCart.getProductId().equals(cart.getProductId())) {
                        productExistsInCart = true;
                        cart.setQuantity(shoppingCart.getQuantity() + cart.getQuantity());
                        cart.setUpdateTime(new Date());
                        cart.setTotalAmount(cart.getTotalAmount() + shoppingCart.getTotalAmount());
                        shoppingCartMapper.update(cart);
                        break;
                    }
                }

                if(!productExistsInCart) {
                    shoppingCart.setCreateTime(new Date());
                    shoppingCart.setUpdateTime(new Date());
                    shoppingCartMapper.add(shoppingCart);
                }
            }
            else { //cart is empty, add directly
                shoppingCart.setCreateTime(new Date());
                shoppingCart.setUpdateTime(new Date());
                shoppingCartMapper.add(shoppingCart);
            }
        } catch (Exception e) {

            throw new BusinessException("Dr.Bob find there is an Error in addItemToShoppingCart " + e.getMessage());
        }
    }


    @Override
    public void removeItemInShoppingCartById(Long id) {
        try{
            if(id != null){
                shoppingCartMapper.delete(id);
            }
        }catch (Exception e){
            throw new BusinessException("no such Item in shoppingCart");
        }

    }

    //TODO: exception
    @Override
    public void ChangeItemQuality(ShoppingCart shoppingCart) {
        try {
            shoppingCart.setUpdateTime(new Date());
            shoppingCartMapper.update(shoppingCart);
        }catch (Exception e){
            throw new BusinessException("Error occurs in ChangeItemQuality");
        }

    }


}
