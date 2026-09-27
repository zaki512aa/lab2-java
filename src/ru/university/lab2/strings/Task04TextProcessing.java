package ru.university.lab2.strings;

public class Task04TextProcessing {

    public void run() {
        checkPalindrome();
        reverseWords();
        countChars();
        caesarCipher();
        longestWord();
    }

    // проверяем палиндром ли строка
    private void checkPalindrome() {
        System.out.println("\n1. Проверка палиндрома:");

        String[] tests = {
            "А роза упала на лапу Азора",
            "Madam",
            "hello",
            "A man, a plan, a canal: Panama"
        };

        for (String test : tests) {
            boolean res = isPalindrome(test);
            System.out.println("\"" + test + "\" - " + res);
        }
    }

    private boolean isPalindrome(String str) {
        char[] chars = str.toLowerCase().toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            while (left < right && !isLetter(chars[left])) {
                left++;
            }
            while (left < right && !isLetter(chars[right])) {
                right--;
            }

            if (chars[left] != chars[right]) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    private boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'а' && c <= 'я') || c == 'ё';
    }

    // разворачиваем слова
    private void reverseWords() {
        System.out.println("\n2. разворот слов:");

        String text = "кот съел мышь";
        String result = reverse(text);
        System.out.println("было: \"" + text + "\"");
        System.out.println("стало: \"" + result + "\"");
    }

    private String reverse(String text) {
        String[] words = split(text);

        for (int i = 0; i < words.length / 2; i++) {
            String temp = words[i];
            words[i] = words[words.length - 1 - i];
            words[words.length - 1 - i] = temp;
        }

        return join(words);
    }

    private String[] split(String str) {
        int count = 0;
        boolean inWord = false;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                if (!inWord) {
                    count++;
                    inWord = true;
                }
            } else {
                inWord = false;
            }
        }

        String[] words = new String[count];
        int idx = 0;
        int start = 0;
        inWord = false;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                if (!inWord) {
                    start = i;
                    inWord = true;
                }
            } else {
                if (inWord) {
                    words[idx++] = str.substring(start, i);
                    inWord = false;
                }
            }
        }

        if (inWord) {
            words[idx] = str.substring(start);
        }

        return words;
    }

    private String join(String[] words) {
        if (words.length == 0) return "";

        StringBuilder sb = new StringBuilder();
        sb.append(words[0]);

        for (int i = 1; i < words.length; i++) {
            sb.append(" ");
            sb.append(words[i]);
        }

        return sb.toString();
    }

    // считаем символы
    private void countChars() {
        System.out.println("\n3. подсчет символов:");

        String text = "Hello World 123! Привет мир 456.";
        int[] counts = count(text);

        System.out.println("текст: \"" + text + "\"");
        System.out.println("гласные: " + counts[0]);
        System.out.println("согласные: " + counts[1]);
        System.out.println("цифры: " + counts[2]);
        System.out.println("пробелы: " + counts[3]);
    }

    private int[] count(String text) {
        int vowels = 0;
        int consonants = 0;
        int digits = 0;
        int spaces = 0;

        char[] chars = text.toLowerCase().toCharArray();

        for (char c : chars) {
            if (c == ' ') {
                spaces++;
            } else if (c >= '0' && c <= '9') {
                digits++;
            } else if (isVowel(c)) {
                vowels++;
            } else if (isConsonant(c)) {
                consonants++;
            }
        }

        return new int[]{vowels, consonants, digits, spaces};
    }

    private boolean isVowel(char c) {
        return "aeiouyаеёиоуыэюя".indexOf(c) != -1;
    }

    private boolean isConsonant(char c) {
        return ((c >= 'a' && c <= 'z') || (c >= 'а' && c <= 'я')) && !isVowel(c);
    }

    // шифр цезаря
    private void caesarCipher() {
        System.out.println("\n4. шифр Цезаря:");

        String text = "Hello World";
        int shift = 3;

        String encrypted = encrypt(text, shift);
        String decrypted = decrypt(encrypted, shift);

        System.out.println("исходный: \"" + text + "\"");
        System.out.println("зашифрованный (сдвиг " + shift + "): \"" + encrypted + "\"");
        System.out.println("расшифрованный: \"" + decrypted + "\"");
    }

    private String encrypt(String text, int shift) {
        return transform(text, shift);
    }

    private String decrypt(String text, int shift) {
        return transform(text, -shift);
    }

    private String transform(String text, int shift) {
        char[] result = new char[text.length()];

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c >= 'a' && c <= 'z') {
                int shifted = ((c - 'a' + shift) % 26 + 26) % 26;
                result[i] = (char) ('a' + shifted);
            } else if (c >= 'A' && c <= 'Z') {
                int shifted = ((c - 'A' + shift) % 26 + 26) % 26;
                result[i] = (char) ('A' + shifted);
            } else {
                result[i] = c;
            }
        }

        return new String(result);
    }

    // ищем самое длинное слово
    private void longestWord() {
        System.out.println("\n5. самое длинное слово:");

        String text = "Программирование на Java требует внимательности и терпения";
        String longest = findLongest(text);

        System.out.println("текст: \"" + text + "\"");
        System.out.println("самое длинное: \"" + longest + "\" (длина " + longest.length() + ")");
    }

    private String findLongest(String text) {
        String[] words = split(text);

        if (words.length == 0) return "";

        String longest = words[0];

        for (int i = 1; i < words.length; i++) {
            String clean = cleanWord(words[i]);
            String cleanLongest = cleanWord(longest);

            if (clean.length() > cleanLongest.length()) {
                longest = words[i];
            }
        }

        return longest;
    }

    private String cleanWord(String word) {
        char[] chars = word.toCharArray();
        char[] result = new char[chars.length];
        int pos = 0;

        for (char c : chars) {
            if (Character.isLetterOrDigit(c)) {
                result[pos++] = c;
            }
        }

        return new String(result, 0, pos);
    }
}
