package com.zhuravishkin.courses.stepik.java.basecourse.exception;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class LogDemo {
    public static final Logger LOGGER = Logger.getLogger(LogDemo.class.getName());

    public static void main(String[] args) {
        LOGGER.log(Level.SEVERE, "log {0}", "test");
        final Logger LOGGER_A = Logger.getLogger("org.stepic.java.logging.ClassA");
        LOGGER_A.setLevel(Level.ALL);
        final Logger LOGGER_B = Logger.getLogger("org.stepic.java.logging.ClassB");
        LOGGER_B.setLevel(Level.WARNING);
        final Logger LOGGER_C = Logger.getLogger("org.stepic.java");
        final ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(new XMLFormatter());
        LOGGER_C.addHandler(consoleHandler);
        LOGGER_C.setUseParentHandlers(false);
    }
}
