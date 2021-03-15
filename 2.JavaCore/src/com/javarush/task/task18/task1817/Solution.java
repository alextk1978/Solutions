package com.javarush.task.task18.task1817;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //args = new String[] {"C:\\Users\\alext\\Desktop\\3.txt"};

        if (args[0] != null) {
            FileInputStream fileInputStream = new FileInputStream(args[0]);
            int countSpace = 0;
            int count = 0;
            while (fileInputStream.available() > 0) {
                count++;
                int numberChar = fileInputStream.read();
                if (numberChar == 32) countSpace++;
            }
            fileInputStream.close();
            float num = (float) countSpace / count * 100;
            num = (float) (Math.round(num*100)/100.00);
            System.out.println(num);
        }
    }
}
