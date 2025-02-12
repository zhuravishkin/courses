package com.zhuravishkin.courses.design.solid.d_isp;

public class ISPDemo {
}

// Интерфейс, определяющий только работу
interface Workable {
    void work();
}

// Интерфейс, определяющий только возможность принимать пищу
interface Eatable {
    void eat();
}

// Человек реализует оба интерфейса, поскольку ему нужны оба метода
class HumanWorker implements Workable, Eatable {
    @Override
    public void work() {
        System.out.println("Human is working");
    }

    @Override
    public void eat() {
        System.out.println("Human is eating");
    }
}

// Робот реализует только интерфейс Workable
class RobotWorker implements Workable {
    @Override
    public void work() {
        System.out.println("Robot is working");
    }
}
