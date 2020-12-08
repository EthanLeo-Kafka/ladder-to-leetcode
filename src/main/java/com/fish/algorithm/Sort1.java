/*
 * @Title Sort1.java
 */
package com.fish.algorithm;

import java.util.Arrays;

/**
 * @author yufei.liu
 * @version v1.0
 * @description 简单排序算法
 * @date 2020/12/8 23:14
 */
public class Sort1 {

    public static void main(String[] args) {
        int[] array = {5, 1, 3, 2, 4};
        // bubbleSort(array);
        // insertSort(array);
        selectSort(array);
        System.err.println(Arrays.toString(array));
    }

    /**
     * 选择排序 原地排序算法[空间复杂度O(1)] | 不稳定排序算法 | 时间复杂度O(n²)
     */
    public static void selectSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int minimumIndex = i;
            for (int j = i; j < n; j++) {
                if (array[j] < array[minimumIndex]) {
                    minimumIndex = j;
                }
            }
            if (minimumIndex != i) {
                int temp = array[i];
                array[i] = array[minimumIndex];
                array[minimumIndex] = temp;
            }
        }
    }

    /**
     * 插入排序 原地排序算法[空间复杂度O(1)] | 稳定排序算法 | 时间复杂度O(n²)
     */
    public static void insertSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int value = array[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (value < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = value;
        }
    }

    /**
     * 冒泡排序 原地排序算法[空间复杂度O(1)] | 稳定排序算法 | 时间复杂度O(n²)
     */
    public static void bubbleSort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int n = array.length;
        for (int i = 0; i < n; i++) {
            boolean finishFlag = true;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    finishFlag = false;
                }
            }
            if (finishFlag) {
                break;
            }
        }
    }
}
