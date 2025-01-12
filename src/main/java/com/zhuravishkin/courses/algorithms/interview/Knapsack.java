package com.zhuravishkin.courses.algorithms.interview;

public class Knapsack {
    public static void main(String[] args) {
        int[] val = {3, 4, 5, 8};
        int[] wt = {2, 3, 4, 5};
        int kwt = 5;
        int n = val.length;
        System.out.println("Максимальная стоимость, которую можно получить: " + knapSack(kwt, wt, val, n));
    }

    public static int knapSack(int kwt, int[] wt, int[] val, int n) {
        int[][] K = new int[n + 1][kwt + 1];

        // Заполняем таблицу K[][] снизу вверх
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= kwt; w++) {
                if (i == 0 || w == 0) {
                    K[i][w] = 0;
                } else if (wt[i - 1] <= w) {
                    K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                } else {
                    K[i][w] = K[i - 1][w];
                }
            }
        }

        // Возвращаем максимальную стоимость, которую можно получить с данным весом рюкзака
        return K[n][kwt];
    }
}
