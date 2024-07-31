package com.zhuravishkin.courses.stepik.java.basecourse.cycles;

import java.math.BigInteger;

public class Factorial {
    public static void main(String[] args) {
        int a = 4;
        BigInteger bigInteger = BigInteger.ONE;
        for (int i = 1; i <= a; i++) {
            bigInteger = bigInteger.multiply(BigInteger.valueOf(i));
        }
        System.out.println(bigInteger);
    }
}
