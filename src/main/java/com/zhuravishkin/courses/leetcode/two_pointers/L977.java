package com.zhuravishkin.courses.leetcode.two_pointers;

import java.util.Arrays;

/**
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order
 */
public class L977 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }

    public static int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1, i = nums.length - 1;
        int[] res = new int[nums.length];
        while (left <= right) {
            int a = nums[left] * nums[left];
            int b = nums[right] * nums[right];
            if (a > b) {
                res[i] = a;
                left++;
            } else {
                res[i] = b;
                right--;
            }
            i--;
        }
        return res;
    }
}
