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

        do{
            ok = Calc.validcord(s,"lat");
            s.nextLine();
        }while (ok==-999);

        double slat = ok;

        System.out.println("Please insert longitude of a city");

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

        JSONReader jr = new JSONReader(c, slat, slon);

        //jr.removeDuplicates(jr.order(jr.read());


        //jr.print(jr.order(jr.read()), 10);

        System.out.println("---------------");

        jr.print(jr.removeDuplicates(jr.order(jr.read())), 10);

        System.out.println("---------------");





    }





}
