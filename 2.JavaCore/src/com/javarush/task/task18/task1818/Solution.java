package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
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

        try(FileOutputStream file1 = new FileOutputStream(fileName1, true);
        FileInputStream file2 = new FileInputStream(fileName2);
        FileInputStream file3 = new FileInputStream(fileName3)) {
            while (file2.available() > 0) {
                file1.write(file2.read());
            }
            while (file3.available() > 0) {
                file1.write(file3.read());
            }
            //file1.close();
            //file2.close();
            //file3.close();
        }
    }
}
