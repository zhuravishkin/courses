package com.zhuravishkin.courses.leetcode.linked_list;

/**
 * 21. Merge Two Sorted Lists
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 * Constraints:
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode stub = new ListNode();
        ListNode curr = stub;
        while (list1 != null || list2 != null) {
            if (getVal(list1) < getVal(list2)) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        return stub.next;
    }

    private static int getVal(ListNode node) {
        if (node == null)
            return Integer.MAX_VALUE;
        return node.val;
    }

//    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        ListNode dummy = new ListNode(0);
//        ListNode current = dummy;
//
//        while (list1 != null && list2 != null) {
//            if (list1.val <= list2.val) {
//                current.next = list1;
//                list1 = list1.next;
//            } else {
//                current.next = list2;
//                list2 = list2.next;
//            }
//            current = current.next;
//        }
//
//        current.next = (list1 != null) ? list1 : list2;
//
//        return dummy.next;
//    }
}
