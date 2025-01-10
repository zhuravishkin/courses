package com.zhuravishkin.courses.design.design_patterns.structural.bridge;

// Client
public class BridgeDemo {
    public static void main(String[] args) {
        // Рендеринг на экране
        Renderer screenRenderer = new ScreenRenderer();
        Shape screenCircle = new Circle(screenRenderer, 5);
        screenCircle.draw();

        Shape screenRectangle = new Rectangle(screenRenderer, 10, 20);
        screenRectangle.draw();

        // Рендеринг в файл
        Renderer fileRenderer = new FileRenderer();
        Shape fileCircle = new Circle(fileRenderer, 7);
        fileCircle.draw();

        Shape fileRectangle = new Rectangle(fileRenderer, 15, 25);
        fileRectangle.draw();
    }
}

// Implementor: Интерфейс для низкоуровневых реализаций
interface Renderer {
    void renderCircle(float radius);

    void renderRectangle(float width, float height);
}

// ConcreteImplementor 1: Реализация для рендеринга на экране
class ScreenRenderer implements Renderer {
    @Override
    public void renderCircle(float radius) {
        System.out.println("Rendering circle on screen with radius: " + radius);
    }

    @Override
    public void renderRectangle(float width, float height) {
        System.out.println("Rendering rectangle on screen with width: " + width + ", height: " + height);
    }
}

// ConcreteImplementor 2: Реализация для рендеринга в файл
class FileRenderer implements Renderer {
    @Override
    public void renderCircle(float radius) {
        System.out.println("Saving circle to file with radius: " + radius);
    }

    @Override
    public void renderRectangle(float width, float height) {
        System.out.println("Saving rectangle to file with width: " + width + ", height: " + height);
    }
}

// Abstraction: Высокоуровневый интерфейс для фигур
abstract class Shape {
    protected Renderer renderer;

    public Shape(Renderer renderer) {
        this.renderer = renderer;
    }

    public abstract void draw();
}

// RefinedAbstraction 1: Круг
class Circle extends Shape {
    private float radius;

    public Circle(Renderer renderer, float radius) {
        super(renderer);
        this.radius = radius;
    }

    @Override
    public void draw() {
        renderer.renderCircle(radius);
    }
}

// RefinedAbstraction 2: Прямоугольник
class Rectangle extends Shape {
    private float width;
    private float height;

    public Rectangle(Renderer renderer, float width, float height) {
        super(renderer);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        renderer.renderRectangle(width, height);
    }
}
