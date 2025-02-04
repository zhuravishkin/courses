package com.zhuravishkin.courses.leetcode.two_pointers;

import java.util.Arrays;

/**
 * 283. Move Zeroes
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 */
public class MoveZeroes {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(moveZeroes(new int[]{0, 1, 0, 3, 12})));
        System.out.println(Arrays.toString(moveZeroes(new int[]{1, 0, 2, 3, 0, 4})));
    }

    public static int[] moveZeroes(int[] nums) {
        int slow = 0;

        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }

        return nums;
    }

//    public static int[] moveZeroes(int[] nums) {
//        int slow = 0;
//
//        for (int fast = 0; fast < nums.length; fast++) {
//            if (nums[fast] != 0) {
//                int tmp = nums[slow];
//                nums[slow] = nums[fast];
//                nums[fast] = tmp;
//                slow++;
//            }
//        }
//
//        return nums;
//    }
}
