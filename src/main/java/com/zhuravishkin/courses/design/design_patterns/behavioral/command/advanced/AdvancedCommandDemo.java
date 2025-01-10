package com.zhuravishkin.courses.design.design_patterns.behavioral.command.advanced;

import java.util.*;

// Client
public class AdvancedCommandDemo {
    public static void main(String[] args) throws InterruptedException {
        // Создание получателя
        Light livingRoomLight = new Light();

        // Создание команд
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        // Создание пульта
        AdvancedRemoteControl remote = new AdvancedRemoteControl();

        // Немедленное выполнение команды
        System.out.println("Executing command immediately:");
        remote.executeCommand(lightOn);

        // Отложенное выполнение команды
        System.out.println("\nExecuting command with delay:");
        remote.executeDelayed(lightOff, 2000);

        // Добавление команд в очередь
        System.out.println("\nAdding commands to queue:");
        remote.addCommandToQueue(lightOn);
        remote.addCommandToQueue(lightOff);
        remote.addCommandToQueue(lightOn);

        // Выполнение команд из очереди
        System.out.println("\nExecuting command queue:");
        remote.executeQueue();

        // Отмена последней команды
        System.out.println("\nUndoing last command:");
        remote.undoLastCommand();

        // Отмена ещё одной команды
        System.out.println("\nUndoing another command:");
        remote.undoLastCommand();
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

// Invoker: Пульт управления с дополнительными функциями
class AdvancedRemoteControl {
    private final Queue<Command> commandQueue = new LinkedList<>();
    private final Stack<Command> commandHistory = new Stack<>();

    // Выполнение команды сразу
    public void executeCommand(Command command) {
        command.execute();
        commandHistory.push(command);
    }

    // Добавление команды в очередь
    public void addCommandToQueue(Command command) {
        commandQueue.add(command);
    }

    // Выполнение всех команд из очереди
    public void executeQueue() {
        while (!commandQueue.isEmpty()) {
            Command command = commandQueue.poll();
            command.execute();
            commandHistory.push(command);
        }
    }

    // Отложенное выполнение команды
    public void executeDelayed(Command command, int delayInMillis) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                command.execute();
                commandHistory.push(command);
            }
        }, delayInMillis);
    }

    // Отмена последней команды
    public void undoLastCommand() {
        if (!commandHistory.isEmpty()) {
            Command command = commandHistory.pop();
            command.undo();
        } else {
            System.out.println("Nothing to undo.");
        }
    }
}
