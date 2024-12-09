package hm5.calculator;

import lombok.RequiredArgsConstructor;

import java.lang.reflect.Method;

@RequiredArgsConstructor
public class PerfomanceProxy implements Calculator {

    public PerfomanceProxy(CalculatorImpl calculator) {
        this.calculator = calculator;
    }

    private final CalculatorImpl calculator;

    @Override
    public int calc(int number) throws NoSuchMethodException {
        Method method = calculator.getClass().getMethod("calc", int.class);


        if (method.isAnnotationPresent(Metric.class)) {
            Metric metric = method.getAnnotation(Metric.class);
            if (metric.value()) {
                long startTime = System.nanoTime();
                int result = calculator.calc(number);
                long endTime = System.nanoTime();


                System.out.printf("Время работы метода: %d наносекунд\n", endTime - startTime);
                return result; // Возвращаем результат
            }
        }


        return calculator.calc(number);
    }
}