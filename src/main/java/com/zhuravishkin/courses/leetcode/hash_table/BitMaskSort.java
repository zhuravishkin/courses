package com.zhuravishkin.courses.leetcode.hash_table;

/**
 * time - O(n)
 * mem - O(1)
 */
public class BitMaskSort {
    public static void main(String[] args) {
        char[] array = {'z', 'a', 'd', 'c', 'b', 'm', 'q', 'e'};
        sort(array);
    }

    public static void sort(char[] arr) {
        // Используем целочисленную переменную в качестве битовой маски.
        // Каждый бит (от 0 до 25) соответствует букве от 'a' до 'z'.
        int mask = 0;
        getMaskBinary(mask);

        // Проходим по массиву и устанавливаем бит, соответствующий каждой букве.
        for (char c : arr) {
            System.out.println(c);
            int bit = c - 'a'; // Вычисляем позицию бита для буквы c
            mask |= 1 << bit;  // Устанавливаем бит с помощью битового сдвига

            getMaskBinary(mask);
        }

        // Выводим буквы в отсортированном порядке (от 'a' к 'z')
        System.out.print("Отсортированный массив: ");
        for (int i = 0; i < 26; i++) {
            // Проверяем, установлен ли i-ый бит в маске
            if ((mask & (1 << i)) != 0) {
                System.out.print((char) (i + 'a') + " ");
            }
        }
    }

    private static void getMaskBinary(int mask) {
        // Выводим маску в двоичном виде.
        // Форматируем строку так, чтобы она содержала ровно 26 символов (с ведущими нулями)
        String binaryMask = String.format("%26s", Integer.toBinaryString(mask)).replace(' ', '0');
        System.out.println("Битовая маска (в двоичном виде): " + binaryMask);
    }
}
