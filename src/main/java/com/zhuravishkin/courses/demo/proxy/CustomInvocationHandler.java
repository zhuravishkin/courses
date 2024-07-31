package com.zhuravishkin.courses.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class CustomInvocationHandler implements InvocationHandler {
    private final Person target;

    public CustomInvocationHandler(Person target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method + ":" + Arrays.toString(args));
        System.out.println("Hello!");

        return method.invoke(target, args);
    }
}
