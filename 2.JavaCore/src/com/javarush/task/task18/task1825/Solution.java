package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        TreeSet<String> stringStringTreeMap = new TreeSet<>();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = reader.readLine();
            while (!fileName.equals("end")) {
                stringStringTreeMap.add(fileName);
                fileName = reader.readLine();
            }
        }
        String[] fileNameArray = stringStringTreeMap.first().split("\\.");
        String fileNameResult = fileNameArray[0] + "." + fileNameArray[1];
        File resultFile = new File(fileNameResult);
        try(BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(resultFile, true))) {
            for(String stringStringEntry : stringStringTreeMap) {
                try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(stringStringEntry))) {
                    while (bufferedInputStream.available() > 0) bufferedOutputStream.write(bufferedInputStream.read());
                }
            }
        }
    }
}
