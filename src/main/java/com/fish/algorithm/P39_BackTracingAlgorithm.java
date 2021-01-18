/*
 * @Title P39_BackTracingAlgorithm.java
 */
package com.fish.algorithm;

/**
 * @author yufei.liu
 * @version v1.0
 * @description 回溯算法
 * @date 2021/1/18 23:16
 */
public class P39_BackTracingAlgorithm {

    public static void main(String[] args) {
        calc8queens(0);
    }

    /**
     * 8皇后问题 最终解，index表示行，value表示queen存储在哪一列
     */
    private static int[] result = new int[8];

    /**
     * 调用方式: calc8queens(0)
     */
    private static void calc8queens(int row) {
        if (row == 8) {
            printQueens(result);
            return;
        }
        // 每一行都有8种放法
        for (int column = 0; column < 8; ++column) {
            if (isOk(row, column)) {
                // 满足要求，第row行的queen放在第column列
                result[row] = column;
                // 继续下一行计算
                calc8queens(row+1);
            }
        }
    }

    private static boolean isOk(int row, int column) {
        int leftUp = column - 1;
        int rightUp = column + 1;
        // 当前列只关注其上一行的情况，比较 左上、正上、右上 是否符合条件
        for (int upRow = row - 1; upRow >= 0; --upRow) {
            if (result[upRow] == column) {
                // 正上的格子存在queen
                return false;
            }
            if (leftUp >= 0 && result[upRow] == leftUp) {
                // 左上的格子存在queen
                return false;
            }
            if (rightUp < 8 && result[upRow] == rightUp) {
                // 右上的格子存在queen
                return false;
            }
            --leftUp;
            ++rightUp;
        }
        return true;
    }


    /**
     * 打印二维矩阵
     *
     * @param result 8皇后问题结果
     */
    private static void printQueens(int[] result) {
        for (int row = 0; row < 8; ++row) {
            for (int column = 0; column < 8; ++column) {
                if (result[row] == column) {
                    System.err.print("Q ");
                } else {
                    System.err.print("* ");
                }
            }
            System.err.println();
        }
        System.err.println();
    }
}
