package com.zhuravishkin.courses.leetcode.linked_list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MiddleOfTheLinkedListTest {

    @Test
    void middleNode1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode expected = new ListNode(3);
        expected.next = new ListNode(4);
        expected.next.next = new ListNode(5);

        assertEquals(expected, MiddleOfTheLinkedList.middleNode(head));
    }

    @Test
    void middleNode2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode expected = new ListNode(4);
        expected.next = new ListNode(5);
        expected.next.next = new ListNode(6);

        assertEquals(expected, MiddleOfTheLinkedList.middleNode(head));
    }
}