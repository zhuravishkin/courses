package com.zhuravishkin.courses.stepik.java.basecourse.arrays;

import java.util.Locale;

/**
 * A program, that prints <code>Hello World!</code>
 *
 * @author Aleksey Zhuravishkin
 * @version 1.0
 */
public class Palindrome {
    /**
     * Program entry point
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        System.out.println("A" + ('\t' + '\u0003'));
//        if (args.length != 0) {
//            return;
//        }
        int[] ints = new int[0];
        String s = "Madam, I'm Adam!";
        String a = s.toLowerCase(Locale.ROOT).replaceAll("[^a-zA-Z0-9]", "");
        System.out.println(a);
        StringBuilder stringBuilder = new StringBuilder(a);
        System.out.println(a.equals(stringBuilder.reverse().toString()));
    }
}
