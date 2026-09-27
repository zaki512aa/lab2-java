package ru.university.lab2.util;

public class Task07Methods {

    public void run() {
        overloadingDemo();
        varargsDemo();
        powerDemo();
    }

    // перегрузка
    private void overloadingDemo() {
        System.out.println("\n1. перегрузка методов:");

        print(42);
        print(3.14);
        print("привет");
        print(new int[]{1, 2, 3, 4, 5});
    }

    private void print(int val) {
        System.out.println("print(int): " + val);
    }

    private void print(double val) {
        System.out.println("print(double): " + val);
    }

    private void print(String val) {
        System.out.println("print(String): " + val);
    }

    private void print(int[] arr) {
        System.out.print("print(int[]): [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // varargs
    private void varargsDemo() {
        System.out.println("\n2. varargs:");

        System.out.println("sum() = " + sum());
        System.out.println("sum(1, 2, 3, 4, 5) = " + sum(1, 2, 3, 4, 5));

        int[] nums = {10, 20, 30, 40};
        System.out.println("sum(массив) = " + sum(nums));
    }

    private int sum(int... numbers) {
        int total = 0;
        for (int n : numbers) {
            total += n;
        }
        return total;
    }

    // степень рекурсивно и итеративно
    private void powerDemo() {
        System.out.println("\n3. возведение в степень:");

        int base = 2;
        int[] exps = {0, 1, 5, 10};

        System.out.println("основание: " + base);
        System.out.println();

        for (int exp : exps) {
            long rec = powerRec(base, exp);
            long iter = powerIter(base, exp);
            double math = Math.pow(base, exp);

            System.out.println("степень " + exp + ":");
            System.out.println("  рекурсивно: " + rec);
            System.out.println("  итеративно: " + iter);
            System.out.println("  Math.pow: " + math);
            System.out.println("  одинаково: " + (rec == iter && rec == (long) math));
            System.out.println();
        }

        // почему итеративная быстрее
        System.out.println("--- почему итеративная быстрее ---");
        System.out.println();
        System.out.println("рекурсивная версия:");
        System.out.println("- каждый вызов создает новый фрейм в стеке");
        System.out.println("- надо сохранять параметры и адрес возврата");
        System.out.println("- для степени n будет n вызовов функции");
        System.out.println("- занимает O(n) памяти в стеке");
        System.out.println();
        System.out.println("итеративная версия:");
        System.out.println("- один фрейм в стеке");
        System.out.println("- переменные переиспользуются");
        System.out.println("- нет накладных расходов на вызовы");
        System.out.println("- занимает O(1) памяти");
        System.out.println();
        System.out.println("вывод: итеративная быстрее и безопаснее");
        System.out.println("(рекурсивная может упасть с StackOverflowError на больших степенях)");
    }

    // рекурсивная
    private long powerRec(int base, int exp) {
        if (exp == 0) return 1;
        if (exp == 1) return base;
        return base * powerRec(base, exp - 1);
    }

    // итеративная
    private long powerIter(int base, int exp) {
        long result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }
}
