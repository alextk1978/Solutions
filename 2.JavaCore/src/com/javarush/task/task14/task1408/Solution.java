package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();
    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;
            if (country.equalsIgnoreCase("Ukraine")) {
                hen = new UkrainianHen();
            }
            if (country.equalsIgnoreCase("Russia")) {
                hen = new RussianHen();
            }
            if (country.equalsIgnoreCase("Moldova")) {
                hen = new MoldovanHen();
            }
            if (country.equalsIgnoreCase("Belarus")) {
                hen = new BelarusianHen();
            }

            return hen;
        }
    }


}
