/*
 * @Title QuickSort.java
 */
package com.fish.algorithm;

import java.util.Arrays;

/**
 * @author yufei.liu
 * @version v1.0
 * @description 快速排序
 * @date 2020/12/13 00:39
 */
public class QuickSort {

    public static void main(String[] args) {
        Integer[] array = {7, 3, 6, 1, 2, 0, 5, 8};
        quickSort(array);
        System.err.println(Arrays.toString(array));
    }

    public static void quickSort(Integer[] array) {
        doQuickSort(array, 0, array.length - 1);
    }

    public static void doQuickSort(Integer[] array, Integer left, Integer right) {
        if (left >= right) {
            return;
        }
        // 分区点
        Integer mid = partition(array, left, right);
        // 分区点的左数组 递归快排
        doQuickSort(array, left, mid - 1);
        // 分区点的右数组 递归快排
        doQuickSort(array, mid + 1, right);
    }

    /**
     * 分区函数做3件事
     *
     * 1、取数组末尾元素，作为pivot，pivot左边定义为 "已处理区间" （已处理区间的元素都小于pivot），pivot右边定义为 "未处理区间"
     *
     * 2、从未处理区间取值，与pivot比较，如果比pivot小，加入已处理区间的尾部
     *
     * 3、将pivot 置换到 已处理区间的尾部，并返回pivot的下标
     */
    public static Integer partition(Integer[] array, Integer left, Integer right) {
        Integer pivot = array[right];
        Integer i = left;
        for (int j = left; j < right; j++) {
            if (array[j] < pivot) {
                swap(array, i++, j);
            }
        }
        swap(array, i, right);
        return i;
    }

    public static void swap(Integer[] array, Integer i, Integer j) {
        Integer temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
