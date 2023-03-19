package com.example.javabasics.redis;

import com.example.mybatis.model.User;
import com.google.gson.Gson;
import redis.clients.jedis.Jedis;

/**
 * @author LiJingZhi
 * @since 2023-03-09 14:44
 */
public class RedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        Gson gson = new Gson();
        User user = new User(1, "李四光");
        jedis.set("NAME", gson.toJson(user));
        User name = gson.fromJson(jedis.get("NAME"), User.class);
        System.out.println(name);
        System.out.println(jedis.exists("NAME"));
        System.out.println(jedis.del("NAME"));
        System.out.println(jedis.get("NAME"));
    }
}
