package com.zhuravishkin.courses.javarush.recursionexample;

import java.util.Arrays;

public class Recursion {
    public static int[] arr = {0, 0, 0, 0, 0};

    public static void main(String[] args) {
        recur(4);
    }

    public static void recur(int pos) {
        if (pos < 0) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        recur(pos - 1);
        arr[pos] = 1;
        recur(pos - 1);
        arr[pos] = 0;
    }
}
