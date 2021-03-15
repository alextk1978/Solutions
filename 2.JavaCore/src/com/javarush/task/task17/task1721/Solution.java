package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<>();
    public static List<String> forRemoveLines = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите имя первого файла:");
        String firstFileName = reader.readLine();
        System.out.println("Введите имя второго файла:");
        String secondFileName = reader.readLine();
        reader.close();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(firstFileName));
        String str = bufferedReader.readLine();
        while (str != null) {
            allLines.add(str);
            str = bufferedReader.readLine();
        }
        bufferedReader.close();
        BufferedReader bufferedReader2 = new BufferedReader(new FileReader(secondFileName));
        str = bufferedReader2.readLine();
        while (str != null) {
            forRemoveLines.add(str);
            str = bufferedReader2.readLine();
        }
        bufferedReader2.close();

        new Solution().joinData();

    }

    public void  joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
