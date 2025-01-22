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

        int pivot = array[left + (right - left) / 2];
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
        }

        if (left < rightMarker) {
            quickSort(array, left, rightMarker);
        }
        if (leftMarker < right) {
            quickSort(array, leftMarker, right);
        }
    }

//    public static void quickSort(int[] array, int low, int high) {
//        if (low < high) {
//            // Разделяем массив и получаем индекс опорного элемента (pivot)
//            int pivotIndex = partition(array, low, high);
//
//            // Рекурсивно сортируем левую часть
//            quickSort(array, low, pivotIndex - 1);
//
//            // Рекурсивно сортируем правую часть
//            quickSort(array, pivotIndex + 1, high);
//        }
//    }
//
//    private static int partition(int[] array, int low, int high) {
//        int pivot = array[high]; // Опорный элемент выбирается как последний
//        int i = low - 1; // Индекс для элементов меньше опорного
//
//        for (int j = low; j < high; j++) {
//            if (array[j] <= pivot) {
//                i++;
//                // Меняем местами элементы
//                swap(array, i, j);
//            }
//        }
//
//        // Перемещаем опорный элемент на его правильное место
//        swap(array, i + 1, high);
//
//        return i + 1; // Возвращаем индекс опорного элемента
//    }
//
//    private static void swap(int[] array, int i, int j) {
//        int temp = array[i];
//        array[i] = array[j];
//        array[j] = temp;
//    }
}
