package com.itgroup.service.Impl;

import com.itgroup.domain.User;
import com.itgroup.exception.BusinessException;
import com.itgroup.mapper.UserMapper;
import com.itgroup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 用户注册
     *
     * @param user
     */
    @Override
    public void userRegister(User user) {
        userMapper.addUser(user);
    }

    @Override
    public User userLogin(User user) {
        User authenticatedUser = userMapper.getUserByUsername(user);
        if (authenticatedUser != null) {
            if (user.getPassword().equals(authenticatedUser.getPassword())) {
                return authenticatedUser;
            }
            throw new BusinessException("密码错误");
        }
        throw new BusinessException("用户名错误");
    }
}
