package com.zhuravishkin.courses.demo;

public class AutoCloseableDemo {
    public static void main(String[] args) {
        try (Search search = new Search()) {
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static class Search implements AutoCloseable {
        @Override
        public void close() throws Exception {
            System.out.println("AutoCloseable: close run");
        }
    }
}
