package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1;
        String fileName2;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
        }

        try(FileInputStream fileInputStream = new FileInputStream(fileName1);
            FileOutputStream fileOutputStream = new FileOutputStream(fileName2)) {
            byte[] buffer = new byte[fileInputStream.available()];
            int count = fileInputStream.read(buffer);
            for (int i = count-1; i >= 0; i--) {
                fileOutputStream.write(buffer[i]);
            }
        }

    }
}
