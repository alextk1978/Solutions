package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
//import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        if (args.length != 0) {
            String parameter = args[0];
            switch (parameter) {
                case "-c" : createPersonAndPrintId(args);
                break;
                case "-u" : updatePersonData(args);
                break;
                case "-d" : deletePersonById(args);
                break;
                case "-i" : personDataPrintById(args);
            }
        }
    }

    public static void createPersonAndPrintId (String[] args) throws ParseException {
        Sex sex = "м".equals(args[2]) ? Sex.MALE : Sex.FEMALE;
        String name = args[1];
        Date bd = parseDateBd(args[3]);
        allPeople.add(createPersonBySex(name, sex, bd));
        System.out.println((allPeople.size() - 1));
    }

    public static void updatePersonData (String[] args) throws ParseException {
        int id = Integer.parseInt(args[1]);
        Date bd = parseDateBd(args[4]);
        String name = args[2];
        Sex sex = "м".equals(args[3]) ? Sex.MALE : Sex.FEMALE;
        allPeople.set(id, (createPersonBySex(name, sex, bd)));
    }

    public static void deletePersonById (String[] args) {
        int id = Integer.parseInt(args[1]);
        (allPeople.get(id)).setName(null);
        (allPeople.get(id)).setBirthDate(null);
        (allPeople.get(id)).setSex(null);
    }

    public static void personDataPrintById (String[] args) {
        int id = Integer.parseInt(args[1]);
        System.out.println(allPeople.get(id));
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
