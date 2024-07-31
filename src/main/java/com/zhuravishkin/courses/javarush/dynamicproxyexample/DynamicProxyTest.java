package com.zhuravishkin.courses.javarush.dynamicproxyexample;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {
    public static void main(String[] args) {
        User user = new User("John");
        IUser userProxy = (IUser) Proxy.newProxyInstance(User.class.getClassLoader(), User.class.getInterfaces(), new CustomInvocationHandler(user));
        System.out.println(userProxy.getName());
        userProxy.setName("Smith");
        System.out.println(userProxy.getName());
    }
}
