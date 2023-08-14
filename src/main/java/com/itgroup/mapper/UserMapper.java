package com.itgroup.mapper;

import com.itgroup.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User getUserById(Long id);

    @Select("select * from user where username = #{username} and password = #{password}")
    User userLogin(User user);

    @Insert("insert into user (name, password, height, weight, age, gender)VALUES (#{name}, #{password}, #{height}, #{weight}, #{age}, #{gender}) ")
    void addUser(User user);
}
