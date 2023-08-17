package com.itgroup.controller;

import com.itgroup.common.R;
import com.itgroup.domain.User;
import com.itgroup.mapper.UserMapper;
import com.itgroup.service.UserService;
import com.itgroup.utils.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@ResponseBody
@RequestMapping("/admin/user")
@Api(tags = "user相关接口")
@Slf4j
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @ApiOperation("测试Api")
    @GetMapping("/test")
    public R<String> mytestDoc() {
        System.out.println("mytest");
        return R.success("success", "测试成功");
    }


    @ApiOperation("用户注册")
    @PostMapping("/register")
    public R<String> userRegister(@RequestBody User user){
        log.info("User{}",user);
        userService.userRegister(user);
        return R.success("user", "register success");
    }

    @ApiOperation("用户登录")
    @PostMapping("/login")
    public R<String> userLogin(@RequestBody User user) {
        User authenticatedUser = userService.userLogin(user);
        if (authenticatedUser != null) {
            //登录成功后，生成jwt令牌
            Map<String, Object> claims = new HashMap<>();
            String token = JwtUtil.createJWT(
                    "usertoken",
                    7200 * 1000,
                    claims);
            return R.success(token, "login success");
        }
        return R.error("嗯...一些未知的问题, 也许Bob可以解决");


    }



}
