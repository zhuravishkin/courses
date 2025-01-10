package com.zhuravishkin.courses.design.design_patterns.structural.decorator;

// Client
public class DecoratorDemo {
    public static void main(String[] args) {
        // Базовый текст
        TextView textView = new SimpleTextView();

        // Декорируем текст рамкой
        TextView borderedTextView = new BorderDecorator(textView);

        // Декорируем текст прокруткой и рамкой
        TextView scrollableBorderedTextView = new ScrollDecorator(borderedTextView);

        // Рендеринг
        System.out.println("Plain Text:");
        textView.render();

        System.out.println("\nText with Border:");
        borderedTextView.render();

        System.out.println("\nText with Border and Scroll:");
        scrollableBorderedTextView.render();
    }
}

// Component: Общий интерфейс
interface TextView {
    void render();
}

// ConcreteComponent: Базовый текстовый компонент
class SimpleTextView implements TextView {
    @Override
    public void render() {
        System.out.println("Rendering plain text");
    }
}

// Decorator: Базовый декоратор
abstract class TextViewDecorator implements TextView {
    protected TextView wrappedTextView;

    public TextViewDecorator(TextView textView) {
        this.wrappedTextView = textView;
    }

    @Override
    public void render() {
        wrappedTextView.render();
    }
}

// ConcreteDecorator: Добавляет рамку
class BorderDecorator extends TextViewDecorator {
    public BorderDecorator(TextView textView) {
        super(textView);
    }

    @Override
    public void render() {
        super.render();
        System.out.println("Adding a border");
    }
}

// ConcreteDecorator: Добавляет прокрутку
class ScrollDecorator extends TextViewDecorator {
    public ScrollDecorator(TextView textView) {
        super(textView);
    }

    @Override
    public void render() {
        super.render();
        System.out.println("Adding scroll functionality");
    }
}
