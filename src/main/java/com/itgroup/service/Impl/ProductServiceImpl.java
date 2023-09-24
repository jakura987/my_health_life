package com.itgroup.service.Impl;

import com.itgroup.domain.Product;
import com.itgroup.domain.ProductCategory;
import com.itgroup.mapper.ProductMapper;
import com.itgroup.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public Product getProductById(Long id) {
        Product product = productMapper.getProductById(id);
        return product;
    }

    @Override
    public List<ProductCategory> findProductCategoryList() {
        List<ProductCategory> categoryList = productMapper.getProductCategoryList();
        return categoryList;
    }
}
