package hm5;

import hm5.calculator.Calculator;
import hm5.calculator.CalculatorImpl;
import hm5.calculator.PerfomanceProxy;

import java.lang.reflect.Field;

public class Main {


    public static class DayConstants {
        public static final String MONDAY = "MONDAY";
        public static final String TUESDAY = "TUESDAY";
        public static final String WEDNESDAY = "WEDNESDAY";
        public static final String THURSDAY = "THURSDAY";
        public static final String FRIDAY = "FRIDAY";
        public static final String SATURDAY = "SATURDAY";
        public static final String SUNDAY = "SUNDAY";
    }

    static void task1() throws NoSuchMethodException {
        Calculator calculator = new CalculatorImpl();
        run(calculator);
    }

    public static void run(Calculator calculator) throws NoSuchMethodException {
        System.out.println(calculator.calc(5));
    }

    public static void main(String[] args) throws NoSuchMethodException { // Исправлено на main
        task1();
        task6();
        task4();
    }

    static void task6() {
        CalculatorImpl calculator = new CalculatorImpl();

        // Тут оберенем в прокси
        PerfomanceProxy performanceProxy = new PerfomanceProxy(calculator);

        // Вызываем
        try {
            int ravno = performanceProxy.calc(5); // Пример аргумента
            System.out.println("Результат: " + ravno);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    static void task4() {
        checkConstants(DayConstants.class);
    }

    public static void checkConstants(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            // Проверяем, является ли поле строкой (вроде как))
            if (field.getType() == String.class &&
                    java.lang.reflect.Modifier.isStatic(field.getModifiers()) &&
                    java.lang.reflect.Modifier.isFinal(field.getModifiers())) {
                try {
                    String value = (String) field.get(null);
                    if (!field.getName().equals(value)) {
                        System.out.println("Константа " + field.getName() + " имеет значение " + value + ", не совпадающее с именем.");
                    } else {
                        System.out.println("Константа " + field.getName() + " имеет правильное значение.");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace(); // Обработка исключения доступа к полю
                }
            }
        }
    }
}