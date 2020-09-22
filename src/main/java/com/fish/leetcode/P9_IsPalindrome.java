package com.fish.leetcode;

/**
 * @author yufei.liu
 * @version v1.0
 * @description
 * @date 2020:09:22 16:11
 */
public class P9_IsPalindrome {

    public static void main(String[] args) {
        System.err.println(isPalindrome(1234554321));
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
        int start = 0, end = arr.length-1;
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

}
