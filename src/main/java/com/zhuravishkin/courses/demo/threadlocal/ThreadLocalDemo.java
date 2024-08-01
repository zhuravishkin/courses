package com.zhuravishkin.courses.demo.threadlocal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.TimeUnit;

public class ThreadLocalDemo {
    public static void main(String[] args) throws InterruptedException {
        run();
    }

    private static void run() throws InterruptedException {
        final ThreadLocal<User> threadLocalUser = ThreadLocal.withInitial(() -> new User("Default"));

        Thread thread1 = new Thread(() -> {
            threadLocalUser.set(new User("Dean"));
            System.out.println("thread1: " + threadLocalUser.get());
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    threadLocalUser.get().setName(String.valueOf(i));
                    System.out.println("thread2: " + threadLocalUser.get());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            threadLocalUser.set(new User("Sam"));
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("thread2: " + threadLocalUser.get());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();
    }

//    private static void run() {
//        Thread thread1 = new Thread(() -> {
//            try {
//                User user = new User("Dean");
//                System.out.println("thread1: " + user);
//                for (int i = 0; i < 10; i++) {
//                    TimeUnit.SECONDS.sleep(1);
//                    user.setName(String.valueOf(i));
//                    System.out.println("thread1: " + user);
//                }
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//
//        Thread thread2 = new Thread(() -> {
//            User user = new User("Sam");
//            for (int i = 0; i < 10; i++) {
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                    System.out.println("thread2: " + user);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
//
//        thread1.start();
//        thread2.start();
//
////        thread1.join();
////        thread2.join();
//    }
}

@ToString
@Getter
@Setter
@AllArgsConstructor
class User {
    private String name;
}
