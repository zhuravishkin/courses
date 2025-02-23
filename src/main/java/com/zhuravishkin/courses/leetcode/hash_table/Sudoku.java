package com.zhuravishkin.courses.leetcode.hash_table;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Судоку
 * Проверь, является ли заданная расстановка чисел в судоку размером 9 x 9 допустимой.
 * Массив board содержит только числа от 1 до 9 включительно.
 * Условия:
 * - Каждая строка содержит только уникальные числа.
 * - Каждый столбец содержит только уникальные числа.
 * - Каждый из девяти подполей 3 x 3 содержит только уникальные числа.
 * Примечание:
 * Решать судоку не требуется. Необходимо просто проверить отсутствие дубликатов в строках, столбцах и подполях.
 * Если дубликаты отсутствуют, вернуть true. В противном случае вернуть false.
 * Constraints:
 * размер массива board всегда 9 x 9
 * массив board содержит только цифры от 1 до 9 или '.'
 */
public class Sudoku {
    public static boolean isValidSudoku(List<List<Character>> board) {
        Set<String> raws = new HashSet<>();
        Set<String> columns = new HashSet<>();
        Set<String> blocks = new HashSet<>();
        for (int i = 0; i < board.size(); i++) {
            for (int j = 0; j < board.get(i).size(); j++) {
                char c = board.get(i).get(j);
                if (c != '.') {
                    int block = (i / 3) * 3 + j / 3;
                    if (!raws.add("" + i + c) || !columns.add("" + j + c) || !blocks.add("" + block + c)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
