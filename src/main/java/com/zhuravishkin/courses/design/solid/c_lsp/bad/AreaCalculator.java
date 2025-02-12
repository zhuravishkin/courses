package com.zhuravishkin.courses.design.solid.c_lsp.bad;

public class AreaCalculator {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle();
        System.out.println("Rectangle area: " + calculateArea(rect)); // Ожидается 20

        // Если подставить квадрат вместо прямоугольника:
        Rectangle square = new Square();
        System.out.println("Square area: " + calculateArea(square)); // Получится 16, а не 20!
    }

    // Метод ожидает, что можно независимо задать ширину и высоту прямоугольника
    public static int calculateArea(Rectangle r) {
        r.setWidth(5);
        r.setHeight(4);
        return r.getArea();
    }
}

// Базовый класс – прямоугольник
class Rectangle {
    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

// Квадрат наследуется от прямоугольника, но для квадрата ширина и высота всегда равны
class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width; // При установке ширины меняем и высоту
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
        this.width = height; // При установке высоты меняем и ширину
    }
}

