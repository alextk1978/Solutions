package com.javarush.task.task15.task1522;

public class Moon implements Planet{
    private static Moon  instance;

    private Moon(String MOON) {
    }

    public static Moon getInstance() {
        if ( instance == null) {
            instance = new Moon(MOON);
        }
        return instance;
    }
}
