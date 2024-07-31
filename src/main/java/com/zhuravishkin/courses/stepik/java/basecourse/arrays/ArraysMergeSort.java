package com.zhuravishkin.courses.stepik.java.basecourse.arrays;

import java.util.Arrays;

public class ArraysMergeSort {
    public static void main(String[] args) {
        int[] a = {0, 2, 2};
        int[] b = {1, 3, 3, 4};
        int[] c = new int[a.length + b.length];
        int[] max = a.length >= b.length ? a : b;
        int[] min = b.length <= a.length ? b : a;
        int indexMax = 0;
        int indexMin = 0;
        for (int i = 0; i < c.length; i++) {
            if ((indexMax < max.length) && (indexMin >= min.length || max[indexMax] < min[indexMin])) {
                c[i] = max[indexMax];
                indexMax++;
            } else {
                c[i] = min[indexMin];
                indexMin++;
            }
        }
        System.out.println(Arrays.toString(c));
    }
}
