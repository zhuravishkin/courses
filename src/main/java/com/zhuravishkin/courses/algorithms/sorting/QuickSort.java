package com.zhuravishkin.courses.algorithms.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {10, 34, 91, 12, 90, 22, 11};
//        int[] array = {10, 34, 9, 12, 13, 14, 15};
        quickSort(array, 0, array.length - 1);
        System.out.println("Отсортированный массив:");
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array, int left, int right) {
        if (array.length == 0 || left >= right) {
            return;
        }

        int pivot = array[(left + right) / 2];
        int leftMarker = left;
        int rightMarker = right;

        while (leftMarker <= rightMarker) {
            while (array[leftMarker] < pivot) {
                leftMarker++;
            }
            while (array[rightMarker] > pivot) {
                rightMarker--;
            }

            if (leftMarker <= rightMarker) {
                int temp = array[leftMarker];
                array[leftMarker] = array[rightMarker];
                array[rightMarker] = temp;
                leftMarker++;
                rightMarker--;
            }
            System.out.println(Arrays.toString(array));

            if (left < rightMarker) {
                quickSort(array, left, rightMarker);
            }
            if (right > leftMarker) {
                quickSort(array, leftMarker, right);
            }
        }
    }

//    public static void quickSort(int[] array, int low, int high) {
//        if (low < high) {
//            int pi = partition(array, low, high);
//
//            // Рекурсивно сортируем элементы до и после разделителя
//            quickSort(array, low, pi - 1);
//            quickSort(array, pi + 1, high);
//        }
//    }
//
//    public static int partition(int[] array, int low, int high) {
//        int pivot = array[high]; // выбираем последний элемент как опорный
//        int i = (low - 1); // индекс меньшего элемента
//
//        for (int j = low; j < high; j++) {
//            // Если текущий элемент меньше или равен опорному
//            if (array[j] <= pivot) {
//                i++;
//
//                // Меняем местами array[i] и array[j]
//                int temp = array[i];
//                array[i] = array[j];
//                array[j] = temp;
//            }
//        }
//
//        // Меняем местами array[i + 1] и array[high] (или опорный элемент)
//        int temp = array[i + 1];
//        array[i + 1] = array[high];
//        array[high] = temp;
//
//        return i + 1;
//    }
}
