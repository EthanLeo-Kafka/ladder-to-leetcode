package com.fish.leetcode;

/**
 * @author yufei.liu
 * @version v1.0
 * @description
 * @date 2022-08-30 17:30
 */
public class P26_RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        System.err.println(removeDuplicates(new int[]{1,2,2,3,3,3}));
    }

    /**
     * 有序数组 清除重复元素
     */
    public static int removeDuplicates(int[] nums) {
        // iterator thru array
        int i = 1;
        // current index
        int j = 0;
        for (; i < nums.length; i++) {
            // new number
            if (nums[i] != nums[j]) {
                // move current index
                j++;
                // fill current index with new number
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
}
