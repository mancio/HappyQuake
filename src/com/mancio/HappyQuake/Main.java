package com.mancio.HappyQuake;

public class Main {

    public static void main(String[] args) {

        // establish connection to the GEO link and download data
        URLReader c = new URLReader("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson");
        String allj = c.read();
        System.out.println(allj);

    }
}
