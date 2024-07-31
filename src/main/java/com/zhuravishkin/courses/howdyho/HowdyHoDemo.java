package com.zhuravishkin.courses.howdyho;

public class HowdyHoDemo {
    public static void main(String[] args) {
        int a = 7;
        System.out.println(Integer.toBinaryString(a));
        int b = 1;
        System.out.println(Integer.toBinaryString(b));
        int c = a & b;
        System.out.println(Integer.toBinaryString(c));
        System.out.println(c == 0);

        int x = 5;
        System.out.println(Integer.toBinaryString(x));
        int y = 9;
        System.out.println(Integer.toBinaryString(y));
        x = x ^ y;
        System.out.println(Integer.toBinaryString(x));
        y = x ^ y;
        System.out.println(Integer.toBinaryString(y));
        x = x ^ y;
        System.out.println(Integer.toBinaryString(x));
        System.out.println(x);
        System.out.println(y);

        System.out.println(Math.round(Math.PI));

        int data = 57;
        int key = 5001;
        int encrypted = data ^ key;
        System.out.println(encrypted);
        int decrypted = encrypted ^ key;
        System.out.println(decrypted);
    }
}
