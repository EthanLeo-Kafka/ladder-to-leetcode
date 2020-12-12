/*
 * @Title MergeSort.java
 */
package com.fish.algorithm;

import java.util.Arrays;

/**
 * @author yufei.liu
 * @version v1.0
 * @description 归并排序
 * @date 2020/12/12 21:03
 */
public class MergeSort {

    public static void main(String[] args) {
        Integer[] array = {8, 3, 6, 1, 2, 0, 5, 7};
        mergeSort(array);
        System.err.println(Arrays.toString(array));
    }

    public static void mergeSort(Integer[] array) {
        Integer[] temp = new Integer[array.length];
        doMergeSort(array, 0, array.length - 1, temp);
    }

    /**
     * 递归调用函数
     */
    public static void doMergeSort(Integer[] array, Integer left, Integer right, Integer[] temp) {
        // 递归终止条件
        if (left >= right) {
            return;
        }
        // 取startIndex到endIndex之间的中间位置q
        int mid = (left + right) / 2;
        // 分治递归
        doMergeSort(array, left, mid, temp);
        doMergeSort(array, mid + 1, right, temp);
        // 合并
        merge(array, left, mid, right, temp);
    }

    public static void merge(Integer[] array, Integer left, Integer mid, Integer right, Integer[] temp) {
        // 左数组指针
        int i = left;
        // 右数组指针
        int j = mid + 1;
        // 临时数组指针
        int k = 0;

        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = array[i++];
        }

        while (j <= right) {
            temp[k++] = array[j++];
        }

        k = 0;
        while (left <= right) {
            array[left++] = temp[k++];
        }
    }

}
