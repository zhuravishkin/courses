package com.zhuravishkin.courses.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 349. Intersection of Two Arrays
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must be unique and you may return the result in any order
 */
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> dict = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            dict.add(nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            if (dict.contains(nums2[i])) {
                result.add(nums2[i]);
                dict.remove(nums2[i]);
            }
        }


        int[] inters = new int[result.size()];
        Object[] tempArray = result.toArray(); // Convert HashSet to Object array
        for (int i = 0; i < tempArray.length; i++) {
            inters[i] = (int) tempArray[i]; // Cast Object to Integer and copy to result array
        }

        return inters;
//        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
