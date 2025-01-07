package com.zhuravishkin.courses.design_patterns.creational.singleton;

public class SingletonDemo {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("This is a log message.");
    }
}

class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {
    }

    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}

class DoubleCheckedLockingSingleton {
    private static volatile DoubleCheckedLockingSingleton instance;

    private DoubleCheckedLockingSingleton() {
    }

    public static DoubleCheckedLockingSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }
}

enum EnumSingleton {
    INSTANCE;

    public void someMethod() {
        System.out.println("Singleton method called");
    }
}

class Logger {
    private static Logger instance;
    private static String logFile;

    private Logger() {
        logFile = "Log file:\n";
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                instance = new Logger();
            }
        }
        return instance;
    }

    public void log(String message) {
        logFile += message + "\n";
        System.out.println(logFile);
    }
}
