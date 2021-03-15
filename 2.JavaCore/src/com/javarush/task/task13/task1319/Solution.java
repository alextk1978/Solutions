package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedWriter writter = new BufferedWriter(new FileWriter(fileName));

        try {
            String line;
            while (!(line = reader.readLine()).equals("exit")) {
                writter.write(line + "\r\n");
            }
            writter.write(line);
        }
        catch (IOException e) {
            e.printStackTrace();

        }
        writter.close();
        reader.close();
    }
}
