package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //args = new String[]{"-d", "C:\\Users\\alext\\Desktop\\2.txt", "C:\\Users\\alext\\Desktop\\3.txt"};
        if (args.length > 0) {
            FileInputStream fileInputStream = new FileInputStream(args[1]);
            FileEncryptionDecryption fileEncryptionDecryption = new FileEncryptionDecryption(new FileOutputStream(args[2]));
            switch(args[0]) {
                    case "-e":
                    while (fileInputStream.available() > 0) {
                        fileEncryptionDecryption.write(fileInputStream.read(), true);
                    }
                    break;
                    case "-d":
                        while (fileInputStream.available() > 0) {
                            fileEncryptionDecryption.write(fileInputStream.read(), false);
                        }
                    break;
                default:
                    fileEncryptionDecryption.close();
                    fileInputStream.close();
                }
            }
        }
    }

class FileEncryptionDecryption {
    private final FileOutputStream fileOutputStream;

    public FileEncryptionDecryption(FileOutputStream fileOutputStream) {
        this.fileOutputStream = fileOutputStream;
    }

    public void write(int b, boolean encrypt) throws IOException {
        if (encrypt) {
            fileOutputStream.write(b + 1);
        } else fileOutputStream.write(b - 1);
    }

    public void close() throws IOException {
        fileOutputStream.close();
    }
}
