package com.itgroup;

import com.itgroup.domain.Product;
import com.itgroup.service.Impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductTest {
    @Autowired
    private ProductServiceImpl productService;

    @Test
    void getProductById(){
        System.out.println(productService.getProductById(1432981736189098762L));
    }
}
