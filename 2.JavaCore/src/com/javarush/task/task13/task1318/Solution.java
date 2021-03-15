package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        InputStream fileReader = new BufferedInputStream(new FileInputStream(fileName));

        try {
            while (fileReader.available() > 0) {
                System.out.print(Character.toChars(fileReader.read()));
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
        finally {
            reader.close();
            fileReader.close();
        }

    }
}