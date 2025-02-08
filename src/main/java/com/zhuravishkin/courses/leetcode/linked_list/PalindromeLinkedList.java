package com.zhuravishkin.courses.leetcode.linked_list;

/**
 * 234. Palindrome Linked List
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 * Constraints:
 * The number of nodes in the list is in the range [1, 10^5].
 * 0 <= Node.val <= 9
 * Follow up: Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = getMiddleNode(head);
        ListNode fastReverse = reverse(fast);

        while (fastReverse != null) {
            if (slow.val != fastReverse.val) {
                return false;
            }
            slow = slow.next;
            fastReverse = fastReverse.next;
        }

        return true;
    }

    public static ListNode getMiddleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
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
