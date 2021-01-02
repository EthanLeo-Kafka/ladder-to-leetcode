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

        /**
         * 二叉查找树，查找
         */
        public TreeNode find(int data) {
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

        /**
         * 二叉查找树，插入
         */
        public void insert(int data) {
            if (tree == null) {
                tree = new TreeNode(data);
                return;
            }

            TreeNode p = tree;
            while (p != null) {
                if (data > p.val) {
                    if (p.right == null) {
                        p.right = new TreeNode(data);
                        return;
                    } else {
                        p = p.right;
                    }
                } else {
                    // data < p.val
                    if (p.left == null) {
                        p.left = new TreeNode(data);
                        return;
                    } else {
                        p = p.left;
                    }
                }
            }
        }

        /**
         * 二叉查找树，删除
         *
         * 一、逻辑删除：
         * 将要删除的节点标记为“已删除”，但是并不真正从树中将这个节点去掉。
         * 这样原本删除的节点还需要存储在内存中，比较浪费内存空间，但是删除操作就变得简单了很多。
         * 而且，这种处理方法也并没有增加插入、查找操作代码实现的难度。
         *
         * 二、物理删除，分三种情况：
         *
         * 1、待删除的节点b，没有子节点。直接删除（b的父节点a指向b的指针置为null）。
         *
         * 2、待删除的节点b，只有一个子节点c（左子节点 或 右子节点）。此时，b的父节点a的指针需指向c
         *
         * 3、待删除的节点b，有两个子节点（左子节点c 和 右子节点d）。此时，需要去b的右子树中查找最小值x，将x替换到b的位置；然后再删除节点x
         */
        public void delete(int data) {
            // 待删除的节点b，初始化为根节点
            TreeNode b = tree;
            // b的父节点a
            TreeNode a = null;
            while (b != null && b.val != data) {
                a = b;
                if (data > b.val) {
                    b = b.right;
                } else {
                    b = b.left;
                }
            }
            // 未找到待删除的节点
            if (b == null) {
                return;
            }

            // 第3种情况：待删除的节点b，有两个子节点
            if (b.left != null && b.right != null) {
                // 需要去b的右子树中查找最小值
                TreeNode minRight = b.right;
                // minRight父节点
                TreeNode minRightParent = b;
                while (minRight.left != null) {
                    minRightParent = minRight;
                    minRight = minRight.left;
                }
                // 将minRight的数据替换到 待删除的节点b 中
                b.val = minRight.val;
                // 以下就变成删除minRight了
                b = minRight;
                a = minRightParent;
            }

            // 第2种情况：待删除的节点b，只有一个子节点c
            TreeNode c;
            if (b.left != null) {
                c = b.left;
            } else if (b.right != null) {
                c = b.right;
            } else {
                c = null;
            }

            // 待删除的节点b的父节点a指针指向b的子节点c
            if (a == null) {
                // 删除的是根节点
                tree = c;
            } else if (a.left == b) {
                // 删除的是左子节点
                a.left = c;
            } else {
                // 删除的是右子节点
                a.right = c;
            }
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
