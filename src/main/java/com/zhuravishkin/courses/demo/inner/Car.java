package com.zhuravishkin.courses.demo.inner;

public class Car {
    int count = 5;

    public static void main(String[] args) {
        Door door;
//        door = new Door();
        door = new Car().new Door();
        System.out.println(door.getCount(0));
    }

    class Door {
        int count = 7;

        public int getCount(int count) {
            if (count != 0) {
                return this.count;
            } else {
                return Car.this.count;
            }
        }
    }
}
