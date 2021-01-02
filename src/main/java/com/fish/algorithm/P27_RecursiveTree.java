/*
 * @Title P27_RecursiveTree.java
 */
package com.fish.algorithm;

/**
 * @author yufei.liu
 * @version v1.0
 * @description 递归树
 * @date 2021/1/2 16:46
 */
public class P27_RecursiveTree {

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        printPermutations(a, 4, 4);
    }


    /**
     * 分析全排列的时间复杂度
     */
    public static void printPermutations(int[] data, int n, int k) {
        if (k == 1) {
            for (int i = 0; i < n; ++i) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < k; ++i) {
            int tmp = data[i];
            data[i] = data[k - 1];
            data[k - 1] = tmp;
            printPermutations(data, n, k - 1);
            tmp = data[i];
            data[i] = data[k - 1];
            data[k - 1] = tmp;
        }
    }
}
