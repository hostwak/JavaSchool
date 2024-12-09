package hm5.calculator;

public class CalculatorImpl implements Calculator {

    @Metric() // Аннотируем метод для измерения производительности
    public int calc(int arg) {
        return factorial(arg);
    }

    private int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}