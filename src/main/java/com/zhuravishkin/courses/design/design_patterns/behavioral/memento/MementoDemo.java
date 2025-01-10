package com.zhuravishkin.courses.design.design_patterns.behavioral.memento;

import java.util.Stack;

// Client
public class MementoDemo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        History history = new History();

        // Устанавливаем текст и сохраняем состояние
        editor.setText("Hello, world!");
        history.save(editor.save());

        System.out.println("Text: " + editor.getText()); // Hello, world!

        // Изменяем текст
        editor.setText("Hello, design patterns!");
        history.save(editor.save());

        System.out.println("Text: " + editor.getText()); // Hello, design patterns!

        // Изменяем текст без сохранения
        editor.setText("Hello, Memento!");
        System.out.println("Text: " + editor.getText()); // Hello, Memento!

        // Отмена изменений
        editor.restore(history.undo());
        System.out.println("Undo 1: " + editor.getText()); // Hello, design patterns!

        editor.restore(history.undo());
        System.out.println("Undo 2: " + editor.getText()); // Hello, world!
    }
}

// Originator: Редактор текста
class TextEditor {
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    // Создаёт хранителя для текущего состояния
    public TextMemento save() {
        return new TextMemento(text);
    }

    // Восстанавливает состояние из хранителя
    public void restore(TextMemento memento) {
        this.text = memento.getText();
    }
}

// Memento: Объект-хранитель состояния
class TextMemento {
    private final String text;

    public TextMemento(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

// Caretaker: Управляет сохранёнными состояниями
class History {
    private final Stack<TextMemento> history = new Stack<>();

    public void save(TextMemento memento) {
        history.push(memento);
    }

    public TextMemento undo() {
        if (!history.isEmpty()) {
            return history.pop();
        }
        return null;
    }
}
