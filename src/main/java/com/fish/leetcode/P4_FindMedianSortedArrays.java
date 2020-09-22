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
        int[] nums1 = new int[]{1, 2, 3, 4, 5};
        int[] nums2 = new int[]{3, 5, 7, 9, 11, 13};
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
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }
    }

    public static int getKthElement(int[] nums1, int[] nums2, int k) {
        /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
         * 这里的 "/" 表示整除
         * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
         * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
         * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
         * 这样 pivot 本身最大也只能是第 k-1 小的元素
         * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
         * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
         * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
         */

        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kthElement = 0;

        while (true) {
            // 边界情况
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

    public static double findMedianSortedArraysWithBugs(int[] nums1, int[] nums2) {
        double avg1 = 0d;
        if (nums1.length != 0) {
            List<Integer> list1 = new ArrayList<>();
            if ((nums1.length + 1) % 2 == 0) {
                list1.add(nums1[(nums1.length + 1) / 2 - 1]);
            } else {
                list1.add(nums1[(nums1.length + 1) / 2 - 1]);
                list1.add(nums1[(nums1.length + 1) / 2]);
            }
            for (Integer integer : list1) {
                avg1 = avg1 + integer;
            }
            avg1 = avg1 / list1.size();
        }


        double avg2 = 0d;
        if (nums2.length != 0) {
            List<Integer> list2 = new ArrayList<>();
            if ((nums2.length + 1) % 2 == 0) {
                list2.add(nums2[(nums2.length + 1) / 2 - 1]);
            } else {
                list2.add(nums2[(nums2.length + 1) / 2 - 1]);
                list2.add(nums2[(nums2.length + 1) / 2]);
            }
            for (Integer integer : list2) {
                avg2 = avg2 + integer;
            }
            avg2 = avg2 / list2.size();
        }

        if (Double.compare(avg1, 0d) == 0 || Double.compare(avg2, 0d) == 0) {
            return Math.max(avg1, avg2);
        }

        if (((int) avg1) == ((int) avg2)) {
            return Math.max(avg1, avg2);
        } else {
            return (avg1 + avg2) / 2;
        }
    }

    public static int binarySearch(int[] nums, int target) {
        int start = 0, end = nums.length - 1, middle;
        while (start <= end) {
            middle = (start+end)>>>1;
            if (target == nums[middle]) {
                return middle;
            } else if (target < nums[middle]) {
                end = middle;
            } else {
                start = middle;
            }
        }
        return -1;
    }

}
