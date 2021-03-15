package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static volatile Map<String, Integer> resultMap = new HashMap<>();

    public static void main(String[] args) throws IOException, InterruptedException {
        String fileName;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
            while (!fileName.equals("exit")) {
                ReadThread readThread = new ReadThread(fileName);
                readThread.start();
                fileName = reader.readLine();
            }
        }
        /*
        Thread.sleep(5000);
        for (Map.Entry<String, Integer> stringIntegerEntry : resultMap.entrySet()) {
            System.out.println(stringIntegerEntry.getKey() + " " + stringIntegerEntry.getValue());
        }
         */
    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) {
            super(fileName);
        }

        @Override
        public void run() {
            int[] bytes = new int[255];
            try(FileInputStream fileInputStream = new FileInputStream(getName())) {
                while (fileInputStream.available() > 0) {
                    bytes[fileInputStream.read()]++;
                }
                int max = 0;
                for (int aByte : bytes) {
                    max = Math.max(max, aByte);
                }
                for (int i = 0; i < bytes.length; i++) {
                    if (max == bytes[i]) {
                        resultMap.put(getName(), i);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
