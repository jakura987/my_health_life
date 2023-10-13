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

@RestController
@RequestMapping("/admin/user/shoppingCart")
@Api(tags = "shoppingCart(online mart cart) related interface")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private ProductService productService;

    /**
     * Handles the POST request to add an item to the shopping cart.
     *
     * @param shoppingCart The item to be added, received as a JSON in the request body.
     * @return R object encapsulating the success response message.
     */
    @PostMapping("/add")
    public R<String> addItemToShoppingCart(@RequestBody ShoppingCart shoppingCart){
        shoppingCartService.addItemToShoppingCart(shoppingCart);
        return R.success("add successfully");
    }

    /**
     * Handles the GET request to retrieve the shopping cart items for a specific user.
     *
     * @param userId The ID of the user whose shopping cart items are to be retrieved.
     * @return R object encapsulating the success response and a list of shopping cart items for the user.
     */
    @GetMapping("/getCart/{userId}")
    public R<List<ShoppingCartVo>> getShoppingCart(@PathVariable Long userId){
        List<ShoppingCart> shoppingCartList = shoppingCartService.getShoppingCartByUserId(userId);
        ArrayList<ShoppingCartVo> shoppingCartVoList = new ArrayList<>();
        for (ShoppingCart shoppingcart :
                shoppingCartList) {
            ShoppingCartVo shoppingCartVo = new ShoppingCartVo();
            BeanUtils.copyProperties(shoppingcart, shoppingCartVo);

            Product product = productService.getProductById(shoppingcart.getProductId());
            shoppingCartVo.setProductName(product.getName());
            shoppingCartVo.setUnitPrice(product.getPrice());
            shoppingCartVo.setProductImage(product.getImage());
            shoppingCartVoList.add(shoppingCartVo);
        }
        return R.success(shoppingCartVoList);

    }

    /**
     * Handles the DELETE request to remove an item from the shopping cart by its ID.
     *
     * @param id The ID of the shopping cart item to be removed.
     * @return R object encapsulating the success response message.
     */
    @DeleteMapping("/removeItem/{id}")
    public R<String> removeItemInShoppingCartById(@PathVariable Long id){
        shoppingCartService.removeItemInShoppingCartById(id);
        return R.success("remove successfully");
    }

    /**
     * Endpoint to remove all items from a user's shopping cart.
     *
     * @param userId The ID of the user whose shopping cart items are to be removed.
     * @return A response indicating the success of the operation.
     */
    @DeleteMapping("/removeAllItems/{userId}")
    public R<String> removeAllItemsInShoppingCartByUserId(@PathVariable Long userId){
        shoppingCartService.removeAllItemsInShoppingCartByUserId(userId);
        return R.success("delete successfully");
    }


    /**
     * Handles the PUT request to update the quantity of an item in the shopping cart.
     *
     * @param shoppingCart The updated item, received as a JSON in the request body.
     * @return R object encapsulating the success response message.
     */
    @PutMapping("/updateQuality")
    public R<String> updateItemQuality(@RequestBody ShoppingCart shoppingCart){
        shoppingCartService.ChangeItemQuality(shoppingCart);
        return R.success("update quality successfully");
    }
}
