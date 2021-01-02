/*
 * @Title P23_BTree.java
 */
package com.fish.algorithm;

import lombok.Data;

/**
 * @author yufei.liu
 * @version v1.0
 * @description 二叉树
 * @date 2021/1/1 15:59
 */
public class P23_BTree {


    public static void main(String[] args) {
        TreeNode bTree = generateBinaryTree();
        //preOrder(bTree);
        //inOrder(bTree);
        postOrder(bTree);
    }

    /**
     * 生成一个二叉树
     *
     *               1
     *             2  3
     *           4  5
     *         6  7
     *       8  9
     *
     */
    public static TreeNode generateBinaryTree() {
        int[] array = {1,2,3,4,5,6,7,8,9};
        TreeNode root = new TreeNode(array[0]);
        doGenerateBinaryTree(array, 1, root);
        return root;
    }

    /**
     * 递归生成二叉树的叶子节点
     */
    public static void doGenerateBinaryTree(int[] array, int index, TreeNode parentTree) {
        if (index >= array.length) {
            return;
        }
        if (parentTree.left == null) {
            parentTree.left = new TreeNode(array[index]);
            doGenerateBinaryTree(array, ++index, parentTree);
        } else if (parentTree.right == null) {
            parentTree.right = new TreeNode(array[index]);
            doGenerateBinaryTree(array, ++index, parentTree);
        } else {
            doGenerateBinaryTree(array, index, parentTree.left);
        }
    }

    /**
     * 前序遍历
     */
    public static void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.err.println(treeNode.val);
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }

    /**
     * 中序遍历
     */
    public static void inOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        inOrder(treeNode.left);
        System.err.println(treeNode.val);
        inOrder(treeNode.right);
    }

    /**
     * 后序遍历
     */
    public static void postOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        postOrder(treeNode.left);
        postOrder(treeNode.right);
        System.err.println(treeNode.val);
    }


    @Data
    private static class TreeNode {

        private Integer val;

        private TreeNode left;

        private TreeNode right;

        public TreeNode(Integer val) {
            this.val = val;
        }
    }

}
