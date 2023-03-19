package com.example.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatis.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author LiJingZhi
 * @since 2023-02-25 21:22
 */
@Mapper
public interface MybatisPlusMapper extends BaseMapper<User> {

}
