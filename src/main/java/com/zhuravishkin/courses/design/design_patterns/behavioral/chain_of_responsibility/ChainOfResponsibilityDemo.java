package com.zhuravishkin.courses.design.design_patterns.behavioral.chain_of_responsibility;

// Client
public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        // Создаём обработчики
        Logger infoLogger = new InfoLogger();
        Logger debugLogger = new DebugLogger();
        Logger errorLogger = new ErrorLogger();

        // Формируем цепочку
        infoLogger.setNext(debugLogger);
        debugLogger.setNext(errorLogger);

        // Отправляем запросы
        infoLogger.logMessage("This is an info message.", LogLevel.INFO);
        infoLogger.logMessage("This is a debug message.", LogLevel.DEBUG);
        infoLogger.logMessage("This is an error message.", LogLevel.ERROR);
    }
}

// Handler: Абстрактный класс обработчика
abstract class Logger {
    protected Logger nextLogger;

    public void setNext(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(String message, LogLevel level) {
        if (canHandle(level)) {
            writeMessage(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(message, level);
        }
    }

    protected abstract boolean canHandle(LogLevel level);

    protected abstract void writeMessage(String message);
}

// LogLevel: Перечисление уровней логирования
enum LogLevel {
    INFO, DEBUG, ERROR
}

// ConcreteHandler: Логирование уровня INFO
class InfoLogger extends Logger {
    @Override
    protected boolean canHandle(LogLevel level) {
        return level == LogLevel.INFO;
    }

    @Override
    protected void writeMessage(String message) {
        System.out.println("INFO: " + message);
    }
}

// ConcreteHandler: Логирование уровня DEBUG
class DebugLogger extends Logger {
    @Override
    protected boolean canHandle(LogLevel level) {
        return level == LogLevel.DEBUG;
    }

    @Override
    protected void writeMessage(String message) {
        System.out.println("DEBUG: " + message);
    }
}

// ConcreteHandler: Логирование уровня ERROR
class ErrorLogger extends Logger {
    @Override
    protected boolean canHandle(LogLevel level) {
        return level == LogLevel.ERROR;
    }

    @Override
    protected void writeMessage(String message) {
        System.out.println("ERROR: " + message);
    }
}
