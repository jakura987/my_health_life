package com.itgroup.controller;

import com.itgroup.common.JwtProperties;
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
@Api(tags = "user related interface")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtProperties jwtProperties;

    /**
     * Handles the POST request to register a new user.
     *
     * @param userRegisterDTO The registration details received as a JSON in the request body.
     * @return R object encapsulating the success response message.
     */
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

    /**
     * Handles the POST request for user login.
     * If login is successful, a JWT token will be generated and returned.
     *
     * @param userLoginDTO The login details received as a JSON in the request body.
     * @return R object encapsulating the success response with JWT token or an error message.
     */
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
                    jwtProperties.getName(),
                    jwtProperties.getExpiry(),
                    claims);

            return R.success(token);
        }
        return R.error("Um... some unknown issues, perhaps Bob can solve");

    }

    /**
     * Handles the GET request to retrieve the profile details of a specific user.
     *
     * @param userId The ID of the user whose details are to be retrieved.
     * @return R object encapsulating the success response and the user details.
     */
    @ApiOperation("User Profile")
    @GetMapping("/{userId}")
    public R<User> userDetail(@PathVariable Long userId) {
        User user = userService.findUserById(userId);
        log.info("user:{}", user);
        return R.success(user);

    }

    /**
     * Handles the PUT request to update the profile details of a user.
     *
     * @param user The updated user details received as a JSON in the request body.
     * @return R object encapsulating the success response message.
     */
    @ApiOperation("Update User")
    @PutMapping("/updateUserProfile")
    public R<String> updateUser(@RequestBody User user){
        userService.updateUser(user);
        return R.success("User updated successfully");
    }


}
