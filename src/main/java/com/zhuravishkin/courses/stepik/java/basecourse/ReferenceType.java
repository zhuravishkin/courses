package com.zhuravishkin.courses.stepik.java.basecourse;

import java.util.Arrays;

public class ReferenceType {
    public static void main(String[] args) {
        int[] s = {1, 2, 3};
        int[] t = s;

        System.out.println("s = " + Arrays.toString(s));
        System.out.println("t = " + Arrays.toString(t));

        t[1] = 100;

        System.out.println("s = " + Arrays.toString(s));
        System.out.println("t = " + Arrays.toString(t));
    }
}
