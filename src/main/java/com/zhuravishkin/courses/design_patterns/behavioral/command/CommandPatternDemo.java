package com.zhuravishkin.courses.design_patterns.behavioral.command;

// Client
public class CommandPatternDemo {
    public static void main(String[] args) {
        // Создание получателей
        Light livingRoomLight = new Light();
        AirConditioner airConditioner = new AirConditioner();

        // Создание команд
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);
        Command acOn = new AirConditionerOnCommand(airConditioner);

        // Создание пульта
        RemoteControl remote = new RemoteControl();

        // Управление светом
        remote.setCommand(lightOn);
        remote.pressButton(); // Light is ON
        remote.pressUndo();   // Light is OFF

        // Управление кондиционером
        remote.setCommand(acOn);
        remote.pressButton(); // Air Conditioner is ON
        remote.pressUndo();   // Air Conditioner is OFF
    }
}

// Command: Интерфейс для всех команд
interface Command {
    void execute();

    void undo();
}

// Receiver: Свет
class Light {
    public void turnOn() {
        System.out.println("Light is ON");
    }

    public void turnOff() {
        System.out.println("Light is OFF");
    }
}

// ConcreteCommand: Команда для включения света
class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }

    @Override
    public void undo() {
        light.turnOff();
    }
}

// ConcreteCommand: Команда для выключения света
class LightOffCommand implements Command {
    private final Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
    }
}

// Receiver: Кондиционер
class AirConditioner {
    public void turnOn() {
        System.out.println("Air Conditioner is ON");
    }

    public void turnOff() {
        System.out.println("Air Conditioner is OFF");
    }
}

// ConcreteCommand: Команда для включения кондиционера
class AirConditionerOnCommand implements Command {
    private final AirConditioner airConditioner;

    public AirConditionerOnCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.turnOn();
    }

    @Override
    public void undo() {
        airConditioner.turnOff();
    }
}

// Invoker: Пульт управления
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }

    public void pressUndo() {
        command.undo();
    }
}
