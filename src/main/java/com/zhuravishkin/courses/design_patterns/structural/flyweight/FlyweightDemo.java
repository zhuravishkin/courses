package com.zhuravishkin.courses.design_patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

// Client: Использует Flyweight для работы с символами
public class FlyweightDemo {
    public static void main(String[] args) {
        GlyphFactory factory = new GlyphFactory();

        // Текст, который нужно отобразить
        String text = "Flyweight pattern example";

        // Отображаем символы
        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            Glyph glyph = factory.getGlyph(symbol);
            glyph.draw(i * 10, 20); // x — позиция символа, y — фиксированная высота строки
        }

        System.out.println("Total unique glyphs created: " + factory.getTotalGlyphs());
    }
}

// Flyweight: Интерфейс для всех символов
interface Glyph {
    void draw(int x, int y); // x и y — внешнее состояние
}

// ConcreteFlyweight: Конкретная реализация символа
class Symbol implements Glyph {
    private final char symbol; // Внутреннее состояние (общая часть)

    public Symbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void draw(int x, int y) {
        System.out.println("Drawing '" + symbol + "' at (" + x + ", " + y + ")");
    }
}

// FlyweightFactory: Фабрика для управления объектами Flyweight
class GlyphFactory {
    private final Map<Character, Glyph> glyphs = new HashMap<>();

    public Glyph getGlyph(char symbol) {
        // Если символ уже существует, возвращаем его, иначе создаём новый
        glyphs.putIfAbsent(symbol, new Symbol(symbol));

        return glyphs.get(symbol);
    }

    public int getTotalGlyphs() {
        return glyphs.size();
    }
}
