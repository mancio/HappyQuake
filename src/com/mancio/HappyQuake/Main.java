package com.mancio.HappyQuake;

import java.util.Scanner;

/**
 *  Main class of the Java app
 */
public class Main {

    /**
     *Java Main class
     *
     * @param args
     */
    public static void main(String[] args) {


        Scanner s = new Scanner(System.in);

        System.out.println("Please insert latitude of a city");

        double slat = s.nextDouble();

        System.out.println("Please insert longitude of a city");

        double slon = s.nextDouble();

        s.close();

        System.out.println("lat= " + slat + " lon= " + slon);

        System.out.println("nearest Quake.... please wait I'm searching between all the city in the world :)");



        // establish connection to the GEO link and download data
        URLReader c = new URLReader("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson");
        JSONReader jr = new JSONReader(c, slat, slon);



        jr.print(jr.order(jr.read()), 10);




    }
}
