package com.zhuravishkin.courses.design_patterns.behavioral.mediator.chat;

import java.util.ArrayList;
import java.util.List;

// Client
public class MediatorChatDemo {
    public static void main(String[] args) {
        // Создаём чат
        ChatMediator chatRoom = new ChatRoom();

        // Создаём пользователей
        User user1 = new ChatUser(chatRoom, "Alice");
        User user2 = new ChatUser(chatRoom, "Bob");
        User user3 = new ChatUser(chatRoom, "Charlie");

        // Добавляем пользователей в чат
        chatRoom.addUser(user1);
        chatRoom.addUser(user2);
        chatRoom.addUser(user3);

        // Пользователи отправляют сообщения
        user1.sendMessage("Hello, everyone!");
        user2.sendMessage("Hi Alice!");
        user3.sendMessage("Hey folks!");
    }
}

// Mediator: Интерфейс посредника
interface ChatMediator {
    void sendMessage(String message, User sender);

    void addUser(User user);
}

// ConcreteMediator: Сервер чата
class ChatRoom implements ChatMediator {
    private final List<User> users = new ArrayList<>();

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void sendMessage(String message, User sender) {
        for (User user : users) {
            // Отправляем сообщение всем, кроме отправителя
            if (user != sender) {
                user.receiveMessage(message, sender.getName());
            }
        }
    }
}

// Abstract Colleague: Пользователь
abstract class User {
    protected ChatMediator chatMediator;
    protected String name;

    public User(ChatMediator chatMediator, String name) {
        this.chatMediator = chatMediator;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void sendMessage(String message);

    public abstract void receiveMessage(String message, String senderName);
}

// ConcreteColleague: Конкретный пользователь
class ChatUser extends User {
    public ChatUser(ChatMediator chatMediator, String name) {
        super(chatMediator, name);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(name + " sends: " + message);
        chatMediator.sendMessage(message, this);
    }

    @Override
    public void receiveMessage(String message, String senderName) {
        System.out.println(name + " receives from " + senderName + ": " + message);
    }
}
