package com.zhuravishkin.courses.demo.inner;

public class Zoo {
    private static int count = 7;
    private int mouseCount = 5;

    public static void main(String[] args) {
        Mouse mouse = new Mouse();
        System.out.println(mouse.getCount());
    }

    public static int getAnimalCount() {
        return count;
    }

    public int getMouseCount() {
        return mouseCount;
    }

    public static class Mouse {
        public int getCount() {
            return count;
        }
    }
}
