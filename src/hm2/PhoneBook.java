package hm2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    // Хранит фамилии и соответствующие им уникальные телефонные номера
    private Map<String, Set<String>> directory;

    // Конструктор
    public PhoneBook() {
        directory = new HashMap<>();
    }

    // Метод для добавления записи
    public void add(String lastName, String phoneNumber) {
        Set<String> numbers = directory.getOrDefault(lastName, new HashSet<>());
        numbers.add(phoneNumber);
        directory.put(lastName, numbers);
    }

    // Метод для получения номеров по фамилии
    public Set<String> get(String lastName) {
        return directory.getOrDefault(lastName, new HashSet<>());
    }

    // Метод для вывода всех записей (для тестирования)
    public void printAll() {
        for (Map.Entry<String, Set<String>> entry : directory.entrySet()) {
            System.out.println("Last Name: " + entry.getKey() + ", Numbers: " + entry.getValue());
        }
    }
}