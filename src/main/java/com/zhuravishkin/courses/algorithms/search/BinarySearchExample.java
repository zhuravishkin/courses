package com.zhuravishkin.courses.algorithms.search;

public class BinarySearchExample {
    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int key = 7;
//        int result = binarySearch(sortedArray, key);
        int result = binarySearchRecursive(sortedArray, key);

        if (result == -1) {
            System.out.println("Элемент не найден.");
        } else {
            System.out.println("Элемент найден на индексе: " + result);
        }
    }

    public static int binarySearch(int[] sortedArray, int key) {
        int low = 0;
        int high = sortedArray.length - 1;

        while (low <= high) {
//            int mid = (low + high) / 2;
            int mid = low + (high - low) / 2; // помогает избежать переполнения (overflow), которое может произойти при работе с большими значениями индексов

            if (sortedArray[mid] < key) {
                low = mid + 1;
            } else if (sortedArray[mid] > key) {
                high = mid - 1;
            } else {
                return mid; // элемент найден
            }
        }

        return -1; // элемент не найден
    }

    public static int binarySearchRecursive(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        return rec(array, target, low, high);
    }

    public static int rec(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (array[mid] < target) {
            return rec(array, target, mid + 1, right);
        } else if (array[mid] > target) {
            return rec(array, target, left, mid - 1);
        } else {
            return mid;
        }
    }
}
