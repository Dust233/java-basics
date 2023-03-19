package com.example.mybatis.controller;

import com.example.mybatis.mapper.MybatisPlusMapper;
import com.example.mybatis.model.User;
import com.example.mybatis.service.IMybatisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author LiJingZhi
 * @since 2023-02-19 15:57
 */
@RestController
@RequestMapping("myBatisController")
@RequiredArgsConstructor
public class MyBatisController {
    private final IMybatisService mybatisService;
    private final MybatisPlusMapper mapper;
    @GetMapping("selectAll")
    public List<User> selectAll(){
        return mybatisService.selectAll();
    }
    @GetMapping("selectById")
    public User selectById(Long id){
        return mybatisService.selectById(id);
    }
    @PostMapping("insert")
    public String insert(@RequestBody User user){
        return mybatisService.insert(user);
    }
    @PostMapping("update")
    public String update(@RequestBody User user){
        return mybatisService.update(user);
    }
    @GetMapping("deleteById")
    public String deleteById(Long id){
        Integer i = mapper.deleteById(id);
//        return mybatisService.deleteById(id);
        return i.toString();
    }
}
