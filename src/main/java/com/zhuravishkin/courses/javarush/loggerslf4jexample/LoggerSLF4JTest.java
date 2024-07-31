package com.zhuravishkin.courses.javarush.loggerslf4jexample;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class LoggerSLF4JTest {
    private static final Logger logger = LoggerFactory.getLogger(LoggerSLF4JTest.class);

    public static void main(String[] args) {
        String logProperties = "src/main/java/com/zhuravishkin/zhuravishkin/javarush/loggerslf4jexample/log4j.properties";
        Path path = Paths.get(logProperties).toAbsolutePath();
        try (InputStream is = new FileInputStream(path.toFile())) {
            Properties properties = new Properties();
            properties.load(is);
            PropertyConfigurator.configure(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.debug("Debug");
        logger.info("Info");
        logger.warn("Warn");
        logger.error("Error");
        logger.info("Fatal");
    }
}
