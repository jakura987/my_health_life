package com.itgroup.mapper;

import com.itgroup.domain.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProductMapper {
    @Select("select * from product where id = #{id}")
    Product getProductById(Long id);
}
