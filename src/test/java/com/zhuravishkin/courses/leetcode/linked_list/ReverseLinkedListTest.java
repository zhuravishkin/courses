package com.zhuravishkin.courses.leetcode.linked_list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseLinkedListTest {

    @Test
    void reverseList1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode expected = new ListNode(5);
        expected.next = new ListNode(4);
        expected.next.next = new ListNode(3);
        expected.next.next.next = new ListNode(2);
        expected.next.next.next.next = new ListNode(1);

        assertEquals(expected, ReverseLinkedList.reverseList(head));
    }

    @Test
    void reverseList2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        ListNode expected = new ListNode(2);
        expected.next = new ListNode(1);

        assertEquals(expected, ReverseLinkedList.reverseList(head));
    }

    @Test
    void reverseList3() {
        ListNode head = new ListNode();

        ListNode expected = new ListNode();

        assertEquals(expected, ReverseLinkedList.reverseList(head));
    }
}