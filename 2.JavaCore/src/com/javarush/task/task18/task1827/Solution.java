package com.javarush.task.task18.task1827;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //args = new String[] {"-c", "Шорты зеленые", "189", "77"};
        String fileName;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        }
        if (args.length > 0 && "-c".equals(args[0])) {
            args[0] = getId(fileName);
            String line = setString(args);
            writingLineToFile(fileName, line);
        }
    }

    public static String getId(String fileName) throws IOException {
        int maxId = 0;
        List<String> lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        if (lines.size() != 0) {
            for (String string : lines) {
                int id = Integer.parseInt(string.substring(0, 8).trim());
                maxId = Math.max(maxId, id);
            }
        }
        return (maxId + 1) + "";
    }

    public static String setString(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        int[] numberOfCharacters = {8, 30, 8, 4};
        for (int i = 0; i < numberOfCharacters.length; i++) {
            stringBuilder.append(args[i]).append(addingSpaces(args[i].length(), numberOfCharacters[i]));
        }
        return stringBuilder.toString();
    }

    public static String addingSpaces(int length, int requiredLength) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = length; i < requiredLength; i++) {
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }

    public static void writingLineToFile(String fileName, String line) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            if (bufferedReader.readLine() != null) {
                fileOutputStream.write("\r\n".getBytes(StandardCharsets.UTF_8));
            }
            fileOutputStream.write(line.getBytes(StandardCharsets.UTF_8));
            bufferedReader.close();
            fileOutputStream.close();
    }
}

