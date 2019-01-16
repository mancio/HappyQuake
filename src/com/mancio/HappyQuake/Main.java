package com.mancio.HappyQuake;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /*
        Scanner s = new Scanner(System.in);

        System.out.println("Please insert latitude of a city");

        double lat = s.nextDouble();

        System.out.println("Please insert longitude of a city");

        double lon = s.nextDouble();

        s.close();

        System.out.println("lat= " + lat + " lon= " + lon);

        System.out.println("nearest Quake.... please wait I'm searching all the city in the world :)");
        */

        // establish connection to the GEO link and download data
        URLReader c = new URLReader("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson");
        //String allj = c.read();
        //System.out.println(allj);
        JSONReader jr = new JSONReader(c);

        jr.read();

    }
}
