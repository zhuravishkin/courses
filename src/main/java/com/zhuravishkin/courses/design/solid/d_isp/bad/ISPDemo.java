package com.zhuravishkin.courses.design.solid.d_isp.bad;

public class ISPDemo {
}

// "Толстый" интерфейс, содержащий методы, не всегда необходимые клиенту
interface Worker {
    void work();

    void eat();
}

// Реализация для человека, где оба метода имеют смысл
class HumanWorker implements Worker {
    @Override
    public void work() {
        System.out.println("Human is working");
    }

    @Override
    public void eat() {
        System.out.println("Human is eating");
    }
}

// Реализация для робота, которому метод eat() не нужен
class RobotWorker implements Worker {
    @Override
    public void work() {
        System.out.println("Robot is working");
    }

    @Override
    public void eat() {
        // Робот не ест, но вынужден реализовать метод
        throw new UnsupportedOperationException("Robot does not eat");
    }
}
