package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<>();
    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException{
        String fileName;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        }
        try(BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                String[] strings = fileReader.readLine().split("\\b");
                StringBuilder stringBuilder = new StringBuilder();
                int i = 0;
                while (i < strings.length) {
                    try {
                        int num = Integer.parseInt(strings[i]);
                        if (map.containsKey(num)) {
                            stringBuilder.append(map.get(num));
                            i++;
                        } else throw new Exception();
                    } catch (Exception e) {
                        stringBuilder.append(strings[i++]);
                    }
                }
                System.out.println(stringBuilder.toString().trim());
            }
        }
    }
}
