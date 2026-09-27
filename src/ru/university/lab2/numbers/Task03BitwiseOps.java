package ru.university.lab2.numbers;

public class Task03BitwiseOps {

    public void run() {
        bitwiseOps();
        shiftDiff();
        utilMethods();
        xorSwap();
    }

    // побитовые операторы
    private void bitwiseOps() {
        System.out.println("\n1. побитовые операции:");

        int a = 12;  // 1100
        int b = 10;  // 1010

        System.out.println("a = " + a + " (" + Integer.toBinaryString(a) + ")");
        System.out.println("b = " + b + " (" + Integer.toBinaryString(b) + ")");
        System.out.println();

        System.out.println("a & b  = " + (a & b) + " (" + Integer.toBinaryString(a & b) + ")");
        // AND - оба бита 1

        System.out.println("a | b  = " + (a | b) + " (" + Integer.toBinaryString(a | b) + ")");
        // OR - хотя бы один 1

        System.out.println("a ^ b  = " + (a ^ b) + " (" + Integer.toBinaryString(a ^ b) + ")");
        // XOR - биты разные

        System.out.println("~a     = " + (~a) + " (" + Integer.toBinaryString(~a) + ")");
        // NOT - инвертирует все биты

        System.out.println("a << 2 = " + (a << 2) + " (" + Integer.toBinaryString(a << 2) + ")");
        // сдвиг влево = умножение на 2

        System.out.println("a >> 2 = " + (a >> 2) + " (" + Integer.toBinaryString(a >> 2) + ")");
        // сдвиг вправо = деление на 2

        int c = -8;
        System.out.println("\nc = " + c + " (" + Integer.toBinaryString(c) + ")");
        System.out.println("c >>> 2 = " + (c >>> 2) + " (" + Integer.toBinaryString(c >>> 2) + ")");
    }

    // разница между >> и >>>
    private void shiftDiff() {
        System.out.println("\n2. >> vs >>>:");

        int num = -16;
        System.out.println("число: " + num);
        System.out.println("двоичное: " + Integer.toBinaryString(num));

        int a = num >> 2;
        int b = num >>> 2;

        System.out.println("\n>> (арифметический): " + a);
        System.out.println("двоичное: " + Integer.toBinaryString(a));
        // >> сохраняет знак, заполняет слева единицами для отрицательных

        System.out.println("\n>>> (логический): " + b);
        System.out.println("двоичное: " + Integer.toBinaryString(b));
        // >>> всегда заполняет нулями, не смотрит на знак
    }

    // полезные методы
    private void utilMethods() {
        System.out.println("\n3. полезные методы:");

        System.out.println("четность:");
        System.out.println("  4: " + isEven(4));
        System.out.println("  7: " + isEven(7));

        System.out.println("\nстепень двойки:");
        System.out.println("  16: " + isPowerOfTwo(16));
        System.out.println("  15: " + isPowerOfTwo(15));
        System.out.println("  0: " + isPowerOfTwo(0));

        System.out.println("\nединичные биты:");
        System.out.println("  7: " + countBits(7));
        System.out.println("  15: " + countBits(15));
        System.out.println("  255: " + countBits(255));
    }

    private boolean isEven(int n) {
        // младший бит четного числа = 0
        return (n & 1) == 0;
    }

    private boolean isPowerOfTwo(int n) {
        // степень 2 имеет только один бит = 1
        // 8 = 1000, 7 = 0111, 8&7 = 0
        return n > 0 && (n & (n - 1)) == 0;
    }

    private int countBits(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);  // убирает самый правый единичный бит
        }
        return count;
    }

    // обмен без temp переменной
    private void xorSwap() {
        System.out.println("\n4. Обмен через XOR:");

        int x = 5;
        int y = 9;
        System.out.println("до: x = " + x + ", y = " + y);

        x = x ^ y;
        y = x ^ y;  // теперь y = x
        x = x ^ y;  // теперь x = y

        System.out.println("после: x = " + x + ", y = " + y);
        // работает потому что a^a=0 и a^0=a
        // но лучше так не делать в реальном коде
    }
}
