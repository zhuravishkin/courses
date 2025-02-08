package com.zhuravishkin.courses.leetcode.linked_list;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromeLinkedListTest {

    @Test
    void isPalindrome1() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        assertTrue(PalindromeLinkedList.isPalindrome(head));
    }

    @Test
    void isPalindrome2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        assertFalse(PalindromeLinkedList.isPalindrome(head));
    }
}