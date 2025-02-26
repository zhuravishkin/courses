package com.zhuravishkin.courses.leetcode.two_pointers;

public class FibonacciRandomGenerator {
    private static long previous = 0;
    private static long current = 1;
    private static final long MODULUS = 1_000_000_007L;

    // сгенерированное число (в диапазоне от 0 до MODULUS - 1)
    public static int generateRandomNumber() {
        long next = (previous + current) % MODULUS;
        previous = current;
        current = next;
        return (int) next;
    }

    public static int generateRandomNumberInRange(int bound) {
        // Применяем оператор остатка от деления для получения числа в диапазоне от 0 до bound - 1
        return generateRandomNumber() % bound;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
//            System.out.println(generateRandomNumberInRange(11));
            System.out.println(generateRandomNumberInRange(10) + 1);
        }
    }
}
