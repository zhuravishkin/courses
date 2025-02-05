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

        ListNode reverse = new ListNode(5);
        reverse.next = new ListNode(4);
        reverse.next.next = new ListNode(3);
        reverse.next.next.next = new ListNode(2);
        reverse.next.next.next.next = new ListNode(1);

        assertEquals(reverse, ReverseLinkedList.reverseList(head));
    }

    @Test
    void reverseList2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        ListNode reverse = new ListNode(2);
        reverse.next = new ListNode(1);

        assertEquals(reverse, ReverseLinkedList.reverseList(head));
    }

    @Test
    void reverseList3() {
        ListNode head = new ListNode();

        ListNode reverse = new ListNode();

        assertEquals(reverse, ReverseLinkedList.reverseList(head));
    }
}