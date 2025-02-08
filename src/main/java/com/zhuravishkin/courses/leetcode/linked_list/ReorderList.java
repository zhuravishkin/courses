package com.zhuravishkin.courses.leetcode.linked_list;

/**
 * 143. Reorder List
 * You are given the head of a singly linked-list. The list can be represented as:
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 * Constraints:
 * The number of nodes in the list is in the range [1, 5 * 104].
 * 1 <= Node.val <= 1000
 */
public class ReorderList {
    public static void main(String[] args) {
    }

    public static ListNode reorderList(ListNode head) {
        ListNode left = head;
        ListNode preMiddleNode = getPreMiddleNode(head);
        System.out.println("pre-mid: " + preMiddleNode);
        ListNode right = reverse(preMiddleNode.next);
        System.out.println("left: " + left);
        System.out.println("pre-mid after reverse: " + preMiddleNode);
        preMiddleNode.next = null;
        System.out.println("pre-mid after next = null: " + preMiddleNode);

        System.out.println("left: " + left);
        System.out.println("right: " + right);

//        1 -> 2 -> 3 -> 4 -> 5
//        1 -> 5 -> 2 -> 4 -> 3
//        1 -> 2 -> 3
//        5 -> 4 -> 3

        ListNode newHead = left;
        while (right != null) {
            ListNode leftNext = left.next;
            left.next = right;
            left = right;
            right = leftNext;
        }

        System.out.println(newHead);

        return newHead;
    }

    public static ListNode getPreMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static ListNode reverse(ListNode head) {
        ListNode slow = null;
        ListNode fast = head;

        while (fast != null) {
            ListNode tmp = fast;
            fast = fast.next;
            tmp.next = slow;
            slow = tmp;
        }

        return slow;
    }
}
