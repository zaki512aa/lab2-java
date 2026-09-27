package ru.university.lab2.numbers;

public class Task02FloatingPoint {

    public void run() {
        precisionProblem();
        accumulationError();
        epsilonCompare();
        specialValues();
        roundingMethods();
        floatVsDouble();
    }

    // почему 0.1 + 0.2 не равно 0.3
    private void precisionProblem() {
        System.out.println("\n1. точность вещественных чисел:");
        double res = 0.1 + 0.2;
        System.out.println("0.1 + 0.2 = " + res);
        System.out.println("равно 0.3? " + (res == 0.3));
        // в двоичной системе эти числа бесконечные дроби
        // типа как 1/3 = 0.333... в десятичной
        // поэтому получается не точно 0.3
    }

    // накапливается ошибка
    private void accumulationError() {
        System.out.println("\n2. накопление ошибки:");
        double sum = 0.0;
        for (int i = 0; i < 10; i++) {
            sum += 0.1;
        }
        System.out.println("0.1 десять раз: " + sum);
        System.out.println("равно 1.0? " + (sum == 1.0));
        // с каждым сложением ошибка накапливается
    }

    // правильное сравнение
    private void epsilonCompare() {
        System.out.println("\n3. правильное сравнение:");
        double a = 0.1 + 0.2;
        double b = 0.3;
        double eps = 1e-9;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("a == b: " + (a == b));
        System.out.println("почти равны: " + almostEqual(a, b, eps));
        // надо проверять что разница меньше чем epsilon
    }

    private boolean almostEqual(double a, double b, double epsilon) {
        return Math.abs(a - b) < epsilon;
    }

    // бесконечность и NaN
    private void specialValues() {
        System.out.println("\n4. специальные значения:");

        double inf = 1.0 / 0.0;
        double minusInf = -1.0 / 0.0;
        double nan = 0.0 / 0.0;

        System.out.println("1.0 / 0.0 = " + inf);
        System.out.println("-1.0 / 0.0 = " + minusInf);
        System.out.println("0.0 / 0.0 = " + nan);
        System.out.println("NaN == NaN: " + (nan == nan));
        // NaN не равен самому себе! это особенность стандарта

        System.out.println("\nеще примеры:");
        System.out.println("Math.log(-1) = " + Math.log(-1));
        System.out.println("Math.sqrt(-1) = " + Math.sqrt(-1));
    }

    // разные способы округления
    private void roundingMethods() {
        System.out.println("\n5. округление:");

        double pos = 2.7;
        double neg = -2.7;

        System.out.println("число: " + pos);
        System.out.println("  (int): " + (int) pos);
        System.out.println("  round: " + Math.round(pos));
        System.out.println("  floor: " + Math.floor(pos));
        System.out.println("  ceil: " + Math.ceil(pos));

        System.out.println("\nчисло: " + neg);
        System.out.println("  (int): " + (int) neg);
        System.out.println("  round: " + Math.round(neg));
        System.out.println("  floor: " + Math.floor(neg));
        System.out.println("  ceil: " + Math.ceil(neg));

        // (int) - просто отбрасывает дробную часть
        // round - к ближайшему целому
        // floor - вниз
        // ceil - вверх
    }

    // float менее точный чем double
    private void floatVsDouble() {
        System.out.println("\n6. float vs double:");

        float floatSum = 0.0f;
        double doubleSum = 0.0;

        for (int i = 0; i < 1000000; i++) {
            floatSum += 0.0001f;
            doubleSum += 0.0001;
        }

        System.out.println("float:  " + floatSum + " (должно быть 100.0)");
        System.out.println("double: " + doubleSum + " (должно быть 100.0)");
        System.out.println("ошибка float:  " + Math.abs(floatSum - 100.0));
        System.out.println("ошибка double: " + Math.abs(doubleSum - 100.0));
        // float - 32 бита, примерно 7 знаков точности
        // double - 64 бита, примерно 15-16 знаков
    }
}
