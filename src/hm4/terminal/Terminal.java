
package hm4.terminal;

import hm4.exceptions.IncorrectSumException;
import hm4.exceptions.NotEnoughMoneyException;
import hm4.exceptions.IncorrectSumException;
import hm4.exceptions.NotEnoughMoneyException;

public interface Terminal {
    void StartWork();

    void getMoney(int sum) throws NotEnoughMoneyException, IncorrectSumException, NotEnoughMoneyException;

    void putMoney(int sum) throws IncorrectSumException, IncorrectSumException;

    void check();
}