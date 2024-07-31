package com.zhuravishkin.courses.demo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogLevelDemo {
    public static void main(String[] args) {
        System.out.println("isInfoEnabled: " + log.isInfoEnabled());
        System.out.println("isDebugEnabled: " + log.isDebugEnabled());
        System.out.println("isWarnEnabled: " + log.isWarnEnabled());
        System.out.println("isErrorEnabled: " + log.isErrorEnabled());
        System.out.println("isTraceEnabled: " + log.isTraceEnabled());
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }
}
