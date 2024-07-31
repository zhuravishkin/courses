package com.zhuravishkin.courses.stepik.java.basecourse.exception;

public class CallerName {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length <= 2) {
            return null;
        }
        return stackTrace[2].getClassName() + '#' + stackTrace[2].getMethodName();
    }
}
