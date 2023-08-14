package com.itgroup;

import com.itgroup.domain.User;
import com.itgroup.domain.UserActivity;
import com.itgroup.domain.UserExerciseLog;
import com.itgroup.exception.BusinessException;
import com.itgroup.mapper.UserActivityMapper;
import com.itgroup.mapper.UserExerciseLogMapper;
import com.itgroup.mapper.UserMapper;
import com.itgroup.utils.CalorieUtil;
import com.itgroup.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MyHealthLifeApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserActivityMapper userActivityMapper;
    @Autowired
    private UserExerciseLogMapper logMapper;

    @Test
    void contextLoads() {
        System.out.println(userMapper.getUserById(1L));
    }

    @Test
    void testJWT(){
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name", "Tom");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "mytoken")
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                .compact();

        System.out.println(jwt);

    }

    @Test
    void testParseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("mytoken")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiVG9tIiwiaWQiOjEsImV4cCI6MTY5MTY0NjIyNX0.CYRnVb9Y2cP6lv0KvAGA9oILQ6xgQ5-9O6uI2XwQuA8")
                .getBody();
        System.out.println(claims);
        System.out.println(claims.get("id"));
    }

    @Test
    void testCalculateCalorie(){
        int bmr = CalorieUtil.calculateBmr(new BigDecimal(67), new BigDecimal(176), 18, "male");
        System.out.println("bmr" + bmr);
        int calorieNeeds = CalorieUtil.calculateDailyCalorieNeeds(bmr, "Light");
        System.out.println(calorieNeeds);

    }

    @Test
    void testUserActivityRecord(){
        UserActivity activityRecord = userActivityMapper.getUserActivityRecord(1L);
        System.out.println(activityRecord);
    }

    @Test
    void testAddUser(){
        userMapper.addUser(new User("Rose", "123", new BigDecimal(165), new BigDecimal(51), 18, "female"));

    }

    @Test
    void testUserExerciseLog(){
        List<UserExerciseLog> logList = logMapper.getUserExerciseLogByUserId(1L);
        for (UserExerciseLog userExerciseLog :
                logList) {
            System.out.println(userExerciseLog);
        }
    }
    @Test
    void testExceptionError(){
        throw new BusinessException("ddd");
    }



}
