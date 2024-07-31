package com.zhuravishkin.courses.ya_context;

import java.io.*;
import java.util.Arrays;

public class DynamicProgramming2D {
    public static void main(String[] args) throws IOException, InterruptedException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new StringReader("" +
                "3 3\n" +
                "1 1 1\n" +
                "3 100 100\n" +
                "1 1 1"));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] bounds = reader.readLine().split(" ");
        int n = Integer.parseInt(bounds[0]);
        int m = Integer.parseInt(bounds[1]);

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] parts = reader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(parts[j]);
            }
        }
        System.out.println(Arrays.deepToString(grid));

        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
        System.out.println(Arrays.deepToString(dp));

        // Заполнение первого столбца
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        System.out.println(Arrays.deepToString(dp));

        // Заполнение первой строки
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // Заполнение остальных клеток
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        System.out.println(Arrays.deepToString(dp));

        // Минимальный вес еды для достижения правого нижнего угла
        System.out.println(dp[n - 1][m - 1]);

        reader.close();
        writer.close();
    }
}
