package com.zhuravishkin.courses.stepik.java.basecourse.oop;

public class Robot {
    public static void main(String[] args) {
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        int x = robot.getX();
        int y = robot.getY();
        if (x < toX) {
            while (robot.getDirection() != Direction.RIGHT) {
                robot.turnRight();
            }
            while (x != toX) {
                robot.stepForward();
                x++;
            }
        } else if (x > toX) {
            while (robot.getDirection() != Direction.LEFT) {
                robot.turnRight();
            }
            while (x != toX) {
                robot.stepForward();
                x--;
            }
        }
        if (y < toY) {
            while (robot.getDirection() != Direction.UP) {
                robot.turnRight();
            }
            while (y != toY) {
                robot.stepForward();
                y++;
            }
        } else if (y > toY) {
            while (robot.getDirection() != Direction.DOWN) {
                robot.turnRight();
            }
            while (y != toY) {
                robot.stepForward();
                y--;
            }
        }
    }

    public Direction getDirection() {
        // текущее направление взгляда
        return null;
    }

    public int getX() {
        // текущая координата X
        return 0;
    }

    public int getY() {
        // текущая координата Y
        return 0;
    }

    public void turnLeft() {
        // повернуться на 90 градусов против часовой стрелки
    }

    public void turnRight() {
        // повернуться на 90 градусов по часовой стрелке
    }

    public void stepForward() {
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
}
