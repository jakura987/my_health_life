package com.itgroup.service;

import com.itgroup.domain.Product;
import com.itgroup.domain.ProductCategory;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);

    List<ProductCategory> findProductCategoryList();
}
