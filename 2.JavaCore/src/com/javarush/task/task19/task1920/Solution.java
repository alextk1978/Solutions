package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        //args = new String[]{"C:\\Users\\alext\\Desktop\\1.txt"};

        if(args.length > 0) {
            TreeMap<String, Double> treeMap = new TreeMap<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
                while (reader.ready()) {
                    String[] strings = reader.readLine().split(" ");
                    if (treeMap.containsKey(strings[0])) {
                        Double range = Double.parseDouble(strings[1]) + treeMap.get(strings[0]);
                        treeMap.put(strings[0], range);
                    } else {
                        treeMap.put(strings[0], Double.parseDouble(strings[1]));
                    }
                }
            }
            double maxValue = 0.0;
            for (Map.Entry<String, Double> stringDoubleTreeMap : treeMap.entrySet()) {
                maxValue = Math.max(maxValue, stringDoubleTreeMap.getValue());
            }
            for (Map.Entry<String, Double> stringDoubleTreeMap : treeMap.entrySet()) {
                if (stringDoubleTreeMap.getValue().equals(maxValue)) System.out.println(stringDoubleTreeMap.getKey());
            }
        }
    }
}
