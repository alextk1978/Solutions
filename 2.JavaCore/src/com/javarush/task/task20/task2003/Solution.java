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
        Properties properties = new Properties();
        for (Map.Entry<String, String> entry : runtimeStorage.entrySet()) {
            properties.put(entry.getKey(), entry.getValue());
        }
        properties.store(outputStream, properties.toString());
    }

    public static void load(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        properties.load(inputStream);
        for (String key : properties.stringPropertyNames()) {
            runtimeStorage.put(key, properties.getProperty(key));
        }
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
