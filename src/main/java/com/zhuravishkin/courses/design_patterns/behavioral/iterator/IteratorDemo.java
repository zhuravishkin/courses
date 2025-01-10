package com.zhuravishkin.courses.design_patterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.List;

// Client
public class IteratorDemo {
    public static void main(String[] args) {
        // Создаем коллекцию
        NameCollection nameCollection = new NameCollection();
        nameCollection.addName("John");
        nameCollection.addName("Mary");
        nameCollection.addName("Steve");

        // Получаем итератор
        Iterator<String> iterator = nameCollection.getIterator();

        // Обходим элементы
        while (iterator.hasNext()) {
            System.out.println("Name: " + iterator.next());
        }
    }
}

// Iterator: Интерфейс для итератора
interface Iterator<T> {
    boolean hasNext();

    T next();
}

// ConcreteIterator: Итератор для списка
class NameIterator implements Iterator<String> {
    private final List<String> names;
    private int index = 0;

    public NameIterator(List<String> names) {
        this.names = names;
    }

    @Override
    public boolean hasNext() {
        return index < names.size();
    }

    @Override
    public String next() {
        if (hasNext()) {
            return names.get(index++);
        }
        return null;
    }
}

// Aggregate: Интерфейс коллекции
interface IterableCollection<T> {
    Iterator<T> getIterator();
}

// ConcreteAggregate: Коллекция имен
class NameCollection implements IterableCollection<String> {
    private final List<String> names = new ArrayList<>();

    public void addName(String name) {
        names.add(name);
    }

    @Override
    public Iterator<String> getIterator() {
        return new NameIterator(names);
    }
}
