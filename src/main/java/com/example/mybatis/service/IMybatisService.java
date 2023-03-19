package com.example.mybatis.service;

import com.example.mybatis.model.User;

import java.util.List;

/**
 * @author LiJingZhi
 * @since 2023-02-25 21:13
 */
public interface IMybatisService {
    List<User> selectAll();

    User selectById(Long id);

    String insert(User user);

    String update(User user);

    String deleteById(Long id);
}
