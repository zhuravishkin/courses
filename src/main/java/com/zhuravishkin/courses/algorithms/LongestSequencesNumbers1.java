package com.zhuravishkin.courses.algorithms;

/*
Найти самую длинную подстроку из единиц
[1,1,0,0,1,1,0]
[1,1,0,0,1,1,1]
[1,1,1,1,1]
[0,0,0,0,0]
[]
*/

public class LongestSequencesNumbers1 {
    public static void main(String[] args) {
    }

    public static int run(int[] arr) {
        int count = 0;
        int max = 0;
        for (int n : arr) {
            if (n > 0) {
                count++;
                max = count;
            } else {
                count = 0;
            }
        }

        return max;
    }
}
