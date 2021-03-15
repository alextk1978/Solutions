package com.javarush.task.task18.task1821;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //args = new String[]{"C:\\Users\\alext\\Desktop\\3.txt"};

        TreeMap<Character, Integer> treeMap = new TreeMap<>();
        byte[] bytes;
        int count;
        try(FileInputStream fileInputStream = new FileInputStream(args[0])) {
            bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
        }
        for (int i = 0; i < bytes.length; i++) {
            count = 0;
            for (int j = i; j < bytes.length; j++) {
                if (bytes[i] == bytes[j]) {
                    count++;
                }
            }
            if (!treeMap.containsKey((char) bytes[i])) {
                treeMap.put((char) bytes[i], count);
            }
        }
        for(Map.Entry<Character, Integer> stringStringEntry : treeMap.entrySet()) {
            System.out.println(stringStringEntry.getKey() + " " + stringStringEntry.getValue());
        }
    }
}
