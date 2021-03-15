package com.javarush.task.task19.task1923;

import java.io.*;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        //args = new String[]{"C:\\Users\\alext\\Desktop\\1.txt", "C:\\Users\\alext\\Desktop\\2.txt"};
        if(args.length > 0) {
            try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
                 BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]))) {
                while (fileReader.ready()) {
                    String[] strings = fileReader.readLine().split(" ");
                    for(String s : strings) {
                        if (s.matches(".*\\d+.*")) {
                            fileWriter.write(s + " ");
                        }
                    }
                }
            }
        }
    }
}
