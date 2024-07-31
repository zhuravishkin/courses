package com.zhuravishkin.courses.algorithms.sorting;

public class BinarySearchExample {
    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int key = 7;
        int result = binarySearch(sortedArray, key);

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
            int mid = (low + high) / 2;

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
}
