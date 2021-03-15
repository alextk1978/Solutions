package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {
        //System.out.println(thePlanet.toString());

    }

    public static Planet thePlanet;

    static {
        try {
            readKeyFromConsoleAndInitPlanet();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readKeyFromConsoleAndInitPlanet() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        switch (str) {
            case "moon" : thePlanet = Moon.getInstance();
            break;
            case "sun" : thePlanet = Sun.getInstance();
            break;
            case "earth" : thePlanet = Earth.getInstance();
            break;
            default: thePlanet = null;
        }
    }
}
