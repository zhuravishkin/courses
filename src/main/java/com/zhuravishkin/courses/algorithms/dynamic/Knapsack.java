package com.zhuravishkin.courses.algorithms.dynamic;

public class Knapsack {
    public static void main(String[] args) {
        // Вес предметов (в фунтах)
        int[] weights = {2, 3, 4, 5};
        // Стоимость предметов (в долларах)
        int[] values = {3, 4, 5, 8};
        // Вместимость рюкзака
        int capacity = 5;

        System.out.println("Максимальная стоимость: " + knapSack(weights, values, capacity));
    }

    public static int knapSack(int[] weights, int[] values, int capacity) {
        int n = values.length; // Количество предметов
        int[][] table = new int[n + 1][capacity + 1]; // Таблица для хранения промежуточных значений

        // Построение таблицы динамического программирования
        for (int i = 0; i <= n; i++) { // Перебираем каждый предмет
            for (int w = 0; w <= capacity; w++) { // Перебираем каждую возможную вместимость рюкзака
                if (i == 0 || w == 0) { // Базовый случай: если нет предметов (i == 0) или вместимость рюкзака равна 0 (w == 0), то максимальная ценность также равна 0. Это начальные условия таблицы.
                    table[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    // Если текущий предмет помещается в рюкзак
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

        // Возвращаем максимальную стоимость, которую можно получить с данным весом рюкзака
        return table[n][capacity];
    }
}
