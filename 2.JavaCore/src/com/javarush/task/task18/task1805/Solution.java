package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        Set<Integer> integerArrayList = new TreeSet<>();
        while (fileInputStream.available() > 0) {
            integerArrayList.add(fileInputStream.read());
        }
        fileInputStream.close();
        //Collections.sort(integerArrayList);
        toString(integerArrayList);
    }


    public static void toString(Set<Integer> integerList) {
        for (Integer integer : integerList) {
            System.out.print(integer + " ");
        }
    }

}
