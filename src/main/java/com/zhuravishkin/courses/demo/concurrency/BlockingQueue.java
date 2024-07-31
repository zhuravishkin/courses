package com.zhuravishkin.courses.demo.concurrency;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue<T> {
    private final Queue<T> queue = new LinkedList<>();
    private final int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    // Метод для добавления элементов в очередь
    public synchronized void enqueue(T item) throws InterruptedException {
        while (this.queue.size() == this.capacity) {
            wait(); // Ожидаем, пока не освободится место в очереди
        }
        this.queue.add(item);
        notifyAll(); // Уведомляем ожидающие потоки, что можно добавлять или извлекать элементы
    }

    // Метод для извлечения элементов из очереди
    public synchronized T dequeue() throws InterruptedException {
        while (this.queue.isEmpty()) {
            wait(); // Ожидаем, пока в очереди не появятся элементы
        }
        T item = this.queue.poll();
        notifyAll(); // Уведомляем ожидающие потоки, что можно добавлять или извлекать элементы

        return item;
    }

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new BlockingQueue<>(10);

        // Поток для добавления элементов
        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 20; i++) {
                    queue.enqueue(i);
                    System.out.println("Produced: " + i);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Поток для извлечения элементов
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 20; i++) {
                    Integer item = queue.dequeue();
                    System.out.println("Consumed: " + item);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
