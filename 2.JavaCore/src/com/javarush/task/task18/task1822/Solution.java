package com.javarush.task.task18.task1822;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //args = new String[] {"767"};
        String fileName;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        }
        ArrayList<String> stringArrayList = getFileToList(fileName);
        if (args.length > 0) {
            int id = Integer.parseInt(args[0]);
            for(String s : stringArrayList) {
                String[] s1 = s.split(" ");
                if (id == Integer.parseInt(s1[0])) System.out.println(s);
            }
        }


    }

    //getFileToList Читаем из файла строки в List
    public static ArrayList<String> getFileToList(String fileName) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        fileInputStream.close();
        return (ArrayList<String>) Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
    }
}
