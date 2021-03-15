package com.javarush.task.task14.task1415;

import java.util.ArrayList;
import java.util.List;

/* 
Клининговый центр
*/

public class Solution {
    public static void main(String[] args) {
        List<Apartment> apartments = new ArrayList<>();
        apartments.add(new OneRoomApt());
        apartments.add(new TwoRoomApt());
        apartments.add(new ThreeRoomApt());

        cleanAllApartments(apartments);
    }

    public static void cleanAllApartments(List<Apartment> apartments) {
        for (Apartment apartment : apartments) {
           apartment.cleanApartment();
        }
    }

    interface Apartment {
        void cleanApartment();
    }

    static class OneRoomApt implements Apartment {

        public void cleanApartment(){
            clean1Room();
        }

        void clean1Room() {
            System.out.println("1 room is cleaned");
        }
    }

    static class TwoRoomApt implements Apartment {

        public void cleanApartment(){
            clean2Rooms();
        }

        void clean2Rooms() {
            System.out.println("2 rooms are cleaned");
        }
    }

    static class ThreeRoomApt implements Apartment {

        public void cleanApartment(){
            clean3Rooms();
        }

        void clean3Rooms() {
            System.out.println("3 rooms are cleaned");
        }
    }
}
