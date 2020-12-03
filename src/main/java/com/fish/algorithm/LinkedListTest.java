/*
 * @Title LinkedListTest.java
 */
package com.fish.algorithm;

import lombok.Data;

/**
 * @author yufei.liu
 * @version v1.0
 * @description 链表数据结构
 * @date 2020/11/28 23:28
 */
public class LinkedListTest {

    public static void main(String[] args) {
        printLinkedList(createNodeList());
        printLinkedList(reverseNodeList(createNodeList()));
        printLinkedList(reverseNodeList2(createNodeList()));

        printLinkedList(createNodeList2(5));
        printLinkedList(reverseNodeList(createNodeList2(5)));
        printLinkedList(reverseNodeList2(createNodeList2(5)));
    }

    /**
     * 创建单链表
     */
    public static Node<Integer> createNodeList() {
        Node<Integer> current = new Node<>();
        Node<Integer> head = current;
        for (int i = 1; i <= 5; i++) {
            current.next = new Node<>(i);
            current = current.next;
        }
        return head.next;
    }

    /**
     * 创建单链表 - 递归
     */
    public static Node<Integer> createNodeList2(int i) {
        if (i <= 0) {
            return null;
        }
        Node<Integer> node = new Node<>(i);
        node.next = createNodeList2(--i);
        return node;
    }

    /**
     * 单链表反转
     */
    public static Node<Integer> reverseNodeList(Node<Integer> head) {
        Node<Integer> pre = null;
        Node<Integer> cur = head;
        while (cur != null) {
            Node<Integer> temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     * 单链表反转 - 递归
     */
    public static Node<Integer> reverseNodeList2(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node<Integer> newHead = reverseNodeList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * 打印链表
     */
    public static void printLinkedList(Node<?> node) {
        while (node != null) {
            System.err.println(node.item + " : " + node.toString());
            node = node.next;
        }
        System.err.println("------------------------");
    }

    @Data
    public static class Node<T> {
        public T item;
        public Node<T> next;

        public Node() {
        }

        public Node(T item) {
            this.item = item;
        }

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }
}
