package ru.university.lab2;

import ru.university.lab2.numbers.Task01Numbers;
import ru.university.lab2.numbers.Task02FloatingPoint;
import ru.university.lab2.numbers.Task03BitwiseOps;
import ru.university.lab2.strings.Task04TextProcessing;
import ru.university.lab2.arrays.Task05Arrays;
import ru.university.lab2.arrays.Task06Matrices;
import ru.university.lab2.util.Task07Methods;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            showMenu();

            if (!sc.hasNextInt()) {
                System.out.println("ошибка: введите число от 1 до 7 или 0 для выхода");
                sc.next();
                continue;
            }

            int choice = sc.nextInt();

            String result = switch (choice) {
                case 0 -> {
                    System.out.println("выход");
                    sc.close();
                    yield "exit";
                }
                case 1 -> {
                    System.out.println("\n=== Задание 1: целочисленные типы ===");
                    new Task01Numbers().run();
                    yield "continue";
                }
                case 2 -> {
                    System.out.println("\n=== задание 2: вещественные числа ===");
                    new Task02FloatingPoint().run();
                    yield "continue";
                }
                case 3 -> {
                    System.out.println("\n=== задание 3: побитовые операции ===");
                    new Task03BitwiseOps().run();
                    yield "continue";
                }
                case 4 -> {
                    System.out.println("\n=== задание 4: работа со строками ===");
                    new Task04TextProcessing().run();
                    yield "continue";
                }
                case 5 -> {
                    System.out.println("\n=== задание 5: массивы ===");
                    new Task05Arrays().run();
                    yield "continue";
                }
                case 6 -> {
                    System.out.println("\n=== задание 6: матрицы ===");
                    new Task06Matrices().run();
                    yield "continue";
                }
                case 7 -> {
                    System.out.println("\n=== задание 7: методы ===");
                    new Task07Methods().run();
                    yield "continue";
                }
                default -> {
                    System.out.println("неверный выбор, попробуйте еще раз");
                    yield "continue";
                }
            };

            if (result.equals("exit")) {
                break;
            }

            System.out.println();
        }
    }

    private static void showMenu() {
        String menu = """

                ╔════════════════════════════════════════════════════════╗
                ║          лабораторная работа 2 - основы java           ║
                ╠════════════════════════════════════════════════════════╣
                ║  1. целочисленные типы                                ║
                ║  2. вещественные числа                                ║
                ║  3. побитовые операции                                ║
                ║  4. работа со строками                                ║
                ║  5. массивы                                           ║
                ║  6. матрицы                                           ║
                ║  7. методы                                            ║
                ║  0. выход                                             ║
                ╚════════════════════════════════════════════════════════╝

                выберите задание:""";

        System.out.print(menu + " ");
    }
}
