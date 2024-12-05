
package hm4_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main {

    public static void readContent(String url) {
        try {
            URL website = new URL(url);

            try (BufferedReader in = new BufferedReader(new InputStreamReader(website.openStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    System.out.println(inputLine);
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении содержимого: " + e.getMessage());
        }
    }

    static void task2() {
        Scanner scanner = new Scanner(System.in);
        String url;

        while (true) {
            System.out.print("Введите URL адрес страницы: ");
            url = scanner.nextLine();

            try {
                // Проверяем корректность URL
                new URL(url);
                readContent(url);
                break; // Выходим
            } catch (MalformedURLException e) {
                System.err.println("Некорректный URL. Пожалуйста, попробуйте еще раз.");
            } catch (IOException e) {
                System.err.println("Ошибка при чтении содержимого: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        task2();
    }
}