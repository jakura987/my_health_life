package com.itgroup;

import com.itgroup.domain.Product;
import com.itgroup.domain.ProductCategory;
import com.itgroup.service.Impl.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.*;



import java.util.List;

@SpringBootTest
public class ProductTest {
    @Autowired
    private ProductServiceImpl productService;

    @Test
    void getProductByIdTest() {
        Long testProductId = 1980982761726789090L;
        Product product = productService.getProductById(testProductId);
        assertNotNull(product);
        assertEquals(testProductId, product.getId());
    }

    @Test
    void getProductListByCategoryIdTest() {
        Long testCategoryId = 1890837617892651267L;
        List<Product> list = productService.findProductListByCategoryId(testCategoryId);
        assertNotNull(list);
        assertTrue(list.size() > 0);
        assertEquals(testCategoryId, list.get(0).getProductCategoryId());
    }

    @Test
    void getProductCategoryListTest() {
        List<ProductCategory> categories = productService.findProductCategoryList();
        assertNotNull(categories);
        assertTrue(categories.size() > 0);
    }

    @Test
    void findAllCategoryNamesTest() {
        List<String> names = productService.findAllCategoryNames();
        assertNotNull(names);
        assertTrue(names.size() > 0);
    }

    @Test
    void getProductCountByCategoryIdTest() {
        Long testCategoryId = 1890837617892651267L;
        Integer count = productService.getProductCountByCategoryId(testCategoryId);
        assertNotNull(count);
        assertTrue(count > 0);
    }
}
