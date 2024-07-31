package com.zhuravishkin.courses.javarush;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.logging.Logger;

public class LogTest {
    public static void main(String[] args) throws JsonProcessingException {
        Logger logger = Logger.getLogger(LogTest.class.getName());
        logger.info("Hello!");
        Tuple tuple = new Tuple("Dean", 32);
        logger.warning(new ObjectMapper().writeValueAsString(tuple));
        logger.warning(List.of(new ObjectMapper().writeValueAsString(tuple)).toString());
    }

    static class Tuple {
        @JsonProperty("tuple_name")
        private String name;
        @JsonProperty("tuple_age")
        private int age;

        public Tuple(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
