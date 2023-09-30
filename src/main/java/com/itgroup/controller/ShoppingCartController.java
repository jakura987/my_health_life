package com.itgroup.controller;

import com.itgroup.common.R;
import com.itgroup.domain.Product;
import com.itgroup.domain.ShoppingCart;
import com.itgroup.service.ProductService;
import com.itgroup.service.ShoppingCartService;
import com.itgroup.vo.ShoppingCartVo;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//TODO 其他部分移除ResponseBody
@RestController
@RequestMapping("/admin/user/shoppingCart")
@Api(tags = "shoppingCart(商城购物车)相关接口")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private ProductService productService;

    /**
     * add item to user's shopping cart
     * @param shoppingCart
     * @return
     */
    @PostMapping("/add")
    public R<String> addItemToShoppingCart(@RequestBody ShoppingCart shoppingCart){
        shoppingCartService.addItemToShoppingCart(shoppingCart);
        return R.success("add successfully");
    }

    @GetMapping("/getCart/{userId}")
    public R<List<ShoppingCartVo>> getShoppingCart(@PathVariable Long userId){
        List<ShoppingCart> shoppingCartList = shoppingCartService.getShoppingCartByUserId(userId);
        ArrayList<ShoppingCartVo> shoppingCartVoList = new ArrayList<>();
        for (ShoppingCart shoppingcart :
                shoppingCartList) {
            ShoppingCartVo shoppingCartVo = new ShoppingCartVo();
            BeanUtils.copyProperties(shoppingcart, shoppingCartVo);
            Long productId = shoppingcart.getProductId();
            //TODO: 太繁琐
            Product product = productService.getProductById(productId);
            String productName = product.getName();
            shoppingCartVo.setProductName(productName);
            shoppingCartVoList.add(shoppingCartVo);
        }
        return R.success(shoppingCartVoList);

    }

    @DeleteMapping("/removeItem/{id}")
    public R<String> removeItemInShoppingCartById(@PathVariable Long id){
        shoppingCartService.removeItemInShoppingCartById(id);
        return R.success("remove successfully");
    }

    @PutMapping("/updateQuality")
    public R<String> updateItemQuality(@RequestBody ShoppingCart shoppingCart){
        shoppingCartService.ChangeItemQuality(shoppingCart);
        return R.success("update quality successfully");
    }
}
