package com.fish.leetcode;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

/**
 * @author yufei.liu
 * @version v1.0
 * @description
 * @date 2020:09:15 17:35
 */
public class P2_AddTwoNums {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode l3 = addTwoNumbers(l1, l2);

        ListNode tmp = l3;
        do {
            System.err.println(tmp.val);
        } while ((tmp = tmp.next) != null);
    }

    // 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
    //
    // 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
    //
    // 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
    //
    // 示例：
    //
    // 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    // 输出：7 -> 0 -> 8
    // 原因：342 + 465 = 807
    //
    // Related Topics 链表 数学
    // 👍 4895 👎 0
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        ListNode head = new ListNode();
        ListNode curr = head;
        // 进位
        int k = 0;
        do {
            int sum = Optional.ofNullable(tmp1).map(ListNode::getVal).orElse(0) + Optional.ofNullable(tmp2).map(ListNode::getVal).orElse(0) + k;
            ListNode newNode;
            if (sum > 9) {
                newNode = new ListNode(sum - 10);
                k = 1;
            } else {
                newNode = new ListNode(sum);
                k = 0;
            }
            curr.setNext(newNode);
            curr = newNode;
        } while ((tmp1 = Optional.ofNullable(tmp1).map(ListNode::getNext).orElse(null)) != null | (tmp2 = Optional.ofNullable(tmp2).map(ListNode::getNext).orElse(null)) != null | k != 0);
        return head.next;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        ListNode curNode = dummyNode;
        int sum;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int l1Val = l1 == null ? 0 : l1.val;
            int l2Val = l2 == null ? 0 : l2.val;
            sum = l1Val + l2Val + carry;
            carry = sum / 10;
            curNode.next = new ListNode(sum % 10);
            curNode = curNode.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return dummyNode.next;
    }

    @Data
    @NoArgsConstructor
    public static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int x) {
            this.val = x;
        }

        public ListNode(int x, ListNode n) {
            this.val = x;
            this.next = n;
        }
    }

}
