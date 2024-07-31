package com.zhuravishkin.courses.javarush;

import java.util.Arrays;

public class FinallyTest {
    public static void finTest() {
        System.out.println("first");
        try {
            System.out.println("second");
            ArithmeticException arithmeticException = new ArithmeticException("exception");
            arithmeticException.initCause(new NullPointerException("reason"));
            throw arithmeticException;
        } catch (ArithmeticException e) {
            System.out.println("third");
            System.out.println(Arrays.toString(e.getStackTrace()));
            e.printStackTrace();
            System.out.println(e.getCause().getMessage());
        } finally {
            System.out.println("finally");
        }
        System.out.println("fourth");
    }

    public static void main(String[] args) {
        finTest();
    }
}
