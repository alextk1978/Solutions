package com.javarush.task.task18.task1815;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Ahjkhkjh {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\alext\\Desktop\\1.txt");

        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

        int i;

        while((i = bufferedInputStream.read())!= -1){

            System.out.print(i + " ");
        }
    }
}
