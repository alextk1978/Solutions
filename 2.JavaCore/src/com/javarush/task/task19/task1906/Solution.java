package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        String fileName1;
        String fileName2;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
        }
        try(FileReader fileReader = new FileReader(fileName1);
        FileWriter fileWriter = new FileWriter(fileName2)) {
            while (fileReader.ready()) {
                fileReader.read();
                fileWriter.write(fileReader.read());
            }
        }
    }
}
