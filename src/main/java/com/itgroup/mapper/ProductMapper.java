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

}
