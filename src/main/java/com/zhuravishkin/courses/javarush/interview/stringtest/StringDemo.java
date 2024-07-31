package com.zhuravishkin.courses.javarush.interview.stringtest;

public class StringDemo {
    public static void main(String[] args) {
        String a = "The Phone";
        String b = "The Phone";
        System.out.println(a == b);
        String c = new String(b);
        System.out.println(a == c);
        String d = c.intern();
        System.out.println(a == c);
        System.out.println(a == d);

        String e = "a";
        String f = "b";
        System.out.println(e.compareTo(f));
        System.out.println(f.compareTo(e));
    }
}
