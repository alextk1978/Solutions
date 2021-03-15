package com.javarush.task.task18.task1828;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //args = new String[] {"-u", "767", "Шорты зеленые", "189", "77"};
        String fileName;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        }

        if (args.length > 0 ) {
            ArrayList<String> listLinesFromFile = getFileToList(fileName);
            int id = getId(args[1]);
            switch (args[0]) {
                case "-u" : {
                    int numberLine = searchAndDeleteLineById(id,listLinesFromFile);
                    listLinesFromFile.add(numberLine, setString(args));
                    writeListToFile(fileName, listLinesFromFile);
                }
                break;
                case "-d" : {
                    searchAndDeleteLineById(id, listLinesFromFile);
                    writeListToFile(fileName, listLinesFromFile);
                }
                break;
            }
        }
    }
    //getFileToList Читаем из файла строки в List
    public static ArrayList<String> getFileToList(String fileName) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        fileInputStream.close();
        return (ArrayList<String>) Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
    }

    //writeListToFile Пишем List в файл
    public static void writeListToFile(String fileName, ArrayList<String> list) throws IOException {
        File sourceFile = new File(fileName);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(sourceFile));
        for(String string : list) {
            bufferedWriter.write(string);
            bufferedWriter.write("\r\n");
            }
        bufferedWriter.close();
    }

    //setString Формируем строку из массива аргументов
    public static String setString(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        int[] numberOfCharacters = {8, 30, 8, 4};
        for (int i = 1; i < numberOfCharacters.length + 1; i++) {
            stringBuilder.append(args[i]).append(addingSpaces(args[i].length(), numberOfCharacters[i-1]));
        }
        return stringBuilder.toString();
    }

    //searchAndDeleteLineById Удаляем строку из List с переданным id
    public static int searchAndDeleteLineById(int id, ArrayList<String> list) {
        String str = "";
        int numberLine = -1;
        for(int i = 0; i < list.size(); i++) {
            int idInLine = Integer.parseInt(list.get(i).substring(0, 8).trim());
            if (idInLine == id) {
                str = list.get(i);
                numberLine = i;
            }
        }
        list.remove(str);
        return numberLine;
    }

    //getId Возвращаем id
    public static int getId(String arg) {
        return Integer.parseInt(arg);
    }

    //addingSpaces Добавляем необходимое количество пробелов в элемент строки
    public static String addingSpaces(int length, int requiredLength) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = length; i < requiredLength; i++) {
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}

