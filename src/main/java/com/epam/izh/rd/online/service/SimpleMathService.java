package com.epam.izh.rd.online.service;

public class SimpleMathService implements MathService {

    /**
     * Метод возвращает 0, если value1 = value2.
     * Метод возвращает -1, если value1 < value2.
     * Метод возвращает 1, если value1 > value2.
     * <p>
     * Например для (-1, -1) метод должен вернуть 0;
     * Например для (-3, -1) метод должен вернуть -1;
     * Например для (3, 1) метод должен вернуть 1;
     */
    @Override
    public int compare(int value1, int value2) {
        if (value1 < value2) {
            return -1;
        } else if (value1 > value2) {
            return 1;
        }
        return 0;
    }

    /**
     * Метод возвращает максимальное число из пары.
     * Например для списка (-1, 2) метод должен вернуть 2
     */
    @Override
    public int maxFrom(int value1, int value2) {
        return Math.max(value1, value2);
    }

    /**
     * Метод возвращает максимальное число из переданного массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 22
     */
    @Override
    public int maxFrom(int[] values) {
        int max = Integer.MIN_VALUE;
        for (int value : values) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    /**
     * Метод возвращает сумму чисел массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 30
     */
    @Override
    public int sum(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }

    /**
     * Метод фильтрует массив, оставляя только четные числа.
     * Например для списка {-1, -3, 4, 8, 5, 22, 17} метод должен вернуть {4, 8, 22}
     */
    @Override
    public int[] getEvenDigits(int[] values) {

        int evenSize = 0;

        for (int elementForCount : values) {
            if (elementForCount % 2 == 0) {
                evenSize++;
            }
        }

        int[] evenArr = new int[evenSize];
        int i = 0;

        for (int elementForEven : values) {
            if (elementForEven % 2 == 0) {
                evenArr[i++] = elementForEven;
            }
        }
        return evenArr;
    }

    /**
     * Метод считает факториал из заданного числа.
     * Например для числа 5 метод должен вернуть 120.
     * Факториал 0 должен быть равен 1.
     */
    @Override
    public long calcFactorial(int initialVal) {

        long factorial = 1;

        if (initialVal == 0) {
            return 1;
        } else if (initialVal > 0) {
            for (int digitforNotChangeIV = initialVal; digitforNotChangeIV > 0; digitforNotChangeIV--) {
                factorial *= digitforNotChangeIV;
            }
        }
        return factorial;
    }

    /**
     * Метод возвращает число, которе находится на заданной позиции (счет начинается с нуля) в ряду фибоначчи.
     * <p>
     * Ряд фибоначчи - ряд, следующие элементы которого состоят из суммы двух предыдущих.
     * Ряд начинается 0 и 1.
     * Пример 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ...
     * <p>
     * Для числа 9 метод должен вернуть 34
     * Для числа 0 метод должен вернуть 0
     */
    @Override
    public long calcFibonacci(int number) {
        long previous = 0;
        long next = 1;
        long current = 0;
        if (number == 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        } else if (number > 1) {
            for (int i = 1; i != number; i++) {
                current = previous + next;
                previous = next;
                next = current;
            }
        }
        return current;
    }

    /**
     * Метод возвращает отсортированный по возрастанию массив.
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть {-5, -3, -1, 4, 5, 8, 22}
     */
    @Override
    public int[] sort(int[] values) {
        int[] forSort = new int[values.length];
        for (int i = 0; i < forSort.length; i++) {
            forSort[i] = values[i];
        }

        //Insertion Sort
        for (int j = 1; j < forSort.length; j++) {
            int current = forSort[j];
            int k = j - 1;
            while (k >= 0 && current < forSort[k]) {
                forSort[k + 1] = forSort[k];
                k--;
            }
            forSort[k + 1] = current;
        }
        return forSort;
    }

    /**
     * Метод определяет, является ли заданное число простым.
     * Простое число - число, которое делится только на 1 и на само себя.
     * <p>
     * Например для числа 22 вернется false, а для числа 23 true.
     */
    @Override
    public boolean isPrimary(int number) {
        boolean check = true;
        for (int j = 2; j <= number / j; j++) {
            if ((number % j) == 0) {
                check = false;
                break;
            }
        }
        return check;
    }

    /**
     * Метод возвращает массив, в котором элементы расположены в обратном порядке.
     * <p>
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод вернет {-5, 22, 5, 8, 4, -3, -1}
     */
    @Override
    public int[] reverseArray(int[] values) {
        int[] reverseArray = new int[values.length];
        for (int i = 0; i < reverseArray.length; i++) {
            reverseArray[i] = values[values.length - i - 1];
        }
        return reverseArray;
    }
}
