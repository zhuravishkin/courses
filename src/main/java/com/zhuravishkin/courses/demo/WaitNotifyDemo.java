package com.zhuravishkin.courses.demo;

import lombok.SneakyThrows;

public class WaitNotifyDemo {
    public static void main(String[] args) {
        Box box = new Box();
        new Thread(() -> {
            while (true) {
                box.setWeight(10);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                box.getWeight();
            }
        }).start();
    }
}

class Box {
    private int weight;

    public boolean isEmpty() {
        return weight == 0;
    }

    @SneakyThrows
    public synchronized void getWeight() {
        while (isEmpty()) {
            this.wait();
        }
        weight = 0;
        System.out.println("коробка отправлена");
    }

    public synchronized void setWeight(int weight) {
        this.weight = weight;
        this.notify();
        System.out.println("коробка прибыла");
    }
}
