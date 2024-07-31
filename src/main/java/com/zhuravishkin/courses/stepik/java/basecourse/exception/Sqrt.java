package com.zhuravishkin.courses.stepik.java.basecourse.exception;

public class Sqrt {
    public static void main(String[] args) {
    }

    public static double sqrt(double x) {
        if (x < 0) {
            throw new IllegalArgumentException(String.format("Expected non-negative number, got %s", x));
        }
        return Math.sqrt(x);
    }
}
