package com.zhuravishkin.courses.javarush;

public class ZerosToTheBack {
    public static void main(String[] args) {
        int[][] arr = {{1, 9, 0, 2, 8, 4}, {0, 0, 3, 1, 2, 7}, {0, 6, 0, 4, 0, 9}};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < 3; i++) {
            pushZerosToEnd(arr[i], arr[i].length);
        }
        System.out.println();

        System.out.println("Array after pushing zeros to the back: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void pushZerosToEnd(int arr[], int n)
    {
        int count = 0;
        for (int i = 0; i < n; i++)
            if (arr[i] != 0)
                arr[count++] = arr[i];

        while (count < n)
            arr[count++] = 0;
    }
}
