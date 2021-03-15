package com.javarush.task.task15.task1522;

public class Earth implements Planet{
    private static Earth instance;

    private Earth(String EARTH) {
    }

    public static Earth getInstance() {
        if ( instance == null) {
            instance = new Earth(EARTH);
        }
        return instance;
    }
}
