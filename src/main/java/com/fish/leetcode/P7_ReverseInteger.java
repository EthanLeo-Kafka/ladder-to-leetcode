package com.fish.leetcode;

/**
 * @author yufei.liu
 * @version v1.0
 * @description
 * @date 2020:09:22 14:32
 */
public class P7_ReverseInteger {

    public static void main(String[] args) {
        System.err.println(reverse(1534236469));
    }


    // 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
    //
    // 示例 1:
    //
    // 输入: 123
    // 输出: 321
    //
    //
    // 示例 2:
    //
    // 输入: -123
    // 输出: -321
    //
    //
    // 示例 3:
    //
    // 输入: 120
    // 输出: 21
    //
    //
    // 注意:
    //
    // 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
    // Related Topics 数学
    // 👍 2199 👎 0
    public static int reverse(int x) {
        long r = 0;
        while (x!=0) {
            r = r*10 + x%10;
            x = x/10;
        }
        return (int)r == r ? (int)r : 0;
    }

}
