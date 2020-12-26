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
        System.err.println(bsearchRecursively(array, array.length, 7));
    }

    /**
     * 二分查找易出错的地方
     *
     * 1. 循环退出条件。注意是 low <= high，而不是 low < high
     *
     * 2. mid 的取值。实际上，mid=(low+high)/2 这种写法是有问题的。因为如果 low 和 high 比较大的话，两者之和就有可能会溢出。
     *
     * 3. low 和 high 的更新。如果直接写成 low=mid 或者 high=mid，就可能会发生死循环。
     *
     *
     *
     * 二分查找的局限性：
     *
     * 1.   二分查找依赖的是顺序表结构，简单点说就是数组
     *
     * 2.   二分查找针对的是有序数据
     *
     * 3.   数据量太小不适合二分查找。例外情况：如果数据之间的比较操作非常耗时，不管数据量大小，都推荐使用二分查找。
     *
     * 4.   数据量太大也不适合二分查找。二分查找依赖数组，数组随机访问的特性要求内存空间连续。
     */
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

    /**
     * low + high 有溢出的风险，所以使用 (high-low)/2 + low
     */
    public static int bsearch2(int[] array, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = ((high - low) >> 1) + low;
            if (array[mid] == value) {
                return mid;
            } else if (array[mid] > value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找 递归实现
     */
    public static int bsearchRecursively(int[] array, int n, int value) {
        return doBsearchRecursively(array, 0, n - 1, value);
    }

    public static int doBsearchRecursively(int[] array, int low, int high, int value) {
        int mid = ((high - low) >> 1) + low;
        if (array[mid] == value) {
            return mid;
        }
        if (array[mid] > value) {
            return doBsearchRecursively(array, low, mid - 1, value);
        }
        return doBsearchRecursively(array, mid + 1, high, value);
    }



}
