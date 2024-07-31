package com.zhuravishkin.courses.algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(array);
        System.out.println("Отсортированный массив:");
        System.out.println(Arrays.toString(array));
    }

//    public static void bubbleSort(int[] array) {
//        int n = array.length;
//        boolean swapped;
//        for (int i = 0; i < n - 1; i++) {
//            swapped = false;
//            for (int j = 0; j < n - i - 1; j++) {
//                if (array[j] > array[j + 1]) {
//                    // обмен элементов array[j] и array[j+1]
//                    int temp = array[j];
//                    array[j] = array[j + 1];
//                    array[j + 1] = temp;
//                    swapped = true;
//                }
//            }
//            // если внутренний цикл не произвел ни одного обмена, массив уже отсортирован
//            if (!swapped) break;
//        }
//    }

    public static void bubbleSort(int[] array) {
        boolean swapped = false;
        while (!swapped) {
            swapped = true;
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = false;
                }
                System.out.println(Arrays.toString(array));
            }
        }
    }
}
