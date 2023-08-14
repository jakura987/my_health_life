package com.itgroup.mapper;

import com.itgroup.domain.UserExerciseLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserExerciseLogMapper {

    @Select("select * from user_exercise_log where user_id = #{userId} ")
    List<UserExerciseLog> getUserExerciseLogByUserId(Long userId);
}
