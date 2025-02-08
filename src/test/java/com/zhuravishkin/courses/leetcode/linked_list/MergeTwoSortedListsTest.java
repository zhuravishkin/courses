package com.zhuravishkin.courses.leetcode.linked_list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeTwoSortedListsTest {

    @Test
    void mergeTwoLists1() {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode expected = new ListNode(1);
        expected.next = new ListNode(1);
        expected.next.next = new ListNode(2);
        expected.next.next.next = new ListNode(3);
        expected.next.next.next.next = new ListNode(4);
        expected.next.next.next.next.next = new ListNode(4);

        assertEquals(expected, MergeTwoSortedLists.mergeTwoLists(list1, list2));
    }

    @Test
    void mergeTwoLists2() {
        ListNode list1 = new ListNode();

        ListNode list2 = new ListNode();

        ListNode expected = new ListNode(0);
        expected.next = new ListNode(0);

        assertEquals(expected, MergeTwoSortedLists.mergeTwoLists(list1, list2));
    }

    @Test
    void mergeTwoLists3() {
        ListNode list1 = new ListNode();

        ListNode list2 = new ListNode(0);

        ListNode expected = new ListNode(0);
        expected.next = new ListNode(0);

        assertEquals(expected, MergeTwoSortedLists.mergeTwoLists(list1, list2));
    }
}