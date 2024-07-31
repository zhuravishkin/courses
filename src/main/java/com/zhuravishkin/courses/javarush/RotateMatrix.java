package com.zhuravishkin.courses.javarush;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] ints = new int[4][4];
        int a = 0;

        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                ints[i][j] = ++a;
            }
        }

        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.print(ints[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        ints = rotateMatrix(ints);

        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.print(ints[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] rotateMatrix(int[][] ints) {
        int[][] arr = new int[ints.length][ints.length];

        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                arr[i][j] = ints[ints.length - j - 1][i];
            }
        }

        return arr;
    }
}
