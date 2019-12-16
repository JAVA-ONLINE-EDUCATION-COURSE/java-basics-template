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
        if (value1 == value2) {
            return 0;
        } else if (value1 < value2) {
            return -1;
        } else {
            return 1;
        }
    }

    /**
     * Метод возвращает максимальное число из пары.
     * Например для списка (-1, 2) метод должен вернуть 2
     */
    @Override
    public int maxFrom(int value1, int value2) {
        if (value1 > value2) {
            return value1;
        } else {
            return value2;
        }
    }

    /**
     * Метод возвращает максимальное число из переданного массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 22
     */
    @Override
    public int maxFrom(int[] values) {
        int indexOfMax = 0;
        for (int i = 1; i < values.length; i++) {
            if (values[indexOfMax] < values[i]) {
                indexOfMax = i;
            }
        }
        return values[indexOfMax];
    }

    /**
     * Метод возвращает сумму чисел массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 30
     */
    @Override
    public int sum(int[] values) {
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum = sum + values[i];
        }
        return sum;
    }

    /**
     * Метод фильтрует массив, оставляя только четные числа.
     * Например для списка {-1, -3, 4, 8, 5, 22, 17} метод должен вернуть {4, 8, 22}
     */
    @Override
    public int[] getEvenDigits(int[] values) {
        int[] evenArr;
        int evenArrIndex = 0;
        int evenArrLength = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                evenArrLength++;
            }
        }
        evenArr = new int[evenArrLength];
        for (int i = 0; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                evenArr[evenArrIndex++] = values[i];
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
        if (initialVal == 0) {
            return 1;
        }
        int mult = 1;
        for (int i = initialVal; i > 0; i--) {
            mult = mult * i;
        }

        return mult;
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
        int[] arrFib = new int[number + 1];
        if (number == 0) {
            return 0;
        } else {

            arrFib[0] = 0;
            arrFib[1] = 1;
            for (int i = 2; i < number + 1; i++) {
                arrFib[i] = arrFib[i - 1] + arrFib[i - 2];
            }

            return arrFib[number];
        }
    }


    /**
     * Метод возвращает отсортированный по возрастанию массив.
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть {-5, -3, -1, 4, 5, 8, 22}
     */
    @Override
    public int[] sort(int[] values) {
        for (int i = 0; i < values.length; i++) {
            int min = values[i];
            int min_i = i;
            for (int j = i + 1; j < values.length; j++) {
                if (values[j] < min) {
                    min = values[j];
                    min_i = j;
                }
            }
            if (min_i != i) {
                int tmp = values[i];
                values[i] = values[min_i];
                values[min_i] = tmp;
            }
        }

        return values;
    }


    /**
     * Метод определяет, является ли заданное число простым.
     * Простое число - число, которое делится только на 1 и на само себя.
     * <p>
     * Например для числа 22 вернется false, а для числа 23 true.
     */
    @Override
    public boolean isPrimary(int number) {
        boolean tmpVal = true;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                tmpVal = false;
                break;
            }
        }
        return tmpVal;
    }

    /**
     * Метод возвращает массив, в котором элементы расположены в обратном порядке.
     * <p>
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод вернет {-5, 22, 5, 8, 4, -3, -1}
     */
    @Override
    public int[] reverseArray(int[] values) {
        int[] reverseArr = new int[values.length];
        int j = 0;
        for (int i = values.length - 1; i >= 0; i--) {
            reverseArr[j++] = values[i];
        }
        return reverseArr;
    }
}
