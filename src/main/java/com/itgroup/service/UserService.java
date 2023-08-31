package com.itgroup.service;

import com.itgroup.domain.User;

public interface UserService {
    void userRegister(User user);
    User userLogin(User user);
    User findUserById(Long id);
    void UpdateUserProfile(User user);

}
