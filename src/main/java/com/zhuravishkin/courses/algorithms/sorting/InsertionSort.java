package com.zhuravishkin.courses.algorithms.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        insertionSort(array);
        System.out.println("Отсортированный массив:");
        System.out.println(Arrays.toString(array));
    }

//    public static void insertionSort(int[] array) {
//        int n = array.length;
//        for (int i = 1; i < n; i++) {
//            int key = array[i];
//            int j = i - 1;
//
//            // Перемещаем элементы массива, которые больше ключа,
//            // на одну позицию вперед от их текущей позиции
//            while (j >= 0 && array[j] > key) {
//                array[j + 1] = array[j];
//                j = j - 1;
//            }
//            array[j + 1] = key;
//        }
//    }

    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > current) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = current;
            System.out.println(Arrays.toString(array));
        }
    }
}
