package com.javarush.task.task18.task1807;

import java.io.*;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        FileInputStream fileReader = new FileInputStream(fileName);
        int count = 0;
        while (fileReader.available() > 0) {
            if (fileReader.read() == 44) count++;
        }
        fileReader.close();
        System.out.println(count);
    }
}
