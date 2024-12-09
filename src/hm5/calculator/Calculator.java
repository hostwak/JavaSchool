package hm5.calculator;

public interface Calculator {
    @Metric
    int calc(int number) throws NoSuchMethodException;
}
