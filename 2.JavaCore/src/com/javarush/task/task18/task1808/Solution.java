package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1;
        String fileName2;
        String fileName3;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
            fileName3 = reader.readLine();
        }

        FileInputStream fileInputStream = new FileInputStream(fileName1);
        FileOutputStream fileOutputStream2 = new FileOutputStream(fileName2);
        FileOutputStream fileOutputStream3 = new FileOutputStream(fileName3);

        int halfFileLength = (int)(Math.ceil((double)fileInputStream.available() / 2));
        byte[] buffer = new byte[fileInputStream.available()];
        int count = fileInputStream.read(buffer);
        fileOutputStream2.write(buffer, 0, halfFileLength);
        fileOutputStream3.write(buffer, halfFileLength,count - halfFileLength);

        fileInputStream.close();
        fileOutputStream2.close();
        fileOutputStream3.close();
    }
}
