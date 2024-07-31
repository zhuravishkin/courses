package com.zhuravishkin.courses.demo;

public class LabelDemo {
    public static void main(String[] args) {
        label1:
        for (int i = 0; i < 3; i++) {
            System.out.println("i = " + i);
            label2:
            for (int j = 0; j < 3; j++) {
                System.out.println("    j = " + j);
                label3:
                for (int k = 0; k < 3; k++) {
                    System.out.println("        k = " + k);
//                    if (i == j && j == k) break label2;
                }
            }
        }
    }
}
