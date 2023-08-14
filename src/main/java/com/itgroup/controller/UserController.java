package com.itgroup.controller;

import com.itgroup.common.R;
import com.itgroup.domain.User;
import com.itgroup.mapper.UserMapper;
import com.itgroup.utils.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@ResponseBody
@RequestMapping("/admin/user")
@Api(tags = "user相关接口")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @ApiOperation("测试Api")
    @GetMapping("/test")
    public String mytestDoc() {
        System.out.println("mytest");
        return "TEST succesful";
    }



    @ApiOperation("用户登录")
    @PostMapping("/login")
    public R<String> userLogin(@RequestBody User user) {
        User user1 = userMapper.userLogin(user);
        System.out.println(user);

        if(user1 != null){
            return R.success("user", "login success");
        }

        return R.error("username(邮箱)或者密码错误");


//        if (user1 != null) {
//            //登录成功后，生成jwt令牌
//            Map<String, Object> claims = new HashMap<>();
//            claims.put("userId", user.getId());
//            String token = JwtUtil.createJWT(
//                    "mytoken",
//                    3600 * 1000,
//                    claims);
//            System.out.println(token);
//            return R.success(token, "login success");
//        }


    }



}