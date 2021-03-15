package com.javarush.task.task19.task1927;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Контекстная реклама
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStreamOld = System.out;
        PrintStream printStreamNew = new PrintStream(byteArrayOutputStream);
        System.setOut(printStreamNew);
        testString.printSomething();
        System.setOut(printStreamOld);
        String[] stringsByteArray = byteArrayOutputStream.toString().split("\\n");
        for (int i = 0; i < stringsByteArray.length; i++) {
            System.out.println(stringsByteArray[i]);
            if (i % 2 != 0) System.out.println("JavaRush - курсы Java онлайн");
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
