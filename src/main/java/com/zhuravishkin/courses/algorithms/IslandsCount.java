package com.zhuravishkin.courses.algorithms;

import java.util.Arrays;

public class IslandsCount {
    public static void main(String[] args) {
//        String[][] islands = new String[][]{
//                {"1", "1", "0", "0", "0"},
//                {"1", "1", "0", "0", "0"},
//                {"0", "0", "1", "0", "0"},
//                {"0", "0", "0", "1", "1"}
//        };
//        String[][] islands = new String[][]{
//                {"1", "1", "0", "0", "0"},
//                {"0", "1", "0", "0", "0"},
//                {"1", "1", "0", "0", "0"},
//                {"0", "0", "0", "1", "1"}
//        };
        String[][] islands = new String[][]{
                {"1", "0", "1", "0", "0"},
                {"1", "1", "1", "0", "0"},
                {"0", "0", "0", "0", "0"},
                {"0", "0", "0", "1", "1"}
        };
        System.out.println(getIslandsCount(islands));
    }

    public static int getIslandsCount(String[][] islands) {
        int columnLength = islands.length;
        int rowLength = islands[0].length;
        int count = 0;

        for (int i = 0; i < columnLength; i++) {
            for (int j = 0; j < rowLength; j++) {
                if (islands[i][j].equals("1")) {
                    count++;
                    markIsIslands(islands, i, j);
                    System.out.println(Arrays.deepToString(islands));
                }
            }
        }

        return count;
    }

    public static void markIsIslands(String[][] islands, int i, int j) {
        islands[i][j] = "m";
        for (int k = j + 1; k < islands[i].length; k++) {
            if (islands[i][k].equals("1")) {
                markIsIslands(islands, i, k);
            } else {
                break;
            }
        }
        for (int k = j - 1; k >= 0; k--) {
            if (islands[i][k].equals("1")) {
                markIsIslands(islands, i, k);
            } else {
                break;
            }
        }
        for (int k = i + 1; k < islands.length; k++) {
            if (islands[k][j].equals("1")) {
                markIsIslands(islands, k, j);
            } else {
                break;
            }
        }
        for (int k = i - 1; k >= 0; k--) {
            if (islands[k][j].equals("1")) {
                markIsIslands(islands, k, j);
            } else {
                break;
            }
        }
    }
}
