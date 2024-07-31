package com.zhuravishkin.courses.algorithms;

/*
Развернуть массив без создания дополнительной структуры данных
*/

import java.util.Arrays;

public class ReverseArrayInPlace {
    public static void main(String[] args) {
        run(new String[]{"a", "b", "c", "d", "e"});
    }

    public static void run(String[] arr) {
        int f = 0;
        int l = arr.length - 1;

        while (f < l) {
            String tmp = arr[f];
            arr[f] = arr[l];
            arr[l] = tmp;
            f++;
            l--;
        }

        System.out.println(Arrays.toString(arr));
    }
}
