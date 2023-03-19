package com.example.mybatis.service.impl;

import com.example.mybatis.mapper.MybatisMapper;
import com.example.mybatis.model.User;
import com.example.mybatis.service.IMybatisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiJingZhi
 * @since 2023-02-25 21:16
 */
@Service
@RequiredArgsConstructor
public class MybatisServiceImpl implements IMybatisService {
    private final MybatisMapper mybatisMapper;
    @Override
    public List<User> selectAll() {
        return mybatisMapper.selectAll();
    }

    @Override
    public User selectById(Long id) {
        return mybatisMapper.selectById(id);
    }

    @Override
    public String insert(User user) {

        Integer insert = mybatisMapper.insert(user);;
        if (insert <= 0){
            return "添加失败！";
        }
        return "添加成功！";
    }

    @Override
    public String update(User user) {

        Integer update = mybatisMapper.update(user);
        if (update <= 0){
            return "修改失败！";
        }
        return "修改成功！";
    }

    @Override
    public String deleteById(Long id) {
        Integer delete = mybatisMapper.deleteById(id);
        System.out.println(delete);

        if (delete <= 0){
            return "删除失败！";
        }
        return "删除成功！";
    }
}
