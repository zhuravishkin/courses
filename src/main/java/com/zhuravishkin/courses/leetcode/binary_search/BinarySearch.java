package com.zhuravishkin.courses.leetcode.binary_search;

/**
 * 704. Binary Search
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums.
 * If target exists, then return its index. Otherwise, return -1.
 * You must write an algorithm with O(log n) runtime complexity.
 * Constraints:
 * 1 <= nums.length <= 10^4
 * -10^4 < nums[i], target < 10^4
 * All the integers in nums are unique.
 * nums is sorted in ascending order.
 */
public class BinarySearch {
    public static void main(String[] args) {
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }
}
