package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1;
        String fileName2;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
        }
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2))) {
            ArrayList<String> stringArrayList = new ArrayList<>();
            while (bufferedReader.ready()) {
                stringArrayList.add(bufferedReader.readLine());
            }
            for(String integer : stringArrayList) {
                bufferedWriter.write(integer.replaceAll("\\.", "!"));
                bufferedWriter.write(13);
            }
        }
    }
}
