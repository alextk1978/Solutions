package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Collections;
//import java.util.List;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        while (fileInputStream.available() > 0) {
            integerArrayList.add(fileInputStream.read());
        }
        fileInputStream.close();
        Collections.sort(integerArrayList);
        //toString(integerArrayList);
        int[] intArray = new int[256];
        int byteValue = integerArrayList.get(0);
        for (Integer integer : integerArrayList) {
            if (integer != byteValue) {
                byteValue = integer;
            }
            intArray[byteValue]++;
        }
        int max = intArray[0];
        for(Integer integer : intArray) {
            max = Math.max(max, integer);
        }
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] == max) System.out.print(i + " ");
        }
    }
}
