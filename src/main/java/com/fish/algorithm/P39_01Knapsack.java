package com.fish.algorithm;

/**
 * @author yufei.liu
 * @version v1.0
 * @description
 * @date 2021-02-03 17:56
 */
public class P39_01Knapsack {

    public static void main(String[] args) {
        int[] w = {2, 1, 3, 2};
        int[] v = {12, 10, 20, 15};
        System.err.println(knapsack(w, v, 5));
    }

    /**
     * 解决背包问题的递归函数
     *
     * 递归方法
     * 首先我们用递归的方式来尝试解决这个问题
     * 我们用F(n,C)表示将前n个物品放进容量为C的背包里，得到的最大的价值。
     * 我们用自顶向下的角度来看，假如我们已经进行到了最后一步（即求解将n个物品放到背包里获得的最大价值），此时我们便有两种选择
     *
     * 不放第n个物品，此时总价值为F(n−1,C)
     * 放置第n个物品，此时总价值为vn+F(n−1,C−wn)
     * 两种选择中总价值最大的方案就是我们的最终方案，递推式（有时也称之为状态转移方程）如下
     * F(i,C)=max(F(i−1,C),v(i)+F(i−1,C−w(i)))
     *
     * @param weight   物品的重量数组
     * @param value    物品的价值数组
     * @param index    当前待选择的物品索引
     * @param capacity 当前背包有效容量
     * @return 最大价值
     */
    private static int solveKs(int[] weight, int[] value, int index, int capacity) {
        // 基准条件：如果索引无效或者容量不足，直接返回当前价值0
        if (index < 0 || capacity <= 0) {
            return 0;
        }
        // 不放第index个物品所得价值
        int result = solveKs(weight, value, index - 1, capacity);
        // 放第index个物品所得价值（前提是：第index个物品可以放得下）
        if (weight[index] <= capacity) {
            result = Math.max(result, value[index] + solveKs(weight, value, index - 1, capacity - weight[index]));
        }
        return result;
    }

    public static int knapsack(int[] w, int[] v, int c) {
        int size = w.length;
        return solveKs(w, v, size - 1, c);
    }
}
