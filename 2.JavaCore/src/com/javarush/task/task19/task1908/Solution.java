package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        String fileName1;
        String fileName2;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
        }

        try(BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2))) {
            StringBuilder stringBuilder = new StringBuilder();
            while (fileReader.ready()) stringBuilder.append(fileReader.readLine()).append(" ");
            String[] resultString = stringBuilder.toString().split(" ");
            int l = 0;
            while (l < resultString.length) {
                try {
                    Integer.parseInt(resultString[l]);
                    fileWriter.write(resultString[l++] + " ");
                } catch (Exception e) {
                    l++;
                }
            }
        }
    }
}
