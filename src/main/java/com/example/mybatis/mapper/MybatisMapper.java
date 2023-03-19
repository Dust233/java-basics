package com.example.mybatis.mapper;

import com.example.mybatis.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author LiJingZhi
 * @since 2023-02-25 21:22
 */
@Mapper
public interface MybatisMapper {
    List<User> selectAll();

    User selectById(Long id);

    Integer insert(@Param("user") User user);

    Integer update(@Param("user") User user);

    Integer deleteById(Long id);
}
