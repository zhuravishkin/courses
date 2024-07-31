package com.zhuravishkin.courses.javarush.dynamicproxyexample;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {
    private Object object;

    public CustomInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("getName")) {
            System.out.println("CustomInvocationHandler invoke: " + method.getName());
        } else if (method.getName().equals("setName")) {
            System.out.println("CustomInvocationHandler invoke: " + method.getName());
        }
        return method.invoke(object, args);
    }
}
