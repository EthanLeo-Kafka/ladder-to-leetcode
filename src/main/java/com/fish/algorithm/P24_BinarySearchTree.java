/*
 * @Title P24_BinarySearchTree.java
 */
package com.fish.algorithm;

import lombok.Data;

/**
 * @author yufei.liu
 * @version v1.0
 * @description
 * @date 2021/1/1 17:19
 */
public class P24_BinarySearchTree {

    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree();
        b.setTree(new TreeNode(1));
        TreeNode findResult = b.find(1);
        System.err.println(findResult);
    }
    
    @Data
    private static class BinarySearchTree {
        private TreeNode tree;

        private TreeNode find(int data) {
            TreeNode p = tree;
            while (p != null) {
                if (data < p.val) {
                    p = p.left;
                } else if (data > p.val) {
                    p = p.right;
                } else {
                    return p;
                }
            }
            return null;
        }
    }


    @Data
    private static class TreeNode {

        private Integer val;

        private P24_BinarySearchTree.TreeNode left;

        private P24_BinarySearchTree.TreeNode right;

        public TreeNode(Integer val) {
            this.val = val;
        }
    }
}
