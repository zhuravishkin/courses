package com.zhuravishkin.courses.javarush;

public class MergeTiles {
    public static void main(String[] args) {
        int[] ints = {2, 2, 0, 2};

        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < ints.length - 1; i++) {
            if (ints[i] != 0) {
                int a = i;
                if (ints[i] == ints[++a]) {
                    ints[i] *= 2;
                    ints[a] = 0;
                }
            }
        }

        pushZerosToEnd(ints, ints.length);

        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }

    public static void pushZerosToEnd(int arr[], int n)
    {
        int count = 0;
        for (int i = 0; i < n; i++)
            if (arr[i] != 0)
                arr[count++] = arr[i];

        while (count < n) {
            int a = count++;
            if (arr[a] != 0) {
                arr[a] = 0;
            }
        }
    }
}
