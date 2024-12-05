
package hm4;

import hm4.exceptions.NotEnoughMoneyException;

public class TerminalServer {
    private int money; // Текущий баланс на счету

    public TerminalServer() {
        money = 0; // Инициализация баланса
    }

    // Положить на счет
    public void putMoney(int sum) throws IllegalArgumentException {
        validateAmount(sum); // Проверка суммы
        this.money += sum; // Увеличение баланса
    }

    // Снятие
    public void getMoney(int sum) throws IllegalArgumentException, NotEnoughMoneyException {
        validateAmount(sum); // Проверка суммы
        if (this.money < sum) {
            throw new NotEnoughMoneyException("Недостаточно средств для выполнения операции");
        }
        this.money -= sum; // Уменьшение баланса
    }

    // Проверка состояния счета
    public int getAccStatus() {
        return money; // Возврат текущего баланса
    }


    //Проверка корректности суммы.
    private void validateAmount(int amount) throws IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма должна быть больше нуля");
        }
        if (amount % 100 != 0) {
            throw new IllegalArgumentException("Сумма должна быть кратна 100");
        }
    }
}