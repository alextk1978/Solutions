package com.javarush.task.task18.task1820;

import java.io.*;
import java.nio.charset.StandardCharsets;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1;
        String fileName2;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
        }

        try(FileOutputStream fileOutputStream = new FileOutputStream(fileName2);
        BufferedReader reader = new BufferedReader(new FileReader(fileName1))) {
            StringBuilder stringBuilder = new StringBuilder();
         String str = reader.readLine();
         String[] strings = str.split(" ");
         for(String s : strings) {
             String num = String.valueOf(Math.round(Float.parseFloat(s)));
             stringBuilder.append(num).append(" ");
         }
         fileOutputStream.write((stringBuilder.toString().trim()).getBytes(StandardCharsets.UTF_8));
         reader.close();
         fileOutputStream.close();
        }
    }
}
