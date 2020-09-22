package com.fish.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author yufei.liu
 * @version v1.0
 * @description
 * @date 2020:09:22 16:11
 */
public class P9_IsPalindrome {

    public static void main(String[] args) {
        System.err.println(isPalindrome3(123454321));
    }

    // 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
    //
    // 示例 1:
    //
    // 输入: 121
    // 输出: true
    //
    //
    // 示例 2:
    //
    // 输入: -121
    // 输出: false
    // 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
    //
    //
    // 示例 3:
    //
    // 输入: 10
    // 输出: false
    // 解释: 从右向左读, 为 01 。因此它不是一个回文数。
    //
    //
    // 进阶:
    //
    // 你能不将整数转为字符串来解决这个问题吗？
    // Related Topics 数学
    // 👍 1243 👎 0
    public static boolean isPalindrome(int x) {
        char[] arr = String.valueOf(x).toCharArray();
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            if (arr[start] == arr[end]) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        List<Integer> nums = new ArrayList<>(10);
        while (x > 0) {
            nums.add(x % 10);
            x /= 10;
        }
        int start = 0, end = nums.size() - 1;
        while (start <= end) {
            if (Objects.equals(nums.get(start), nums.get(end))) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * better way
     */
    public static boolean isPalindrome3(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int reverseNum = 0;
        while (x > reverseNum) {
            int mod = x % 10;
            reverseNum = reverseNum * 10 + mod;
            x /= 10;
        }

        return reverseNum == x || reverseNum / 10 == x;
    }

}
