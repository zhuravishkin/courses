package com.zhuravishkin.courses.javarush;

public class HighBitSearchAlgorithms {
    public static void main(String[] args) {
        int i = 1 << 30;
        System.out.println(i);
        System.out.println(Integer.toString(i, 2));

        int j = i;
        System.out.println(i >>= 1);
        System.out.println(Integer.toString(i, 2));

        System.out.println(j |= j >> 1);
        System.out.println(Integer.toString(j, 2));

        HighBitSearchAlgorithms algorithms = new HighBitSearchAlgorithms();
        System.out.println(algorithms.binaryRepresentationMethod(6));
    }

    private String binaryRepresentationMethod(int x) {
        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a);
        if (b > 0) {
            return binaryRepresentationMethod(b) + result;
        }
        return result;
    }
}
