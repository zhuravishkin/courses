package com.zhuravishkin.courses.design.solid.c_lsp;

public class AreaCalculator {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(5, 4);
        System.out.println("Rectangle area: " + rect.getArea()); // Ожидается 20

        Square square = new Square(5);
        System.out.println("Square area: " + square.getArea());  // Ожидается 25
    }
}

interface Shape {
    int getArea();
}

class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

class Square implements Shape {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    public int getArea() {
        return side * side;
    }
}
