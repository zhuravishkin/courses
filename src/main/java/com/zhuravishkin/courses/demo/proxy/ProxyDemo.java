package com.zhuravishkin.courses.demo.proxy;

import java.lang.reflect.Proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        Person person = new Man("Вася", 30, "Санкт-Петербург", "Россия");

        ClassLoader classLoader = person.getClass().getClassLoader();
        Class<?>[] interfaces = person.getClass().getInterfaces();
        CustomInvocationHandler invocationHandler = new CustomInvocationHandler(person);

        Person proxyPerson = (Person) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);

//        person.introduce();
        proxyPerson.introduce();
    }
}
