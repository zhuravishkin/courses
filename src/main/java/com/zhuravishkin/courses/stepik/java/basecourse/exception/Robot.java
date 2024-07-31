package com.zhuravishkin.courses.stepik.java.basecourse.exception;

public class Robot {
    public static void main(String[] args) {
        RobotConnectionManager connectionManager = new MyRobotConnectionManager();
        Robot.moveRobot(connectionManager, 10, 10);
    }

    interface RobotConnection extends AutoCloseable {
        void moveRobotTo(int x, int y);

        @Override
        void close();
    }

    interface RobotConnectionManager {
        RobotConnection getConnection();
    }

    static class RobotConnectionException extends RuntimeException {

        public RobotConnectionException(String message) {
            super(message);

        }

        public RobotConnectionException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    static class MyRobotConnection implements RobotConnection {
        @Override
        public void moveRobotTo(int x, int y) {
            System.out.printf("move to %s:%s%n", x, y);
        }

        @Override
        public void close() {
            System.out.println("close");
        }
    }

    static class MyRobotConnectionManager implements RobotConnectionManager {
        @Override
        public RobotConnection getConnection() {
            return new MyRobotConnection();
        }
    }

    static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        RobotConnection connection = null;
        for (int i = 0; i < 3; i++) {
            try {
                connection = robotConnectionManager.getConnection();
                connection.moveRobotTo(toX, toY);
                return;
            } catch (RobotConnectionException e) {
                System.out.println("robot connection exception");
            } catch (Throwable e) {
                throw e;
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (Exception e) {
                }
            }
        }
        throw new RobotConnectionException("failed to get connection");
    }
}
