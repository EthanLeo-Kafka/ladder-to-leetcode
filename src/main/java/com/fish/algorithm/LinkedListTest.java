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
        // singlyLinkedListReverse(createNewSinglyLinkedList());
        singlyLinkedListReverseRecursively(createNewSinglyLinkedList());
    }

    /**
     * 创建单链表
     */
    public static Node<Integer> createNewSinglyLinkedList() {
        Node<Integer> current = new Node<>();
        Node<Integer> head = current;
        for (int i = 1; i <= 5; i++) {
            current.next = new Node<>(i);
            current = current.next;
        }
        printLinkedList(head.next);
        return head.next;
    }

    /**
     * 单链表反转
     */
    public static void singlyLinkedListReverse(Node<Integer> head) {
        Node<Integer> pre = null;
        Node<Integer> cur = head;
        while (cur != null) {
            Node<Integer> temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        assert pre != null;
        printLinkedList(pre);
    }

    /**
     * 单链表反转 - 递归
     */
    public static void singlyLinkedListReverseRecursively(Node<Integer> head) {
        printLinkedList(doSinglyLinkedListReverseRecursively(head));
    }

    public static Node<Integer> doSinglyLinkedListReverseRecursively(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node<Integer> newHead = doSinglyLinkedListReverseRecursively(head.next);
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

        public Node() {}

        public Node(T item) {
            this.item = item;
        }

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }
}
