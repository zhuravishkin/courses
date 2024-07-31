package com.zhuravishkin.courses.javarush;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveFullLinesMatrix {
    public static void main(String[] args) {
        int width = 6;
        int height = 5;
        int[][] matrix = {
                {0, 1, 1, 0, 1, 0},
                {1, 0, 0, 0, 1, 0},
                {1, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1}
        };

        List<int[]> notFullLinesArrays = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < height; i++) {
            int sum = 0;
            for (int j = 0; j < width; j++) {
                sum += matrix[i][j];
            }
            if (sum != width) {
                notFullLinesArrays.add(matrix[i]);
            }
        }
        for (int[] arr : notFullLinesArrays) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println();
        int emptyLines = 0;
        if (notFullLinesArrays.size() <height) {
            emptyLines = height - notFullLinesArrays.size();
            for (int i = 0; i < emptyLines; i++) {
                notFullLinesArrays.add(0, new int[width]);
            }
        }
        for (int[] arr : notFullLinesArrays) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
