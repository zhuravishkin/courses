package com.zhuravishkin.courses.design_patterns.structural.proxy;

// Client: Использует интерфейс Database
public class ProxyDemo {
    public static void main(String[] args) {
        // Пользователь с ролью ADMIN
        Database adminDatabase = new DatabaseProxy("ADMIN");
        adminDatabase.query("SELECT * FROM users");

        // Пользователь с ролью GUEST
        Database guestDatabase = new DatabaseProxy("GUEST");
        guestDatabase.query("SELECT * FROM users");
    }
}

// Subject: Интерфейс для работы с базой данных
interface Database {
    void query(String sql);
}

// RealSubject: Реальная база данных
class RealDatabase implements Database {
    @Override
    public void query(String sql) {
        System.out.println("Executing query: " + sql);
    }
}

// Proxy: Заместитель для контроля доступа
class DatabaseProxy implements Database {
    private final RealDatabase realDatabase;
    private final String userRole;

    public DatabaseProxy(String userRole) {
        this.realDatabase = new RealDatabase();
        this.userRole = userRole;
    }

    @Override
    public void query(String sql) {
        if (hasAccess()) {
            realDatabase.query(sql);
        } else {
            System.out.println("Access denied: User does not have sufficient privileges.");
        }
    }

    private boolean hasAccess() {
        return "ADMIN".equalsIgnoreCase(userRole);
    }
}
