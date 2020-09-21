package com.fish.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yufei.liu
 * @version v1.0
 * @description
 * @date 2020:09:16 17:14
 */
public class P4_FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{1};
        System.err.println(findMedianSortedArrays(nums1, nums2));
    }

    // 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
    //
    // 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
    //
    // 你可以假设 nums1 和 nums2 不会同时为空。
    //
    //
    //
    // 示例 1:
    //
    // nums1 = [1, 3]
    // nums2 = [2]
    //
    // 则中位数是 2.0
    //
    //
    // 示例 2:
    //
    // nums1 = [1, 2]
    // nums2 = [3, 4]
    //
    // 则中位数是 (2 + 3)/2 = 2.5
    //
    // Related Topics 数组 二分查找 分治算法
    // 👍 3187 👎 0

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>();
        if ((nums1.length + 1) % 2 == 0) {
            list1.add(nums1[(nums1.length+1)/2  - 1]);
        } else {
            list1.add(nums1[(nums1.length+1)/2  - 1]);
            list1.add(nums1[(nums1.length+1)/2]);
        }

        double avg1 = 0d;
        for (Integer integer : list1) {
            avg1 = avg1 + integer;
        }
        avg1 = avg1 / list1.size();

        List<Integer> list2 = new ArrayList<>();
        if ((nums2.length + 1) % 2 == 0) {
            list2.add(nums2[(nums2.length+1)/2 - 1]);
        } else {
            list2.add(nums2[(nums2.length+1)/2 - 1]);
            list2.add(nums2[(nums2.length+1)/2]);
        }

        double avg2 = 0d;
        for (Integer integer : list2) {
            avg2 = avg2 + integer;
        }
        avg2 = avg2 / list2.size();

        return (avg1 + avg2) / 2;
    }

}
