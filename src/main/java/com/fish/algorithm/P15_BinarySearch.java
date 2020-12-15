/*
 * @Title P15_BinarySearch.java
 */
package com.fish.algorithm;

/**
 * @author yufei.liu
 * @version v1.0
 * @description 二分查找
 * @date 2020/12/16 00:48
 */
public class P15_BinarySearch {

    public static void main(String[] args) {
        int[] array = {1, 3, 4, 5, 6, 7, 8, 9, 11, 12};
        System.err.println(bsearch(array, array.length, 7));
    }

    public static int bsearch(int[] array, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] == value) {
                return mid;
            } else if (array[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
