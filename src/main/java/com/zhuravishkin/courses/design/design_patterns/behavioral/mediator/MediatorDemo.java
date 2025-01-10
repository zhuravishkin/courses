package com.zhuravishkin.courses.design.design_patterns.behavioral.mediator;

// Client
public class MediatorDemo {
    public static void main(String[] args) {
        // Создаём посредника
        DialogMediator mediator = new DialogMediator();

        // Создаём компоненты
        TextBox textBox = new TextBox(mediator);
        Button button = new Button(mediator);
        CheckBox checkBox = new CheckBox(mediator);

        // Устанавливаем связи
        mediator.setTextBox(textBox);
        mediator.setButton(button);
        mediator.setCheckBox(checkBox);

        // Взаимодействие
        System.out.println("Toggling checkbox:");
        checkBox.toggle();

        System.out.println("\nSetting text in TextBox:");
        textBox.setText("Hello, Mediator!");

        System.out.println("\nClicking button:");
        button.click();

        System.out.println("\nToggling checkbox again:");
        checkBox.toggle();
        button.click();
    }
}

// Mediator: Интерфейс для посредника
interface Mediator {
    void notify(Component sender, String event);
}

// Abstract Colleague: Базовый класс для компонентов
abstract class Component {
    protected Mediator mediator;

    public Component(Mediator mediator) {
        this.mediator = mediator;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }
}

// ConcreteColleague: Текстовое поле
class TextBox extends Component {
    private String text = "";

    public TextBox(Mediator mediator) {
        super(mediator);
    }

    public void setText(String text) {
        this.text = text;
        mediator.notify(this, "textChanged");
    }

    public String getText() {
        return text;
    }
}

// ConcreteColleague: Кнопка
class Button extends Component {
    private boolean enabled = false;

    public Button(Mediator mediator) {
        super(mediator);
    }

    public void click() {
        if (enabled) {
            mediator.notify(this, "click");
        }
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        System.out.println("Button is " + (enabled ? "enabled" : "disabled"));
    }
}

// ConcreteColleague: Чекбокс
class CheckBox extends Component {
    private boolean checked = false;

    public CheckBox(Mediator mediator) {
        super(mediator);
    }

    public void toggle() {
        checked = !checked;
        mediator.notify(this, "toggle");
    }

    public boolean isChecked() {
        return checked;
    }
}

// ConcreteMediator: Посредник для диалогового окна
class DialogMediator implements Mediator {
    private TextBox textBox;
    private Button button;
    private CheckBox checkBox;

    public void setTextBox(TextBox textBox) {
        this.textBox = textBox;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }

    @Override
    public void notify(Component sender, String event) {
        if (sender instanceof CheckBox && event.equals("toggle")) {
            button.setEnabled(((CheckBox) sender).isChecked());
        } else if (sender instanceof TextBox && event.equals("textChanged")) {
            System.out.println("TextBox content: " + ((TextBox) sender).getText());
        } else if (sender instanceof Button && event.equals("click")) {
            System.out.println("Button clicked. Sending data: " + textBox.getText());
        }
    }
}
