package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while (!(s = reader.readLine()).equals("exit")) {
            if (s.matches("-?\\d+(\\.\\d+)?")) {
                if (s.contains(".")) {
                    double numDouble = Double.parseDouble(s);
                    print(numDouble);
                } else if (Integer.parseInt(s) > 0 && Integer.parseInt(s) < 128) {
                    short numShort = Short.parseShort(s);
                    print(numShort);
                } else if (Integer.parseInt(s) <= 0 || Integer.parseInt(s) >= 128) {
                    Integer numInteger = Integer.parseInt(s);
                    print(numInteger);
                }
            } else {
                print(s);
            }
        }
        reader.close();
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
