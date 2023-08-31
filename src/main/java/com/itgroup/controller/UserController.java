package com.itgroup.controller;

import com.itgroup.common.R;
import com.itgroup.domain.User;
import com.itgroup.dto.UserLoginDTO;
import com.itgroup.dto.UserRegisterDTO;
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

    @ApiOperation("TestApi")
    @GetMapping("/test")
    public R<String> mytestDoc() {
        System.out.println("mytest");
        return R.success("测试成功");
    }


    @ApiOperation("User Register")
    @PostMapping("/register")
    public R<String> userRegister(@RequestBody UserRegisterDTO userRegisterDTO) {
        User user = User.builder()
                .userName(userRegisterDTO.getEmail())
                .firstName(userRegisterDTO.getFirstName())
                .lastName(userRegisterDTO.getLastName())
                .password(userRegisterDTO.getPassword())
                .build();

        log.info("User{}", user);
        userService.userRegister(user);
        return R.success("register success");
    }

    @ApiOperation("User Login")
    @PostMapping("/login")
    public R<String> userLogin(@RequestBody UserLoginDTO userLoginDTO) {
        User authenticatedUser = userService.userLogin(User.builder()
                .userName(userLoginDTO.getEmail())
                .password(userLoginDTO.getPassword())
                .build());
        if (authenticatedUser != null) {
            //generate JWT token after logging successfully
            Map<String, Object> claims = new HashMap<>();
            claims.put("userId", authenticatedUser.getId());
            claims.put("userFirstName", authenticatedUser.getFirstName());
            String token = JwtUtil.createJWT(
                    "usertoken",
                    7200 * 1000,
                    claims);
            return R.success(token);
        }
        //TODO: update this sentence (unknown error)
        return R.error("Um... some unknown issues, perhaps Bob can solve");

    }

    /**
     * Display information on the profile page
     *
     * @param userId
     * @return
     */
    @ApiOperation("User Profile")
    @GetMapping("/{userId}")
    public R<User> userDetail(@PathVariable Long userId) {
        User user = userService.findUserById(userId);
        log.info("user:{}", user);
        return R.success(user);

    }

    @ApiOperation("Update Profile")
    @PostMapping("/updateProfile")
    public R<String> updateUserProfileById(@RequestBody User user){
        System.out.println("333");
        userService.UpdateUserProfile(user);
        return R.success("update successfully");
    }


}
