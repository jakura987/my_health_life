package com.itgroup.mapper;

import com.itgroup.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User getUserById(Long id);

    @Select("select * from user where username = #{username}")
    User getUserByUsername(User user);

    @Insert("insert into user (name, username, password, height, weight, age, gender)VALUES (#{name}, #{username}, #{password}, #{height}, #{weight}, #{age}, #{gender}) ")
    void addUser(User user);
}
