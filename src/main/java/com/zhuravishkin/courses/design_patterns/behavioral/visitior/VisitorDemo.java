package com.zhuravishkin.courses.design_patterns.behavioral.visitior;

import java.util.ArrayList;
import java.util.List;

// Client
public class VisitorDemo {
    public static void main(String[] args) {
        // Создаём элементы документа
        List<DocumentElement> document = new ArrayList<>();
        document.add(new Text("Hello world!"));
        document.add(new Image("/path/to/image.jpg"));
        document.add(new Table(3, 4));
        document.add(new Text("Design patterns are awesome."));

        // Отрисовываем документ
        System.out.println("Rendering document:");
        RenderVisitor renderVisitor = new RenderVisitor();
        for (DocumentElement element : document) {
            element.accept(renderVisitor);
        }

        // Подсчитываем количество слов
        System.out.println("\nCounting words in document:");
        WordCountVisitor wordCountVisitor = new WordCountVisitor();
        for (DocumentElement element : document) {
            element.accept(wordCountVisitor);
        }
        System.out.println("Total word count: " + wordCountVisitor.getWordCount());
    }
}

// Visitor: Интерфейс посетителя
interface DocumentVisitor {
    void visit(Text text);

    void visit(Image image);

    void visit(Table table);
}

// Element: Интерфейс элемента документа
interface DocumentElement {
    void accept(DocumentVisitor visitor);
}

// ConcreteElement: Текстовый блок
class Text implements DocumentElement {
    private final String content;

    public Text(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public void accept(DocumentVisitor visitor) {
        visitor.visit(this);
    }
}

// ConcreteElement: Изображение
class Image implements DocumentElement {
    private final String imagePath;

    public Image(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    @Override
    public void accept(DocumentVisitor visitor) {
        visitor.visit(this);
    }
}

// ConcreteElement: Таблица
class Table implements DocumentElement {
    private final int rows;
    private final int columns;

    public Table(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    @Override
    public void accept(DocumentVisitor visitor) {
        visitor.visit(this);
    }
}

// ConcreteVisitor: Отрисовка элементов документа
class RenderVisitor implements DocumentVisitor {
    @Override
    public void visit(Text text) {
        System.out.println("Rendering text: " + text.getContent());
    }

    @Override
    public void visit(Image image) {
        System.out.println("Rendering image: " + image.getImagePath());
    }

    @Override
    public void visit(Table table) {
        System.out.println("Rendering table with " + table.getRows() + " rows and " + table.getColumns() + " columns");
    }
}

// ConcreteVisitor: Подсчёт слов
class WordCountVisitor implements DocumentVisitor {
    private int wordCount = 0;

    public int getWordCount() {
        return wordCount;
    }

    @Override
    public void visit(Text text) {
        wordCount += text.getContent().split("\\s+").length;
    }

    @Override
    public void visit(Image image) {
        // Изображения не содержат слов
    }

    @Override
    public void visit(Table table) {
        // Таблицы не содержат слов
    }
}
