package com.spring.jdbc.service;

import com.spring.jdbc.entry.User;

import java.util.List;

/**
 * @Description
 * @Author Aaron
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/6/14
 */
public interface UserService {
    void create(String name, Integer age);
    void deleteByName(Integer id);
    List<User> getAllUsers();
    void deleteAllUsers();
}
