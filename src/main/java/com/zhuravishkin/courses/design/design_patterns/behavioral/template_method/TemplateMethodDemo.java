package com.zhuravishkin.courses.design.design_patterns.behavioral.template_method;

// Client
public class TemplateMethodDemo {
    public static void main(String[] args) {
        // Создаём текстовое окно
        ApplicationWindow textWindow = new TextWindow();
        System.out.println("Displaying Text Window:");
        textWindow.display();

        // Создаём графическое окно
        ApplicationWindow graphicWindow = new GraphicWindow();
        System.out.println("\nDisplaying Graphic Window:");
        graphicWindow.display();
    }
}

// AbstractClass: Базовый класс для пользовательских окон
abstract class ApplicationWindow {
    // Шаблонный метод: общий алгоритм отображения окна
    public final void display() {
        drawWindowBorder();
        drawWindowContent();
        handleInput();
    }

    // Общие шаги, не зависящие от подклассов
    private void drawWindowBorder() {
        System.out.println("Drawing window border");
    }

    private void handleInput() {
        System.out.println("Handling user input");
    }

    // Абстрактный метод: наполнение окна, которое определяют подклассы
    protected abstract void drawWindowContent();
}

// ConcreteClass: Текстовое окно
class TextWindow extends ApplicationWindow {
    @Override
    protected void drawWindowContent() {
        System.out.println("Displaying text content");
    }
}

// ConcreteClass: Графическое окно
class GraphicWindow extends ApplicationWindow {
    @Override
    protected void drawWindowContent() {
        System.out.println("Displaying graphical content");
    }
}
