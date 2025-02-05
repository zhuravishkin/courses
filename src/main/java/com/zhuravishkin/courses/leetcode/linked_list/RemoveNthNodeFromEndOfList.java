package com.zhuravishkin.courses.leetcode.linked_list;

/**
 * 19. Remove Nth Node From End of List
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
    }

//    public static ListNode removeNthFromEnd(ListNode head, int n) {
//        ListNode dummy = new ListNode(0, head);
//
//        int length = 0;
//        ListNode curr = dummy;
//        while (curr != null) {
//            length++;
//            curr = curr.next;
//        }
//
//        curr = dummy;
//        for (int i = 0; i < length - n - 1; i++) {
//            curr = curr.next;
//        }
//        curr.next = curr.next.next;
//
//        return dummy.next;
//    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);

        ListNode fast = dummy;
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        ListNode slow = dummy;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return dummy.next;
    }
}
