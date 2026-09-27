package ru.university.lab2.arrays;

public class Task06Matrices {

    public void run() {
        int[][] matrix = createMatrix(4, 5);
        System.out.println("\n1. матрица:");
        printMatrix(matrix);

        int[][] transposed = transpose(matrix);
        System.out.println("\n2. транспонированная:");
        printMatrix(transposed);

        multiplyDemo();
    }

    // создаем матрицу
    private int[][] createMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        int val = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = val++;
            }
        }

        return matrix;
    }

    // выводим красиво
    private void printMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            System.out.println("[]");
            return;
        }

        // ищем макс ширину
        int maxWidth = 0;
        for (int[] row : matrix) {
            for (int val : row) {
                int width = String.valueOf(val).length();
                if (width > maxWidth) {
                    maxWidth = width;
                }
            }
        }

        // выводим с выравниванием
        for (int[] row : matrix) {
            System.out.print("[ ");
            for (int j = 0; j < row.length; j++) {
                System.out.printf("%" + maxWidth + "d", row[j]);
                if (j < row.length - 1) {
                    System.out.print("  ");
                }
            }
            System.out.println(" ]");
        }
    }

    // транспонируем
    private int[][] transpose(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0][0];
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }

    // умножаем матрицы
    private void multiplyDemo() {
        System.out.println("\n3. умножение:");

        int[][] a = {
            {1, 2, 3},
            {4, 5, 6}
        }; // 2x3

        int[][] b = {
            {7, 8},
            {9, 10},
            {11, 12}
        }; // 3x2

        System.out.println("матрица A (2x3):");
        printMatrix(a);

        System.out.println("\nматрица B (3x2):");
        printMatrix(b);

        int[][] result = multiply(a, b);
        if (result != null) {
            System.out.println("\nрезультат A × B:");
            printMatrix(result);
        }

        // пробуем несогласованные
        System.out.println("\n--- несогласованные матрицы ---");
        int[][] c = {
            {1, 2},
            {3, 4}
        };

        System.out.println("матрица C (2x2):");
        printMatrix(c);

        System.out.println("\nпопытка B × C:");
        multiply(b, c);
    }

    private int[][] multiply(int[][] a, int[][] b) {
        if (a.length == 0 || b.length == 0) {
            System.out.println("ошибка: пустая матрица");
            return null;
        }

        int aRows = a.length;
        int aCols = a[0].length;
        int bRows = b.length;
        int bCols = b[0].length;

        // проверяем размеры
        if (aCols != bRows) {
            System.out.println("ошибка: нельзя умножить");
            System.out.println("столбцов в первой (" + aCols +
                             ") должно быть столько же сколько строк во второй (" + bRows + ")");
            return null;
        }

        int[][] result = new int[aRows][bCols];

        // умножаем
        for (int i = 0; i < aRows; i++) {
            for (int j = 0; j < bCols; j++) {
                int sum = 0;
                for (int k = 0; k < aCols; k++) {
                    sum += a[i][k] * b[k][j];
                }
                result[i][j] = sum;
            }
        }

        return result;
    }
}
