package com.zhuravishkin.courses.javarush;

import java.util.Arrays;

public class RecursionExample {
    public static int[] arr = {0, 0, 0}; //массив, в котором работает рекурсия

    public static void recur(int pos) {  // pos - позиция в массиве, с которой работаем в настоящий момент

        //базовое условие рекурсии (дошли до самого низа рекурсивной ветки)
        if (pos < 0) {
            System.out.println(Arrays.toString(arr)); // выводим очередной получившийся массив
            return;
        }

        //основное тело рекурсии
        recur(pos - 1); // оставляем 0, идем по рекурсии вниз дальше
        arr[pos] = 1; // заменяем на 1
        recur(pos - 1); // идем по рекурсии вниз дальше (с вариантом с единичкой)
        arr[pos] = 0; //возвращаем массив в прежнее состояние, чтобы ветки рекурсии не мешали друг другу
    }

    public static void main(String[] args) {
        recur(2);
    }
}
