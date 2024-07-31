package com.zhuravishkin.courses.demo;

import java.util.concurrent.*;

public class ScheduledExecutorServiceDemo {
    private static int count = 0;

    public static void main(String[] args) {
        try {
            schedule();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

//    private static void schedule() throws Exception {
//        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
//        CompletableFuture<Void> future = new CompletableFuture<>();
//
//        Runnable task = () -> {
//            try {
//                run();
//            } catch (Exception e) {
//                future.completeExceptionally(e);
//                scheduler.shutdown();
//            }
//        };
//
//        scheduler.scheduleAtFixedRate(task, 0, 2, TimeUnit.SECONDS);
//
//        future.exceptionally(ex -> {
//            scheduler.shutdown();
//            throw new CompletionException(ex);
//        }).join();
//    }

    private static void schedule() throws Exception {
        ScheduledExecutorService schedulerF = Executors.newScheduledThreadPool(1);
        ScheduledExecutorService schedulerS = Executors.newScheduledThreadPool(1);

        CompletableFuture<Void> future = new CompletableFuture<>();

        schedulerF.schedule(() -> {
            System.out.println("schedule");
            schedulerS.scheduleAtFixedRate(() -> {
                try {
                    run();
                } catch (Exception e) {
                    future.completeExceptionally(e);
                    schedulerS.shutdown();
                }
            }, 0, 2, TimeUnit.SECONDS);
        }, 2, TimeUnit.SECONDS);

        future.exceptionally(ex -> {
            schedulerS.shutdown();
            throw new CompletionException(ex);
        }).join();
    }

    public static void run() {
        System.out.println("run: " + count);

        count++;
        if (count == 3) {
            throw new RuntimeException("ex");
        }
    }
}
