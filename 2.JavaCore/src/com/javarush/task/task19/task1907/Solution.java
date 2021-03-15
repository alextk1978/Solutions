package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        }
        try(BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            int count = 0;
            while (fileReader.ready()) {
                String[] strings = fileReader.readLine().split("\\W");
                for(String s : strings) {
                    if ("world".equals(s)) count++;
                }
            }
            System.out.println(count);
        }
    }
}
