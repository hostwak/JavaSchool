
package hm4;

import javax.security.auth.login.AccountLockedException;
import java.util.Scanner;

public class PinValidator {
    private final String pinCode = "7777"; // Правильный PIN-код
    private int countErrors; // Счетчик ошибок
    private long lockTime; // Время блокировки
    private static final int MAX_ATTEMPTS = 3; // Максимальное количество попыток
    private static final long LOCK_DURATION = 10000; // Длительность блокировки в миллисекундах (10 секунд)

    public PinValidator() {
        lockTime = 0;
        countErrors = 0;
    }

    private boolean isBlocked() throws AccountLockedException {
        if (lockTime > 0) {
            if (System.currentTimeMillis() < lockTime) {
                throw new AccountLockedException("Терминал заблокирован");
            } else {
                // Сброс времени блокировки, если срок истек
                lockTime = 0;
            }
        }
        return false;
    }

    public boolean inputPassword() throws AccountLockedException {
        Scanner scanner = new Scanner(System.in);
        StringBuilder pin = new StringBuilder();

        System.out.println("Введите пин-код по-символьно");

        while (true) {
            try {
                isBlocked(); // Проверка блокировки перед каждой попыткой ввода

                String current = scanner.next();

                if (!Character.isDigit(current.charAt(0))) {
                    System.err.println("Вводите только цифровые символы");
                    continue; // Пропускаем итерацию, если введен неверный символ
                }

                pin.append(current);

                if (pin.length() == 4) { // Проверка после ввода 4 символов
                    if (pin.toString().equals(pinCode)) {
                        System.out.println("Пин-код принят!");
                        countErrors = 0; // Сброс ошибок
                        return true; // Успешный ввод
                    } else {
                        countErrors++;
                        System.err.println(String.format("Неверно введен пин-код, попыток осталось %d", MAX_ATTEMPTS - countErrors));
                        pin.setLength(0); // Очистка введенного PIN-кода

                        if (countErrors >= MAX_ATTEMPTS) {
                            System.out.println("Блокировка на 10 секунд");
                            lockTime = System.currentTimeMillis() + LOCK_DURATION; // Установка времени блокировки
                            countErrors = 0; // Сброс ошибок после блокировки
                        }
                    }
                }
            } catch (AccountLockedException e) {
                System.err.println(e.getMessage());
                try {
                    Thread.sleep(LOCK_DURATION); // Ожидание окончания блокировки
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt(); // Восстановление прерывания потока
                }
            }
        }
    }
}