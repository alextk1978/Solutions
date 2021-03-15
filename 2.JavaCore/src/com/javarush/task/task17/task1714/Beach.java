package com.javarush.task.task17.task1714;

/* 
Comparable
*/

//import org.jetbrains.annotations.NotNull;

public class Beach implements Comparable<Beach>{
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {

        Beach beach1 = new Beach("1", 23.4f, 5);
        Beach beach2 = new Beach("2", 23.4f, 4);
        System.out.println(beach1.compareTo(beach2));

    }

    @Override
    public synchronized int compareTo(Beach o) {
        /*
        float resultDistance = o.distance - distance;
        if (resultDistance != 0) {
            resultDistance = resultDistance / Math.abs(resultDistance);
        }
        int resultQuality = quality - o.quality;
        if (resultQuality != 0) {
            resultQuality = resultQuality / Math.abs(resultQuality);
        }
        float result = resultQuality + resultDistance;

         */
        int result = Float.compare(o.getDistance(), getDistance()) + Integer.compare(getQuality(), o.getQuality());
        return result;
    }
}
