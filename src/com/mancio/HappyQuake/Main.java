package com.mancio.HappyQuake;

import java.util.Scanner;

/**
 *  Main class of the Java app
 */
public class Main {

    /**
     * Java Main class
     *
     * @param args
     */
    public static void main(String[] args) {


        Scanner s = new Scanner(System.in);

        System.out.println("Please insert latitude of a city");

        double ok;

        // check if the input is a valid latitude number
        do{
            ok = Calc.validcord(s,"lat");
            s.nextLine();
        }while (ok==-999);

        double slat = ok;

        System.out.println("Please insert longitude of a city");

        // check if the input is a valid longitude number
        do{
            ok = Calc.validcord(s,"lon");
            s.nextLine();
        }while (ok==-999);

        double slon = ok;

        s.close();

        System.out.println("lat= " + slat + " lon= " + slon);

        System.out.println("nearest Quake.... please wait I'm searching between all the city in the world :)");



        // establish connection to the GEO link and download data
        URLReader c = new URLReader("https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_month.geojson");

        // parse the file with GEOJason data
        JSONReader jr = new JSONReader(c, slat, slon);


        System.out.println("---------------");

        // print "title || distance in km" of the al list without duplicates.
        jr.print(jr.removeDuplicates(jr.order(jr.read())), 10);

        System.out.println("---------------");





    }





}
