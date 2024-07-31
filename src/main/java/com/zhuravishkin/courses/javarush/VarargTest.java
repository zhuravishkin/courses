package com.zhuravishkin.courses.javarush;

public class VarargTest {
    public static void vararg(int... array) {
        System.out.print("массив ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void vararg(boolean... array) {
        System.out.print("массив boolean ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }

    public static void vararg(int i, int... array) {
        System.out.print("int " + i + "массив ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void vararg(int a, int b, int c) {
        System.out.printf("int: %d %d %d", a, b, c);
        System.out.println();
    }

    public static void main(String[] args) {
        vararg(1, 2, 3);
        vararg(false);
//        vararg(1, 1);
    }
}
