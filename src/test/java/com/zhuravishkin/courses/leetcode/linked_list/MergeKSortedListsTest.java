package com.zhuravishkin.courses.leetcode.linked_list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeKSortedListsTest {

    @Test
    void mergeKLists1() {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        ListNode[] lists = {list1, list2, list3};

        ListNode expected = new ListNode(1);
        expected.next = new ListNode(1);
        expected.next.next = new ListNode(2);
        expected.next.next.next = new ListNode(3);
        expected.next.next.next.next = new ListNode(4);
        expected.next.next.next.next.next = new ListNode(4);
        expected.next.next.next.next.next.next = new ListNode(5);
        expected.next.next.next.next.next.next.next = new ListNode(6);

        assertEquals(expected, MergeKSortedLists.mergeKLists(lists));
    }

    @Test
    void mergeKLists2() {
        ListNode[] lists = {};

        ListNode expected = new ListNode();

        assertEquals(expected, MergeKSortedLists.mergeKLists(lists));
    }

    @Test
    void mergeKLists3() {
        ListNode list = new ListNode();

        ListNode[] lists = {list};

        ListNode expected = new ListNode();

        assertEquals(expected, MergeKSortedLists.mergeKLists(lists));
    }
}