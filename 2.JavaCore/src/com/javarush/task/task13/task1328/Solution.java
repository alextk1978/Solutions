package com.javarush.task.task13.task1328;

/* 
Битва роботов
*/

public class Solution {

    public static void main(String[] args) {
        Robot amigo = new Robot("Амиго");
        Robot enemy = new Robot("Сгибальщик-02");
        amigo.setCount(0);
        enemy.setCount(0);

        doMove(amigo, enemy);
        doMove(amigo, enemy);
        doMove(enemy, amigo);
        doMove(amigo, enemy);
        doMove(enemy, amigo);
        doMove(amigo, enemy);
        doMove(enemy, amigo);
        doMove(amigo, enemy);
        doMove(enemy, amigo);
        doMove(enemy, amigo);

        if (amigo.getCount() > enemy.getCount()) {
            System.out.println(amigo.getName() + " победил!");
        } else if (amigo.getCount() < enemy.getCount()) {
            System.out.println(enemy.getName() + " победил!");
        } else {
            System.out.println("Ничья!");
        }
    }

    public static void doMove(Robot robotFirst, Robot robotSecond) {
        BodyPart attacked = robotFirst.attack();
        BodyPart defenced = robotFirst.defense();
        System.out.printf("%s атаковал робота %s, атакована %s, защищена %s%n",
                robotFirst.getName(), robotSecond.getName(), attacked, defenced);
        int robot1 = robotFirst.getCount();
        if (!attacked.equals(defenced)) {
            robot1++;
            robotFirst.setCount(robot1);
        }
    }
}
