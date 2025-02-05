package com.zhuravishkin.courses.leetcode.linked_list;

/**
 * 206. Reverse Linked List
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
    }

    public static ListNode reverseList(ListNode head) {
        ListNode left = null;
        ListNode right = head;

        while (right != null) {
            ListNode temp = right;
            right = right.next;
            temp.next = left;
            left = temp;
        }

        return left;
    }
}
