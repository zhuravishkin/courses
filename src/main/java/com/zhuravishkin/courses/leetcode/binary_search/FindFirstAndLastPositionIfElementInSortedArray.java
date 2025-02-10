package com.zhuravishkin.courses.leetcode.binary_search;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 * Constraints:
 * 0 <= nums.length <= 105
 * -10^9 <= nums[i] <= 10^9
 * nums is a non-decreasing array.
 * -10^9 <= target <= 10^9
 */
public class FindFirstAndLastPositionIfElementInSortedArray {
    public static void main(String[] args) {
    }

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[]{-1, -1};
        int leftF = -1;
        int rightF = nums.length - 1;
        while (rightF - leftF > 1) {
            int mid = leftF + (rightF - leftF) / 2;
            if (nums[mid] < target) {
                leftF = mid;
            } else {
                rightF = mid;
            }
        }
        int leftL = 0;
        int rightL = nums.length;
        while (rightL - leftL > 1) {
            int mid = leftL + (rightL - leftL) / 2;
            if (nums[mid] <= target) {
                leftL = mid;
            } else {
                rightL = mid;
            }
        }
        return (nums[rightF] == target && nums[leftL] == target) ? new int[]{rightF, leftL} : new int[]{-1, -1};
    }
}
