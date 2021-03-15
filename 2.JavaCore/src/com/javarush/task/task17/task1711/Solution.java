package com.javarush.task.task17.task1711;

//import com.javarush.task.task17.task1710.Sex;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1

    }

    public static void main(String[] args) throws ParseException {
        if (args.length != 0) {
            switch (args[0]) {
                case "-c" : synchronized (allPeople) {
                    for (int i = 1; i < args.length; i+=3) {
                    createPersonAndPrintId(args, i);
                    }
                    break;
                }
                case "-u" : synchronized (allPeople) {
                    for (int i = 1; i < args.length; i+=4) {
                    updatePersonData(args, i);
                    }
                    break;
                }
                case "-d" : synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                    deletePersonById(Integer.parseInt(args[i]));
                    }
                    break;
                }
                case "-i" : synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                    personDataPrintById(Integer.parseInt(args[i]));
                    }
                }
            }
        }
    }

    public static void createPersonAndPrintId (String[] args, int i) throws ParseException {
        Sex sex = "м".equals(args[i+1]) ? Sex.MALE : Sex.FEMALE;
        String name = args[i];
        Date bd = parseDateBd(args[i+2]);
        allPeople.add(createPersonBySex(name, sex, bd));
        System.out.println((allPeople.size() - 1));
    }

    public static void updatePersonData (String[] args, int i) throws ParseException {
        int id = Integer.parseInt(args[i]);
        Date bd = parseDateBd(args[i+3]);
        String name = args[i+1];
        Sex sex = "м".equals(args[i+2]) ? Sex.MALE : Sex.FEMALE;
        allPeople.set(id, (createPersonBySex(name, sex, bd)));
    }

    public static void deletePersonById (int i) {
        (allPeople.get(i)).setName(null);
        (allPeople.get(i)).setBirthDate(null);
        (allPeople.get(i)).setSex(null);
    }

    public static void personDataPrintById (int i) {
        System.out.println(allPeople.get(i));
    }

    public static Date parseDateBd (String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        return simpleDateFormat.parse(date);
    }

    public static Person createPersonBySex (String name, Sex sex, Date bd) {
        Person person = null;
        switch (sex) {
            case MALE : person = Person.createMale(name, bd);
                break;
            case FEMALE: person = Person.createFemale(name, bd);
        }
        return person;
    }
}

