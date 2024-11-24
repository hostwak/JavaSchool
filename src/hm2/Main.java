package hm2;

import javax.naming.Name;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Массив с повторами слов.
        String[] names = {
                "anton", "vadim", "sveta", "nastya",
                "anton", "jora", "artem", "vadim"
        };
        Map<String, Integer> namesCount = new HashMap <>();

        for (String item : names) {
            if (namesCount.containsKey(item)) {
                namesCount.put(item, namesCount.get(item) + 1);
            } else {
                namesCount.put(item, 1);
            }
        }
        System.out.println("Задача 1");
        System.out.println("количество уникальных слов = " + namesCount.size());
        System.out.println("уникальные слова " + namesCount.keySet());
        System.out.println("сколько раз встрeчается каждое слово " + namesCount);


        System.out.println("Задача 2");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Ivanov", "89182344541");
        phoneBook.add("Ivanov", "89182314123");
        phoneBook.add("Ivanov", "89182314123"); // Дубликат, не будет добавлен
        phoneBook.add("Petrov", "89885555555");
        phoneBook.add("Sidorov", "87162399131");

        // Получение номеров по фамилии
        System.out.println("Numbers for Ivanov: " + phoneBook.get("Ivanov"));
        System.out.println("Numbers for Petrov: " + phoneBook.get("Petrov"));

        // Вывод всех записей
        System.out.println("\nAll records:");
        phoneBook.printAll();
    }


}