package com.javarush.task.task14.task1414;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/* 
MovieFactory
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        try {

            List<String> stringList = Arrays.asList("cartoon", "thriller", "soapOpera");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String key;

            while (stringList.contains(key = reader.readLine())) {
                Movie movie = MovieFactory.getMovie(key);
                System.out.println(movie.getClass().getSimpleName());
            }

            Movie movie = MovieFactory.getMovie(key);
            System.out.println(movie.getClass().getSimpleName());
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }
            if ("cartoon".equals(key)) {
                movie = new Cartoon();
            }
            if ("thriller".equals(key)) {
                movie = new Thriller();
            }

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    static class Cartoon extends Movie{

    }
    static class Thriller extends Movie {

    }
}
