package com.zhuravishkin.courses.demo.concurrency;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

public class LivelockExample {
    public static void main(String[] args) {
        Diner husband = new Diner("Husband");
        Diner wife = new Diner("Wife");

        Spoon sharedSpoon = new Spoon(husband);

        new Thread(() -> husband.eatWith(sharedSpoon, wife)).start();
        new Thread(() -> wife.eatWith(sharedSpoon, husband)).start();
    }

    @AllArgsConstructor
    @Getter
    @Setter
    static class Spoon {
        private Diner owner;

        public synchronized void use() {
            System.out.println(owner.name + " is eating.");
        }
    }

    @RequiredArgsConstructor
    @Getter
    static class Diner {
        private final String name;
        private boolean isHungry;

        {
            this.isHungry = true;
        }

//        public void eatWith(Spoon spoon, Diner spouse) {
//            while (isHungry) {
//                if (spoon.getOwner() != this) {
//                    try {
//                        Thread.sleep(1); // Подождать немного
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    continue;
//                }
//
//                if (spouse.isHungry()) {
//                    System.out.println(name + ": " + spouse.getName() + " ты можешь есть первой.");
//                    spoon.setOwner(spouse);
//
//                    // Добавляем случайное время ожидания, чтобы избежать постоянных изменений
//                    try {
//                        Thread.sleep((int) (Math.random() * 10));
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    continue;
//                }
//
//                spoon.use();
//                isHungry = false;
//                System.out.println(name + ": Я поел.");
//                spoon.setOwner(spouse);
//            }
//        }

        public void eatWith(Spoon spoon, Diner spouse) {
            while (isHungry) {
                if (spoon.getOwner() != this) {
                    try {
                        Thread.sleep(1); // Подождать немного
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;
                }

                // Добавляем механизм тайм-аута для предотвращения постоянного уступания
                long startTime = System.currentTimeMillis();
                long timeout = 10; // Тайм-аут в миллисекундах

                while (spouse.isHungry() && (System.currentTimeMillis() - startTime) < timeout) {
                    System.out.println(name + ": " + spouse.getName() + " ты можешь есть первой.");
                    spoon.setOwner(spouse);
                    try {
                        Thread.sleep(1); // Подождать немного перед следующей проверкой
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                if (spouse.isHungry() && (System.currentTimeMillis() - startTime) >= timeout) {
                    System.out.println(name + ": Я больше не могу ждать, я буду есть.");
                } else {
                    spoon.use();
                    isHungry = false;
                    System.out.println(name + ": Я поел.");
                    spoon.setOwner(spouse);
                }
            }
        }
    }
}
