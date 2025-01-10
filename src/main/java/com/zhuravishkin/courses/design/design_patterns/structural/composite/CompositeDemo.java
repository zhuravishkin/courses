package com.zhuravishkin.courses.design.design_patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

// Client
public class CompositeDemo {
    public static void main(String[] args) {
        // Базовые элементы
        Graphic line1 = new Line();
        Graphic line2 = new Line();
        Graphic circle = new Circle();

        // Группа фигур
        CompositeGraphic group = new CompositeGraphic();
        group.add(line1);
        group.add(line2);
        group.add(circle);

        // Вложенные группы
        CompositeGraphic nestedGroup = new CompositeGraphic();
        nestedGroup.add(group);
        nestedGroup.add(new Circle());

        // Отрисовка
        System.out.println("Drawing the main group:");
        group.draw();

        System.out.println("\nDrawing the nested group:");
        nestedGroup.draw();
    }
}

// Component: Общий интерфейс
interface Graphic {
    void draw();
}

// Leaf: Конкретная реализация для базовых объектов
class Line implements Graphic {
    @Override
    public void draw() {
        System.out.println("Drawing a Line");
    }
}

class Circle implements Graphic {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

// Composite: Группа графических объектов
class CompositeGraphic implements Graphic {
    private final List<Graphic> children = new ArrayList<>();

    public void add(Graphic graphic) {
        children.add(graphic);
    }

    public void remove(Graphic graphic) {
        children.remove(graphic);
    }

    @Override
    public void draw() {
        for (Graphic child : children) {
            child.draw();
        }
    }
}
