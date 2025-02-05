package com.zhuravishkin.courses.leetcode.linked_list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveNthNodeFromEndOfListTest {

    @Test
    void removeNthFromEnd1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode expected = new ListNode(1);
        expected.next = new ListNode(2);
        expected.next.next = new ListNode(3);
        expected.next.next.next = new ListNode(5);

        assertEquals(expected, RemoveNthNodeFromEndOfList.removeNthFromEnd(head, 2));
    }

    @Test
    void removeNthFromEnd2() {
        ListNode head = new ListNode(1);

        assertEquals(null, RemoveNthNodeFromEndOfList.removeNthFromEnd(head, 1));
    }

    @Test
    void removeNthFromEnd3() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        ListNode expected = new ListNode(1);

        assertEquals(expected, RemoveNthNodeFromEndOfList.removeNthFromEnd(head, 1));
    }
}