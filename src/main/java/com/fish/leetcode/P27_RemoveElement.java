package com.fish.leetcode;

/**
 * @author yufei.liu
 * @version v1.0
 * @description
 * @date 2022-08-30 17:34
 */
public class P27_RemoveElement {

    public static void main(String[] args) {
        //int[] nums = {0,1,2,2,2,2,3,0,4,2};
         int[] nums = {2,2,2,2,3,0,4,2};
        int val = 2;
        System.err.println(removeElement2(nums, val));
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] == val && nums[j] != val) {
                nums[i] = nums[j];
                nums[j] = val;
            }
            if (nums[i++] == val) {
                i--;
            }
        }
        return i;
    }

    public static int removeElement2(int[] nums, int val) {
        int i = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i++] = nums[j];
            }
        }

        return i;
    }
}
