package com.fish.leetcode;


import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yufei.liu
 * @version v1.0
 * @description
 * @date 2020:09:15 16:57
 */
public class P1_TwoSum {


    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.err.println(Arrays.toString(result));
    }

    //给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
    //
    // 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
    //
    //
    //
    // 示例:
    //
    // 给定 nums = [2, 7, 11, 15], target = 9
    //
    //因为 nums[0] + nums[1] = 2 + 7 = 9
    //所以返回 [0, 1]
    //
    // Related Topics 数组 哈希表
    // 👍 9123 👎 0
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map1.put(nums[i], i);
            int res = target - nums[i];
            if (map1.containsKey(res)) {
                return new int[]{i, map1.get(res)};
            }
        }
        throw new IllegalArgumentException("no match result");
    }

}
