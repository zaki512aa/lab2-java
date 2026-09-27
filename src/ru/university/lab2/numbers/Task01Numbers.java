package ru.university.lab2.numbers;

public class Task01Numbers {

    public void run() {
        showMinMax();
        overflowDemo();
        multiplicationDemo();
        divisionDemo();
        castDemo();
        charDemo();
        checkOverflow();
    }

    // показываем диапазоны типов
    private void showMinMax() {
        System.out.println("\n1. Диапазоны целочисленных типов:");
        System.out.println("byte:  " + Byte.MIN_VALUE + " .. " + Byte.MAX_VALUE);
        System.out.println("short: " + Short.MIN_VALUE + " .. " + Short.MAX_VALUE);
        System.out.println("int:   " + Integer.MIN_VALUE + " .. " + Integer.MAX_VALUE);
        System.out.println("long:  " + Long.MIN_VALUE + " .. " + Long.MAX_VALUE);
        // byte - 8 бит, short - 16, int - 32, long - 64
    }

    // что будет если прибавить 1 к максимуму
    private void overflowDemo() {
        System.out.println("\n2. переполнение:");
        int max = Integer.MAX_VALUE;
        int result = max + 1;
        System.out.println("Integer.MAX_VALUE = " + max);
        System.out.println("Integer.MAX_VALUE + 1 = " + result);
        // переполняется и становится отрицательным числом
        // типа заворачивается обратно на минимум
    }

    // умножение в разных типах
    private void multiplicationDemo() {
        System.out.println("\n3. умножение Integer.MAX_VALUE * 2:");
        int max = Integer.MAX_VALUE;

        int resInt = max * 2;
        System.out.println("в int: " + resInt);
        // умножается в int и переполняется

        long resLong = (long) max * 2;
        System.out.println("в long: " + resLong);
        // тут нормально потому что сначала приводим к long
        // важно приводить до умножения а не после!
    }

    // деление и остаток
    private void divisionDemo() {
        System.out.println("\n4. деление и остаток:");
        System.out.println("5 / 2 = " + (5 / 2));
        System.out.println("-5 / 2 = " + (-5 / 2));
        System.out.println("5 % 2 = " + (5 % 2));
        System.out.println("-5 % 2 = " + (-5 % 2));
        // дробная часть просто отбрасывается
        // знак остатка такой же как у первого числа
    }

    // что если long не влезает в int
    private void castDemo() {
        System.out.println("\n5. приведение long к int:");
        long big = Integer.MAX_VALUE + 1000L;
        int small = (int) big;
        System.out.println("было long: " + big);
        System.out.println("стало int: " + small);
        // отбрасываются старшие биты, результат странный
    }

    // char это тоже число
    private void charDemo() {
        System.out.println("\n6. арифметика с char:");
        char letter = 'A';
        char next = (char) (letter + 1);
        System.out.println("буква: " + letter + ", следующая: " + next);

        char a = 'Z';
        char b = 'A';
        int sum = a + b;
        System.out.println("'Z' + 'A' = " + sum);
        System.out.println("как символ: " + (char) sum);
        // char это просто число от 0 до 65535
        // 'A' = 65, 'Z' = 90
    }

    // проверяем было ли переполнение
    private void checkOverflow() {
        System.out.println("\n7. проверка переполнения:");

        int a1 = Integer.MAX_VALUE;
        int b1 = 100;
        System.out.println(a1 + " + " + b1 + ": переполнение = " + hasOverflow(a1, b1));

        int a2 = 1000;
        int b2 = 2000;
        System.out.println(a2 + " + " + b2 + ": переполнение = " + hasOverflow(a2, b2));

        int a3 = Integer.MIN_VALUE;
        int b3 = -100;
        System.out.println(a3 + " + " + b3 + ": переполнение = " + hasOverflow(a3, b3));
    }

    private boolean hasOverflow(int a, int b) {
        int sum = a + b;

        // если оба положительные а сумма отрицательная - переполнение
        if (a > 0 && b > 0 && sum < 0) {
            return true;
        }

        // если оба отрицательные а сумма положительная - тоже переполнение
        if (a < 0 && b < 0 && sum > 0) {
            return true;
        }

        return false;
    }
}
