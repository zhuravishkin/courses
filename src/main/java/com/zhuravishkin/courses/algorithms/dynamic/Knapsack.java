package com.zhuravishkin.courses.algorithms.dynamic;

import java.util.ArrayList;

public class Knapsack {
    public static void main(String[] args) {
        // Вес предметов (в фунтах)
        int[] weights = {3, 2, 4, 1};
        // Стоимость предметов (в долларах)
        int[] values = {6, 8, 7, 4};
        // Вместимость рюкзака
        int capacity = 5;

        System.out.println("Максимальная стоимость: " + knapsack(weights, values, capacity));
    }

    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = values.length; // Количество предметов
        int[][] table = new int[n + 1][capacity + 1]; // Таблица для хранения промежуточных значений

        // Построение таблицы динамического программирования
        for (int i = 0; i <= n; i++) { // Перебираем каждый предмет
            for (int w = 0; w <= capacity; w++) { // Перебираем каждую возможную вместимость рюкзака
                if (i == 0 || w == 0) { // Базовый случай: если нет предметов (i == 0) или вместимость рюкзака равна 0 (w == 0), то максимальная ценность также равна 0. Это начальные условия таблицы.
                    table[i][w] = 0;
                } else if (weights[i - 1] <= w) { // Если текущий предмет помещается в рюкзак
                    table[i][w] = Math.max(
                            table[i - 1][w], // Сохраняем максимальную ценность без добавления текущего предмета
                            values[i - 1] + table[i - 1][w - weights[i - 1]] // Добавляем ценность текущего предмета и смотрим, что осталось
                    );
                } else {
                    // Если текущий предмет не помещается, сохраняем предыдущее значение
                    table[i][w] = table[i - 1][w];
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        traceResult(table, weights, n, capacity, result);
        System.out.println("Содержимое рюкзака: " + result);

        // Возвращаем максимальную стоимость, которую можно получить с данным весом рюкзака
        return table[n][capacity];
    }

    private static void traceResult(int[][] table, int[] weights, int n, int capacity, ArrayList<Integer> result) {
        // Базовый случай: если максимальная стоимость при текущем наборе предметов и вместимости равна 0,
        // значит, ни один предмет не может быть добавлен в рюкзак
        if (table[n][capacity] == 0) {
            return;
        }

        // Если оптимальное значение без учета текущего (n-го) предмета (то есть для первых n-1 предметов)
        // совпадает с оптимальным значением для n предметов, то n-й предмет не был выбран
        if (table[n - 1][capacity] == table[n][capacity]) {
            // Рекурсивно переходим к предыдущему предмету, вместимость при этом не меняется
            traceResult(table, weights, n - 1, capacity, result);
        } else {
            // Если же значения отличаются, это означает, что n-й предмет был включен в оптимальное решение
            // Рекурсивно переходим к предыдущему предмету, уменьшая вместимость на вес n-го предмета
            traceResult(table, weights, n - 1, capacity - weights[n - 1], result);
            // После возврата из рекурсии добавляем номер n-го предмета в начало списка результата
            // Добавление в начало (индекс 0) помогает сохранить правильный порядок предметов
            result.add(0, n);
        }
    }
}
