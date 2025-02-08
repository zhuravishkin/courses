package com.zhuravishkin.courses.leetcode.linked_list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReorderListTest {

    @Test
    void reorderList1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        ListNode reverse = new ListNode(1);
        reverse.next = new ListNode(4);
        reverse.next.next = new ListNode(2);
        reverse.next.next.next = new ListNode(3);

        assertEquals(reverse, ReorderList.reorderList(head));
    }

    @Test
    void reorderList2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode reverse = new ListNode(1);
        reverse.next = new ListNode(5);
        reverse.next.next = new ListNode(2);
        reverse.next.next.next = new ListNode(4);
        reverse.next.next.next.next = new ListNode(3);

        assertEquals(reverse, ReorderList.reorderList(head));
    }
}