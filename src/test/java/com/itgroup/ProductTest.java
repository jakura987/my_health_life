package com.itgroup;

import com.itgroup.domain.Product;
import com.itgroup.service.Impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductTest {
    @Autowired
    private ProductServiceImpl productService;

    @Test
    void getProductById(){
        System.out.println(productService.getProductById(1980982761726789090L));
    }

    @Test
    void getProductListByCategoryId(){
        List<Product> list = productService.findProductListByCategoryId(1890837617892651267L);
        System.out.println(list);
    }
}
