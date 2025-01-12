package com.zhuravishkin.courses.algorithms.interview;

/*
lc136 - найти число без дублей
XOR для двух одинаковых битов дает 0.Если числа в таком массиве с 1 непарным элементом представить в
двоичном виде и выполнить между ними XOR (именно эти 2 действия и делает оператор ^+ ещё обратно в
десятичное число преобразует), то биты у повторяющихся чисел дадут 0. Значит, в итоге мы получаем только биты
уникального числа, которые ^ вернет нам в десятичном виде
*/

public class SingleNumber {
    public static void main(String[] args) {
//        int[] nums = {4, 1, 2, 1, 2};
//        int[] nums = {2, 2, 1};
//        int[] nums = {1};
        int[] nums = {4, 5, 2, 5, 2};
        System.out.println("res: " + singleNumber(nums));
    }

    public static int singleNumber(int[] nums) {
        var singleNumber = 0;

        for (var num : nums) {
            System.out.println("num: " + num);
            System.out.println(String.format("%8s", Integer.toBinaryString(num)).replace(" ", "0"));
            singleNumber ^= num;
            System.out.println("singleNumber: " + singleNumber);
            System.out.println(String.format("%8s", Integer.toBinaryString(singleNumber)).replace(" ", "0"));
        }
        return singleNumber;
    }
}
