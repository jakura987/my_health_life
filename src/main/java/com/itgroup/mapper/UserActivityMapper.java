package com.itgroup.mapper;

import com.itgroup.domain.UserActivity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserActivityMapper {

    @Select("select *from user_activity where id = #{id}")
    UserActivity getUserActivityRecord(Long id);
}
