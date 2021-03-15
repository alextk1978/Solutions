package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String strParameters = url.substring(url.lastIndexOf('?') + 1);
        String[] arrayParameters = strParameters.split("&");
        StringBuilder resultString = new StringBuilder();
        ArrayList<String> objValue = new ArrayList<>();

        for (String parameter : arrayParameters) {
            String[] splitParameter = parameter.split("=");
            resultString.append(splitParameter[0]).append(" ");

            if (splitParameter[0].equals("obj")) {
                objValue.add(splitParameter[1]);
            }
        }

        System.out.println(resultString.toString().trim());

        for (String s : objValue) {
            try {
                alert(Double.parseDouble(s));
            } catch (Exception e) {
                alert(s);
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
