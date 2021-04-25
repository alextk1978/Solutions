package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

import java.util.ArrayList;
import java.util.StringJoiner;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(1234);
    }

    public void createExpression(int number) {
        StringJoiner result = new StringJoiner( " ");
        result.add(String.valueOf(number)).add("=");
        ArrayList<Integer> list = new ArrayList<>();
        int sign = 0;
        do {
            sign = ((number % 3) == 2) ? -1 : number % 3 == 1 ? 1 : 0;
            list.add(sign);
            number = number % 3 == 2 ? number / 3 + 1 : number / 3;
        } while (number != 0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 1) result.add("+").add(String.valueOf((int) Math.pow(3, i)));
            if (list.get(i) == -1) result.add("-").add(String.valueOf((int) Math.pow(3, i)));
        }
        System.out.println(result);
    }
}