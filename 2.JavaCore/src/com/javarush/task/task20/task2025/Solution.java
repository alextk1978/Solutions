package com.javarush.task.task20.task2025;

import java.util.*;

/* 
Алгоритмы-числа
*/

public class Solution {
    static int[][] powArray;

    static {
        powArray = new int[20][20];           // Заполняем массив, где i - число, а j - это i^j
        for (int i = 0; i < 20; i++) {                //
            for (int j = 0; j < 20; j++) {            //
                powArray[i][j] = (int) Math.pow(i, j);//
            }
        }
    }

    public static long[] getNumbers(long N) {
        long[] result;
        ArrayList<Integer> integerArrayList;
        ArrayList<Integer> integerArrayList2 = new ArrayList<>();
        TreeSet<Long> longTreeSet = new TreeSet<>();

        long i = 1;
        long h;
        while (i < N){
            integerArrayList = searchArmDigit(i);
            long sum = getSumPow(integerArrayList);
            if (sum == i) {
                longTreeSet.add(sum);

            } else
                convertLongToArray(integerArrayList2, sum);
                long sum2 = getSumPow(integerArrayList2);
                if (sum == sum2) {
                    longTreeSet.add(sum);
                }

            h = getI(integerArrayList);
            if (h > i) {
                i = h;
            } else i++;
        }

        result = new long[longTreeSet.size()];
        int k = 0;
        for (Long l : longTreeSet) {
            result[k++] = l;
        }

        return result;
    }

    public static long getI (ArrayList<Integer> integerArrayList) {
        StringBuilder stringBuilder = new StringBuilder();
        for(Integer integer : integerArrayList) {
            stringBuilder.append(integer.toString());
        }
        return Long.parseLong(stringBuilder.toString());
    }

    // Считаем сумму степеней
    public static long getSumPow (ArrayList<Integer> integerArrayList) {
        int powValue = integerArrayList.size();
        long  sum = 0;
        for(int k : integerArrayList) sum += powArray[k][powValue];
        return sum;
    }

    // Генерируем число в котором каждая следующая цифра больше или равна предыдущей.
    public static ArrayList<Integer> searchArmDigit(long i) {
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        convertLongToArray(integerArrayList, i);
        int num = 0;
        int index = integerArrayList.size() - 1;
        int value = integerArrayList.get(index);
        for (int j = 1; j < integerArrayList.size(); j++) {
                if (integerArrayList.get(j) < integerArrayList.get(j - 1)) {
                    num = integerArrayList.get(j);
                    integerArrayList.set(j, integerArrayList.get(j - 1));
                }

        }
        if (value == 0) integerArrayList.set(index, value);
        if (value > num) integerArrayList.set(index, value);
        return integerArrayList;
    }



    // Разбиваем число на список.
    public static void convertLongToArray (ArrayList<Integer> arrayList, long i) {
        arrayList.clear();
        if(i != 0) {
            long temp = i%10;
            i /= 10;
            convertLongToArray(arrayList, i);
            arrayList.add((int) temp);
        }

    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(100000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE/100)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
