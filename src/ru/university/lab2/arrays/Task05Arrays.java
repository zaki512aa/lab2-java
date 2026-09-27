package ru.university.lab2.arrays;

import java.util.Arrays;

public class Task05Arrays {

    public void run() {
        int[] numbers = createRandomArray(10);
        System.out.println("\nCозданный массив: " + arrayToString(numbers));

        findStats(numbers);
        sortArray(numbers);
        compareArrays();
    }

    // создаем массив случайных чисел
    private int[] createRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        return array;
    }

    // ищем минимум, максимум и среднее
    private void findStats(int[] array) {
        System.out.println("\nстатистика:");

        if (array.length == 0) {
            System.out.println("массив пустой");
            return;
        }

        int min = array[0];
        int max = array[0];
        long sum = 0;

        for (int value : array) {
            if (value < min) {
                min = value;
            }
            if (value > max) {
                max = value;
            }
            sum += value;
        }

        double avg = (double) sum / array.length;

        System.out.println("минимум: " + min);
        System.out.println("максимум: " + max);
        System.out.println("среднее: " + avg);
    }

    // сортируем массив
    private void sortArray(int[] array) {
        System.out.println("\nсортировка:");
        System.out.println("до: " + arrayToString(array));

        // использую сортировку выбором, она простая
        // на каждом шаге ищем минимум и ставим его на место
        for (int i = 0; i < array.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }

            if (minIdx != i) {
                int temp = array[i];
                array[i] = array[minIdx];
                array[minIdx] = temp;
            }
        }

        System.out.println("после: " + arrayToString(array));
    }

    // сравниваем массивы разными способами
    private void compareArrays() {
        System.out.println("\nсравнение массивов:");

        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 4, 5};
        int[] arr3 = arr1;

        System.out.println("arr1: " + arrayToString(arr1));
        System.out.println("arr2: " + arrayToString(arr2));
        System.out.println("arr3 = arr1");
        System.out.println();

        // проверяем через ==
        System.out.println("arr1 == arr2: " + (arr1 == arr2));
        System.out.println("arr1 == arr3: " + (arr1 == arr3));
        // == сравнивает ссылки, а не содержимое
        // arr1 и arr2 это разные объекты, хотя элементы одинаковые
        // arr3 это та же ссылка что и arr1

        System.out.println();

        // пробуем equals
        System.out.println("arr1.equals(arr2): " + arr1.equals(arr2));
        System.out.println("arr1.equals(arr3): " + arr1.equals(arr3));
        // equals для массивов работает так же как ==
        // то есть сравнивает ссылки

        System.out.println();

        // правильный способ
        System.out.println("Arrays.equals(arr1, arr2): " + Arrays.equals(arr1, arr2));
        System.out.println("Arrays.equals(arr1, arr3): " + Arrays.equals(arr1, arr3));
        // Arrays.equals сравнивает именно элементы
        // это правильный способ проверить одинаковое ли содержимое
    }

    // выводим массив красиво
    private String arrayToString(int[] array) {
        if (array.length == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        sb.append(array[0]);

        for (int i = 1; i < array.length; i++) {
            sb.append(", ");
            sb.append(array[i]);
        }

        sb.append("]");
        return sb.toString();
    }
}
