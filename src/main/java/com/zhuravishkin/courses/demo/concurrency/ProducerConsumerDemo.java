package com.zhuravishkin.courses.demo.concurrency;

import java.util.LinkedList;

public class ProducerConsumerDemo {
    private static final int CAPACITY = 5;
    private final LinkedList<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        ProducerConsumerDemo pc = new ProducerConsumerDemo();

        // Создаем поток производителя
        Thread producerThread = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        });

        // Создаем поток потребителя
        Thread consumerThread = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        });

        // Запускаем потоки
        producerThread.start();
        consumerThread.start();
    }

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                // Ждем, пока очередь не освободится
                while (queue.size() == CAPACITY) {
                    wait();
                }

                System.out.println("Producer produced-" + value);

                // Добавляем элемент в конец списка
                queue.add(value++);

                // Уведомляем потребителя
                notify();

                // Делаем задержку
                Thread.sleep(1000);
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                // Ждем, пока в очереди появятся элементы
                while (queue.isEmpty()) {
                    wait();
                }

                // Извлекаем элемент из начала списка
                int value = queue.removeFirst();

                System.out.println("Consumer consumed-" + value);

                // Уведомляем производителя
                notify();

                // Делаем задержку
                Thread.sleep(1000);
            }
        }
    }
}
