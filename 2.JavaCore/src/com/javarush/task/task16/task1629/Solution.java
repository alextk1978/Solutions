package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Только по-очереди!
*/

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException, IOException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();

        t1.start();
        t1.join();
        t2.start();
        t2.join();


        t1.printResult();
        t2.printResult();
        reader.close();
    }

    public static class Read3Strings extends Thread {

        String[] str = new String[3];
        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                try {
                    str[i] = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        public void printResult() {
            for (String s : str) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
