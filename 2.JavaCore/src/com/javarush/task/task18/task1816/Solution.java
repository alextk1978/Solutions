package com.javarush.task.task18.task1816;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //args = new String[] {"C:\\Users\\alext\\Desktop\\3.txt"};

        if (args[0] != null) {
            FileInputStream fileInputStream = new FileInputStream(args[0]);
            int count = 0;
            while (fileInputStream.available() > 0) {
                int numberChar = fileInputStream.read();
                if ((numberChar > 64 && numberChar < 91) || (numberChar > 96 && numberChar < 123)) count++;
            }
            System.out.println(count);
            fileInputStream.close();
        }
    }
}
