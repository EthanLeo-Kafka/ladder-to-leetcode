/*
 * @Title CountingSort.java
 */
package com.fish.algorithm;

import java.util.Arrays;

/**
 * @author yufei.liu
 * @version v1.0
 * @description 计数排序 适合排序范围小，数据量大的场景，且只能给非负整数排序
 * @date 2020/12/15 00:22
 */
public class CountingSort {

    public static void main(String[] args) {
        Integer[] array = {5, 5, 3, 5, 0, 0, 3};
        countingSort(array, 7);
        System.err.println(Arrays.toString(array));
    }

    public static void countingSort(Integer[] array, Integer n) {
        if (n <= 1) {
            return;
        }

        // 数组中的数据范围
        Integer max = array[0];
        for (int i = 1; i < n; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }

        // 计数数组，下标大小 [0,max]
        Integer[] countingArray = new Integer[max + 1];
        // 计数数组，初始化
        for (int i = 0; i <= max; i++) {
            countingArray[i] = 0;
        }
        // 计数数组，计算每个下标所对应数值的元素个数
        for (int i = 0; i < n; i++) {
            countingArray[array[i]]++;
        }
        // 计数数组，每条数据表示的含义：小于等于当前下标的元素个数，所以此处累加
        for (int i = 1; i <= max; i++) {
            countingArray[i] = countingArray[i] + countingArray[i - 1];
        }
        // 临时数组，存储排序结果
        Integer[] tempArray = new Integer[n];
        for (int i = n - 1; i >= 0; i--) {
            Integer numWhichLeCurrent = countingArray[array[i]];
            tempArray[numWhichLeCurrent - 1] = array[i];
            countingArray[array[i]]--;
        }
        // 赋值给原数组
        for (int i = 0; i < n; i++) {
            array[i] = tempArray[i];
        }
    }
}
