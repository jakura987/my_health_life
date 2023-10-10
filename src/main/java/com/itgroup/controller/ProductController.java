package com.itgroup.controller;

import com.itgroup.common.R;
import com.itgroup.domain.Product;
import com.itgroup.domain.ProductCategory;
import com.itgroup.service.ProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/product")
@Api(tags = "product(online mart) related interface")

public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * Handles the GET request to retrieve a list of product categories.
     * @return R object encapsulating the success response and the list of product categories.
     */
    @GetMapping("/category")
    private R<List<ProductCategory>> findProductCategory() {
        List<ProductCategory> categoryList = productService.findProductCategoryList();
        return R.success(categoryList);
    }

    /**
     * Handles the GET request to retrieve a list of all product category names.
     *
     * @return R object encapsulating the success response and the list of product category names.
     */
    @GetMapping("/categoryNames")
    private R<List<String>> findAllCategoryNames(){
        List<String> nameList = productService.findAllCategoryNames();
        return R.success(nameList);
    }

    /**
     * Handles the GET request to retrieve the product count for a specific category.
     *
     * @param id The ID of the product category.
     * @return R object encapsulating the success response and the product count for the given category.
     */
    @GetMapping("/count/{id}")
    private R<Integer> getProductCountByCategoryId(@PathVariable Long id){
        Integer count = productService.getProductCountByCategoryId(id);
        return R.success(count);
    }

    /**
     * Handles the GET request to retrieve a list of products for a specific category.
     *
     * @param id The ID of the product category.
     * @return R object encapsulating the success response and the list of products for the given category.
     */
    @GetMapping("/category/{id}")
    private R<List<Product>> findProductListByCategoryId(@PathVariable Long id){
        List<Product> productListByCategoryId = productService.findProductListByCategoryId(id);
        return R.success(productListByCategoryId);
    }

    /**
     * Handles the GET request to retrieve a map of product categories along with their product counts.
     *
     * @return R object encapsulating the success response and a map where the key is the product category name
     * and the value is the product count for that category.
     */
    @GetMapping("/categoryAndCount")
    private R<Map<String, Integer>> showCategoryAndCount(){
        Map<String, Integer> categoryMap = new HashMap<>();
        List<ProductCategory> categoryList = productService.findProductCategoryList();
        for (ProductCategory productCategory :
                categoryList) {
            Integer count = productService.getProductCountByCategoryId(productCategory.getId());
            categoryMap.put(productCategory.getName(), count);
        }
        return R.success(categoryMap);
    }


}
