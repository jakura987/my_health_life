package com.itgroup.controller;

import com.itgroup.common.R;
import com.itgroup.domain.ProductCategory;
import com.itgroup.service.ProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/admin/product")
@Api(tags = "product(商城产品)相关接口")

public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/category")
    private R<List<ProductCategory>> findProductCategory() {
        List<ProductCategory> categoryList = productService.findProductCategoryList();
        return R.success(categoryList);
    }

    @GetMapping("/categoryNames")
    private R<List<String>> findAllCategoryNames(){
        List<String> nameList = productService.findAllCategoryNames();
        return R.success(nameList);
    }

    @GetMapping("/count/{id}")
    private R<Integer> getProductCountByCategoryId(@PathVariable Long id){
        Integer count = productService.getProductCountByCategoryId(id);
        return R.success(count);
    }

}
