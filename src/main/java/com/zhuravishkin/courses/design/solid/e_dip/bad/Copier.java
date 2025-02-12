package com.zhuravishkin.courses.design.solid.e_dip.bad;

public class Copier {
    public void copy() {
        int c;
        // Прямой вызов конкретной функции чтения с клавиатуры
        while ((c = readKeyboard()) != -1) { // -1 обозначает конец ввода
            // Прямой вызов конкретной функции записи на принтер
            writePrinter(c);
        }
    }

    private int readKeyboard() {
        // Реализация чтения с клавиатуры
        // (для примера возвращаем фиктивное значение)
        return 65; // например, символ 'A'
    }

    private void writePrinter(int c) {
        // Реализация записи на принтер
        System.out.println("Printing: " + (char) c);
    }
}
