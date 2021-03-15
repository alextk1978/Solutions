package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<>();

    static {
        labels.put(23d, "sdjkhfskdjf");
        labels.put(24d, "sdjkhfskdjfgdddjf");
        labels.put(28d, "sdjkhfskdfgjf");
        labels.put(29d, "sdjkhfskssddjf");
        labels.put(22d, "sdjkhfskssdjhkhjkjkjhkdjf");

    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
