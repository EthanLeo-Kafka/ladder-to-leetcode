/*
 * @Title P28_HeapSort.java
 */
package com.fish.algorithm;

/**
 * @author yufei.liu
 * @version v1.0
 * @description
 * @date 2021/1/2 18:03
 */
public class P28_HeapSort {


    /**
     * 大顶堆
     */
    private static class Heap {
        // 数组，从下标1开始存储数据，方便求左子节点、右子节点、父节点的index
        private int[] a;
        // 堆可以存储的最大数据个数
        private int n;
        // 堆中已经存储的数据个数
        private int count;

        public Heap(int capacity) {
            a = new int[capacity + 1];
            n = capacity;
            count = 0;
        }

        /**
         * 堆，插入元素
         */
        public void insert(int data) {
            if (count >= n) {
                throw new RuntimeException("Heap overflow");
            }
            ++count;
            a[count] = data;
            // 自下往上堆化
            int i = count;
            while (i / 2 > 0 && a[i] > a[i / 2]) {
                swap(a, i, i / 2);
                i = i / 2;
            }
        }

        private static void swap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        /**
         * 删除堆顶元素
         *
         * 1. 将堆顶 替换为 堆尾部元素
         *
         * 2. 自上往下堆化
         */
        public void removeTop() {
            if (count == 0) {
                throw new RuntimeException("heap is empty");
            }
            a[1] = a[count];
            --count;
            heapify(a, count, 1);
        }

        /**
         * 自上往下堆化
         */
        public static void heapify(int[] a, int n, int i) {
            while (true) {
                // 更大的值的下标
                int maxPosition = i;
                // 比较左子节点
                if (i * 2 <= n && a[i * 2] > a[i]) {
                    maxPosition = i * 2;
                }
                // 比较右子节点
                if (i * 2 + 1 <= n && a[i * 2 + 1] > a[i]) {
                    maxPosition = i * 2 + 1;
                }
                // 自己就是最大的值，跳出循环
                if (maxPosition == i) {
                    break;
                }
                // 交换位置
                swap(a, i, maxPosition);
                // 关注节点更换
                i = maxPosition;
            }
        }


        /**
         * 对已存在的数组，建队
         *
         * @param a 已存在的数组
         * @param n 已存在的数组的大小
         */
        public static void buildHeap(int[] a, int n) {
            for (int i = n / 2; i > 1; i--) {
                heapify(a, n, i);
            }
        }


        /**
         * 堆排序
         *
         * 1. 建堆，大顶堆
         *
         * 2. 堆顶元素即为最大值，将堆顶元素移到数组尾部
         *
         * 3. 将剩下的n-1个元素重新堆化
         *
         * 4. 新生成的堆的堆顶元素即为第二大元素，重复 2-3 步
         */
        public static void sort(int[] a, int n) {
            buildHeap(a, n);
            int k = n;
            while (k > 1) {
                swap(a, 1, k);
                --k;
                heapify(a, k, 1);
            }
        }
    }
}
