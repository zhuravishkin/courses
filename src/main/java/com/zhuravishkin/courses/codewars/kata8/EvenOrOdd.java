package com.zhuravishkin.courses.codewars.kata8;

public class EvenOrOdd {
    public static void main(String[] args) {
        System.out.println(even_or_odd(5));
    }

    public static String even_or_odd(int number) {
        if (number % 2 == 0) {
            return "Even";
        } else {
            return "Odd";
        }
    }
}
