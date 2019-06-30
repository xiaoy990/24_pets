package com.nenu.ossas.service.userservice;

import com.nenu.ossas.entity.user.User;

import java.util.List;

public interface UserService {

    List getAllUsers();
    User findByName(String name);
    User findById(int id);
    void logout();
    void addUser(User user);
    void delUser(User user);
}
