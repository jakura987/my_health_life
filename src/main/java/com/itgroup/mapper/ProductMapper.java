package com.itgroup.mapper;

import com.itgroup.domain.Product;
import com.itgroup.domain.ProductCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface ProductMapper {
    @Select("select * from product where id = #{id}")
    Product getProductById(Long id);

    @Select("select * from product_category")
    List<ProductCategory> getProductCategoryList();

    @Select("select name from product_category")
    List<String> getProductCategoryName();

    @Select("select count(*) from product where product_categoryId = #{categoryId}")
    Integer getProductCountByCategoryId(Long categoryId);

}
