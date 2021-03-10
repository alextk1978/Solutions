package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        for (Map.Entry<String, String> entry : runtimeStorage.entrySet()) {
            bufferedWriter.write(entry.getKey() + "=" + entry.getValue());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }

    public static void load(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        while (reader.ready()) {
            String line = reader.readLine().trim();
            if (line.charAt(0) != '#' & line.charAt(0) != '!') {
                String key;
                String value;
                for (int i = 1; i < line.length(); i++) {
                    if (line.charAt(i - 1) != '\\' & (line.charAt(i) == '=' || line.charAt(i) == ':')) {
                        key = line.substring(0, i).trim();
                        value = line.substring(i + 1).trim();
                        //if (value.charAt(0) == '=' || value.charAt(0) == ':') value = value.substring(1).trim();
                        if (value.endsWith("\\")) {
                            value = value.substring(0, value.length() - 1) + reader.readLine().trim();
                        }
                        runtimeStorage.put(key, value);
                        break;
                    }
                }
            }
        }
        reader.close();
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //try(FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\alext\\Desktop\\config1.properties")) {
            //save(fileOutputStream);
        //}

        System.out.println(runtimeStorage);
    }
}
