package com.example.mybatis.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * @author LiJingZhi
 * @since 2023-02-25 21:45
 */
@Data
@ToString
@TableName("test")
public class User {
    private Integer id;
    private String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }
}
