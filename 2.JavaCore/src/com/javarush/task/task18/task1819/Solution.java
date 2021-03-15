package com.javarush.task.task18.task1819;

import java.io.*;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1;
        String fileName2;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
        }

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream file1 = new FileInputStream(fileName1);
        FileInputStream file2 = new FileInputStream(fileName2);
        while (file1.available() > 0) byteArrayOutputStream.write(file1.read());
        FileOutputStream toFile1 = new FileOutputStream(fileName1);
        while (file2.available() > 0) toFile1.write(file2.read());
        byteArrayOutputStream.writeTo(toFile1);
        byteArrayOutputStream.close();
        file1.close();
        file2.close();
        toFile1.close();
    }
}
