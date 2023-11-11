package com.example.javabasics.leetcode;

import cn.hutool.core.collection.ListUtil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiJingZhi
 * @since 2023-11-07 16:18
 */
public class LeetCode {

    /**
     * 给出一个数组和目标值，找出两数之和等于目标值的下标，下标不能相同
     */
    @Test
    public void test1() {
        int[] nums = {2,7,11,15};
        int target = 9;
        List<Integer> indexs = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (i != j && (nums[i] + nums[j]) == target){
//                    indexs = ListUtil.toList(i, j);
//                }
//            }
//        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)){
                indexs = ListUtil.toList(map.get(num), i);
            }
            map.put(nums[i], i);
        }

        System.out.println(indexs);

    }
}
