package ru.itmo.java;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if (inputArray == null) {
            return new int[0];
        } else if (inputArray.length == 0) {
            return inputArray;
        }

        int last = inputArray[inputArray.length - 1];
        for (int i = inputArray.length - 1; i > 0; i--) {
            inputArray[i] = inputArray[i - 1];
        }
        inputArray[0] = last;

        return inputArray;
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     *
     * Если входной массив пуст или равен null - вернуть 0
     *
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return 0;
        }

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i : inputArray) {
            if (i < min1) {
                min2 = min1;
                min1 = i;
            } else if (i < min2) {
                min2 = i;
            }

            if (i > max1) {
                max2 = max1;
                max1 = i;
            } else if (i > max2) {
                max2 = i;
            }
        }

        return Math.max(max1 * max2, min1 * min2);
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     *
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if (input == null) {
            return 0;
        }
        int count = 0;
        for (char i : input.toCharArray()) {
            char lowerCase = Character.toLowerCase(i);
            if (lowerCase == 'a' || lowerCase == 'b') {
                count++;
            }
        }

        return (int) (count / (float) input.length() * 100);
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        } else if (input.length() == 0) {
            return true;
        }

        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if (input == null || input.length() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();

        char ch = input.charAt(0);
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ch) {
                count++;
            } else {
                stringBuilder.append(ch);
                stringBuilder.append(count);
                count = 1;
                ch = input.charAt(i);
            }
        }

        stringBuilder.append(ch);
        stringBuilder.append(count);

        return stringBuilder.toString();

    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if (one == null || two == null || one.length() == 0 || two.length() == 0) {
            return false;
        }
        int[] a = new int[255];
        int[] b = new int[255];

        for (char i : one.toCharArray()) {
            a[i]++;
        }
        for (char i : two.toCharArray()) {
            b[i]++;
        }

        for (int i = 0; i < 255; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        boolean[] a = new boolean[255];
        for (char i : s.toCharArray()) {
            if (a[i]) {
                return false;
            }
            a[i] = true;
        }

        return true;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     *
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if (m == null) {
            return new int[2][0];
        } else if (m.length == 0 || m[0].length == 0) {
            return m;
        }

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < i; j++) {
                int x = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = x;
            }
        }

        return m;
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     *
     * Запрещается пользоваться функций join
     *
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if (inputStrings == null || inputStrings.length == 0) {
            return "";
        }
        if (separator == null) {
            separator = ' ';
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < inputStrings.length - 1; i++) {
            stringBuilder.append(inputStrings[i]);
            stringBuilder.append(separator);
        }
        stringBuilder.append(inputStrings[inputStrings.length - 1]);

        return stringBuilder.toString();
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if (inputStrings == null || inputStrings.length == 0 || prefix == null) {
            return 0;
        }
        int count = 0;
        for (String s : inputStrings) {
            if (s.startsWith(prefix)) {
                count++;
            }
        }

        return count;
    }
}
