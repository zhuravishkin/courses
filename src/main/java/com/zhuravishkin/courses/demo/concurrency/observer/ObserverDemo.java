package com.zhuravishkin.courses.demo.concurrency.observer;

public class ObserverDemo {
    public static void main(String[] args) {
        ConcreteObservable observable = new ConcreteObservable();
        observable.addObserver(new ConcreteObserver("Observer 1"));
        observable.addObserver(new ConcreteObserver("Observer 2"));

        observable.setMessage("Hello, Observers!");
    }
}
