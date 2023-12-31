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

    @Override
    public void userRegister(User user) {
        userMapper.addUser(user);
    }


    @Override
    public User userLogin(User user) {
        System.out.println("login...");
        User authenticatedUser = userMapper.getUserByUserName(user);
        if (authenticatedUser != null) {
            if (user.getPassword().equals(authenticatedUser.getPassword())) {
                return authenticatedUser;
            }
            throw new BusinessException("Incorrect password");
        }
        throw new BusinessException("Incorrect username");
    }

    @Override
    public User findUserById(Long id) {
        User user = userMapper.getUserById(id);
        if (user != null) {
            return user;
        }
        //TODO: Update this sentence(user does not exist)
        throw new BusinessException("no user exists");

    }

    @Override
    public void updateUser(User user) {
        if(user != null){
            userMapper.updateUser(user);
        }else
            throw new BusinessException("can not find user (in UpdateUserProfile)");
    }


}
