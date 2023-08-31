package com.itgroup.mapper;

import com.itgroup.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User getUserById(Long id);

    @Select("select * from user where userName = #{userName}")
    User getUserByUserName(User user);

    @Insert("insert into user (firstName, lastName, userName, password, height, weight, age, gender)VALUES (#{firstName}, #{lastName}, #{userName}, #{password}, #{height}, #{weight}, #{age}, #{gender}) ")
    void addUser(User user);
}
