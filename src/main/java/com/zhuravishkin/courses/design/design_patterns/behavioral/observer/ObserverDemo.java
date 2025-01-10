package com.zhuravishkin.courses.design.design_patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

// Client
public class ObserverDemo {
    public static void main(String[] args) {
        // Создаём издателя
        NewsPublisher newsPublisher = new NewsPublisher();

        // Создаём подписчиков
        Observer emailSubscriber = new EmailSubscriber("user@example.com");
        Observer smsSubscriber = new SmsSubscriber("+123456789");

        // Регистрируем подписчиков
        newsPublisher.addObserver(emailSubscriber);
        newsPublisher.addObserver(smsSubscriber);

        // Публикуем новости
        newsPublisher.publishNews("Breaking News: Observer pattern implemented!");
        newsPublisher.publishNews("Another update: Design patterns are awesome!");
    }
}

// Observer: Интерфейс для подписчиков
interface Observer {
    void update(String news);
}

// Subject: Интерфейс для издателя
interface Subject {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

// ConcreteSubject: Издатель новостей
class NewsPublisher implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private String latestNews;

    public void publishNews(String news) {
        this.latestNews = news;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(latestNews);
        }
    }
}

// ConcreteObserver: Подписчик
class EmailSubscriber implements Observer {
    private final String email;

    public EmailSubscriber(String email) {
        this.email = email;
    }

    @Override
    public void update(String news) {
        System.out.println("Email to " + email + ": " + news);
    }
}

// ConcreteObserver: Подписчик через SMS
class SmsSubscriber implements Observer {
    private final String phoneNumber;

    public SmsSubscriber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void update(String news) {
        System.out.println("SMS to " + phoneNumber + ": " + news);
    }
}
