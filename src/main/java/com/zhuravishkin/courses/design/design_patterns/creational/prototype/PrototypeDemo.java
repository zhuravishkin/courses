package com.zhuravishkin.courses.design.design_patterns.creational.prototype;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Client
public class PrototypeDemo {
    public static void main(String[] args) {
        // Создаем и регистрируем прототипы
        ShapeRegistry registry = new ShapeRegistry();

        Circle circle = new Circle();
        circle.setId("1");
        circle.setRadius(10);
        circle.setColor("Red");
        circle.addMetadata("Created by Alexey");
        registry.registerShape("Circle", circle);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("2");
        rectangle.setWidth(20);
        rectangle.setHeight(30);
        rectangle.setColor("Blue");
        rectangle.addMetadata("Created for a demo");
        registry.registerShape("Rectangle", rectangle);

        // Используем прототипы
        Shape clonedCircle = registry.getShape("Circle");
        clonedCircle.addMetadata("Cloned on: 2024-12-29");
        clonedCircle.draw();
        System.out.println("Metadata: " + clonedCircle.getMetadata());

        Shape clonedRectangle = registry.getShape("Rectangle");
        clonedRectangle.addMetadata("Cloned on: 2024-12-29");
        clonedRectangle.draw();
        System.out.println("Metadata: " + clonedRectangle.getMetadata());

        // Проверка на глубокое копирование
        System.out.println("Original Circle Metadata: " + circle.getMetadata());
    }
}

// Prototype
abstract class Shape implements Cloneable {
    private String id;
    private String color;
    private List<String> metadata = new ArrayList<>(); // Дополнительные данные

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<String> getMetadata() {
        return metadata;
    }

    public void addMetadata(String data) {
        metadata.add(data);
    }

    // Метод для глубокого клонирования
    @Override
    public Shape clone() {
        try {
            Shape cloned = (Shape) super.clone();
            // Глубокое клонирование списка
            cloned.metadata = new ArrayList<>(this.metadata);

            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported");
        }
    }

    public abstract void draw();
}

// ConcretePrototype 1
class Circle extends Shape {
    private int radius;

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Circle with radius " + radius + " and color " + getColor());
    }

    @Override
    public Shape clone() {
        Circle cloned = (Circle) super.clone();
        cloned.setRadius(this.radius);
        return cloned;
    }
}

// ConcretePrototype 2
class Rectangle extends Shape {
    private int width;
    private int height;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle with width " + width + ", height " + height + " and color " + getColor());
    }

    @Override
    public Shape clone() {
        Rectangle cloned = (Rectangle) super.clone();
        cloned.setWidth(this.width);
        cloned.setHeight(this.height);
        return cloned;
    }
}

// Prototype Registry
class ShapeRegistry {
    private final Map<String, Shape> prototypes = new HashMap<>();

    public void registerShape(String key, Shape prototype) {
        prototypes.put(key, prototype);
    }

    public Shape getShape(String key) {
        return prototypes.get(key).clone();
    }
}
