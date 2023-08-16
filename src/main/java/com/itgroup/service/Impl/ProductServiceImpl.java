package com.itgroup.service.Impl;

import com.itgroup.domain.Product;
import com.itgroup.mapper.ProductMapper;
import com.itgroup.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public Product getProductById(Long id) {
        Product product = productMapper.getProductById(id);
        return product;
    }
}
