package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        ArrayList<String> stringFile1 = new ArrayList<>();
        ArrayList<String> stringFile2 = new ArrayList<>();
        String fileName1;// = "C:\\Users\\alext\\Desktop\\1.txt";
        String fileName2;// = "C:\\Users\\alext\\Desktop\\2.txt";

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
        }

        try(BufferedReader reader1 = new BufferedReader(new FileReader(fileName1));
            BufferedReader reader2 = new BufferedReader(new FileReader(fileName2))) {
            while (reader1.ready()) {
                stringFile1.add(reader1.readLine());
            }
            while (reader2.ready()) {
                stringFile2.add(reader2.readLine());
            }
        }

        while (stringFile1.size() != 0 && stringFile2.size() != 0){
            if (stringFile1.get(0).equals(stringFile2.get(0))) {
                lines.add(new LineItem(Type.SAME, stringFile1.get(0)));
                stringFile1.remove(0);
                stringFile2.remove(0);
            } else if (stringFile1.get(1).equals(stringFile2.get(0))) {
                lines.add(new LineItem(Type.REMOVED, stringFile1.get(0)));
                stringFile1.remove(0);
            } else {
                lines.add(new LineItem(Type.ADDED, stringFile2.get(0)));
                stringFile2.remove(0);
            }
        }

        if (!stringFile1.isEmpty()) {
            for (String s : stringFile1) {
                lines.add(new LineItem(Type.REMOVED, s));
            }
        }

        if (!stringFile2.isEmpty()) {
            for (String s : stringFile2) {
                lines.add(new LineItem(Type.ADDED, s));
            }
        }
/*
        for (LineItem lineItem : lines) {
            System.out.println(lineItem.type + " " + lineItem.line);
        }

 */


    }


    public enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
