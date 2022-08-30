package com.fish.leetcode;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yufei.liu
 * @version v1.0
 * @description 合并两个SortedList
 * @date 2022-08-30 17:29
 */
public class P21_MergeTwoSortedList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(7)));
        System.err.println(mergeTwoLists(l1, l2));
    }

    /**
     * 合并两个SortedList
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val > list2.val) {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        } else {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
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
