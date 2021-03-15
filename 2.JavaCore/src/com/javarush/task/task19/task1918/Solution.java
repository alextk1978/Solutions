package com.javarush.task.task19.task1918;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Знакомство с тегами
*/

public class Solution {

    public static void main(String[] args) throws IOException{
        args = new String[]{"b"};
        String tag = "<" + args[0] + ">";
        String tag2 = "<" + args[0] + " ";
        String closeTag = "</" + args[0] +">";
        String closeTag2 = "/>";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        while (fileReader.ready()) stringBuilder.append(fileReader.readLine().trim()).append(" ");
        fileReader.close();

        String[] strings = stringBuilder.toString().split("");
        for (int i = 0; i < strings.length - tag.length(); i++) {
            StringBuilder bufferString = new StringBuilder();
            for (int j = i; j < i + tag.length(); j++) {
                bufferString.append(strings[j]);
            }
            if (tag.equals(bufferString.toString()) || tag2.equals(bufferString.toString())) {
                System.out.println(addStringsAtList(i, strings, tag, tag2, closeTag, closeTag2));
            }
        }
    }

    public static String addStringsAtList (int index, String[] strings, String tag, String tag2, String closeTag, String closeTag2) {
        int count = -1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = index; i < strings.length - closeTag.length(); i++) {
            StringBuilder bufferString = new StringBuilder();
            for (int j = i; j < i + closeTag.length(); j++) {
                bufferString.append(strings[j]);
            }
            String strTag = bufferString.substring(0, tag.length());
            String strCloseTag2 = bufferString.substring(0, closeTag2.length());
            String strCloseTag = bufferString.toString();
            if (tag.equals(strTag) || tag2.equals(strTag)) {
                count++;
                stringBuilder.append(strTag);
                i +=strTag.length() - 1;
            } else {
                if (strCloseTag.equals(closeTag)) {
                    count--;
                    stringBuilder.append(strCloseTag);
                    i += strTag.length();
                } else {
                    if (strCloseTag2.equals(closeTag2)) {
                        count--;
                        stringBuilder.append(strCloseTag2);
                        i += strCloseTag2.length() - 1;
                    } else {
                        stringBuilder.append(strings[i]);
                    }
                }
            }
            if (count == -1) return stringBuilder.toString();
        }
        return stringBuilder.toString();
    }
}
