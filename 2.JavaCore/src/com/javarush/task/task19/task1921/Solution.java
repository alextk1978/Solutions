package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<>();

    public static void main(String[] args) throws IOException, ParseException {
        //args = new String[]{"C:\\Users\\alext\\Desktop\\1.txt"};
        try(BufferedReader fileReader = new BufferedReader(new FileReader(args[0]))) {
            while (fileReader.ready()) {
                String[] strings = fileReader.readLine().split(" ");
                StringJoiner name = new StringJoiner(" ");
                StringJoiner date = new StringJoiner("/");
                for (int i = 0; i < strings.length - 3; i++) name.add(strings[i]);
                for (int i = strings.length - 3; i < strings.length; i++) date.add(strings[i]);
                PEOPLE.add(new Person(name.toString(), new SimpleDateFormat("dd/MM/yyyy").parse(date.toString())));
            }
        }
    }
}
