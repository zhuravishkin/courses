package com.zhuravishkin.courses.design.solid.e_dip;

public class DIPDemo {
    public static void main(String[] args) {
        Reader keyboardReader = new KeyboardReader();
        Writer printerWriter = new PrinterWriter();
        Copier copier = new Copier();

        copier.copy(keyboardReader, printerWriter);
    }
}

// Абстракция для чтения
interface Reader {
    int read();
}

// Абстракция для записи
interface Writer {
    void write(int c);
}

class KeyboardReader implements Reader {
    @Override
    public int read() {
        // Реальная логика чтения с клавиатуры
        // Здесь для примера возвращаем фиктивное значение
        return 65; // символ 'A'
    }
}

class PrinterWriter implements Writer {
    @Override
    public void write(int c) {
        // Реальная логика записи на принтер
        System.out.println("Printing: " + (char) c);
    }
}

class Copier {
    // Метод принимает объекты-абстракции, а не конкретные реализации
    public void copy(Reader reader, Writer writer) {
        int c;
        // Допустим, -1 означает конец ввода (EOF)
        while ((c = reader.read()) != -1) {
            writer.write(c);
        }
    }
}
