package com.javarush.task.task19.task1925;

import java.io.*;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        //args = new String[]{"C:\\Users\\alext\\Desktop\\1.txt", "C:\\Users\\alext\\Desktop\\2.txt"};
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1]))) {
            StringBuilder stringBuilder = new StringBuilder();
            while (bufferedReader.ready()) {
                String[] strings = bufferedReader.readLine().split(" ");
                for (String s : strings) {
                    if (s.length() > 6) stringBuilder.append(s).append(" ");
                }
            }
            bufferedWriter.write(stringBuilder.toString().trim().replaceAll(" ", ","));
        }
    }
}
