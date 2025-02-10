package com.zhuravishkin.courses.leetcode.binary_search;

/**
 * 69. Sqrt(x)
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
 * You must not use any built-in exponent function or operator. For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 * Constraints:
 * 0 <= x <= 2^31 - 1
 */
public class SqrtX {
    public static void main(String[] args) {
    }

    public static int mySqrt(int x) {
        long left = 0;
        long right = x + 1L;
        while (right - left > 1) {
            long mid = left + (right - left) / 2;
            if (mid * mid <= x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return (int) left;
    }
}
