package com.fish.leetcode;

/**
 * @author yufei.liu
 * @version v1.0
 * @description
 * @date 2020:09:23 17:19
 */
public class P14_LongestCommonPrefix {

    public static void main(String[] args) {
        System.err.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    // 编写一个函数来查找字符串数组中的最长公共前缀。
    //
    // 如果不存在公共前缀，返回空字符串 ""。
    //
    // 示例 1:
    //
    // 输入: ["flower","flow","flight"]
    // 输出: "fl"
    //
    //
    // 示例 2:
    //
    // 输入: ["dog","racecar","car"]
    // 输出: ""
    // 解释: 输入不存在公共前缀。
    //
    //
    // 说明:
    //
    // 所有输入只包含小写字母 a-z 。
    // Related Topics 字符串
    // 👍 1275 👎 0

    /**
     * 横向扫描
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String commonPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            int j = 0;
            for (; j < commonPrefix.length() && j < str.length(); j++) {
                if (commonPrefix.charAt(j) != str.charAt(j)) {
                    break;
                }
            }
            commonPrefix = str.substring(0, j);
        }
        return commonPrefix;
    }

}
