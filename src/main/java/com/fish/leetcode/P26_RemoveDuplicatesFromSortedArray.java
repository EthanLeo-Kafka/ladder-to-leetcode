package com.fish.leetcode;

/**
 * @author yufei.liu
 * @version v1.0
 * @description
 * @date 2022-08-30 17:30
 */
public class P26_RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] array = {1, 1, 1, 2, 2, 3, 4, 4, 4, 4, 5, 6, 6, 6};
        int i = removeDuplicates(array);
        System.err.println(i);
    }

    /**
     * 有序数组 清除重复元素
     */
    public static int removeDuplicates(int[] nums) {
        int i = nums.length > 0 ? 1 : 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > nums[i-1]) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}
