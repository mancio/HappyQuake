package com.mancio.HappyQuake;

import java.util.Scanner;

/**
 * Class with math coordinated calculation staff
 */
abstract class Calc {

    /**
     * Calculate the distance between coordinates of two cities
     *
     * @param lat1 latitude of the first city
     * @param lng1 longitude of the first city
     * @param lat2 latitude of the second city
     * @param lng2 longitude of the second city
     * @return distance between two cities
     */
    static int distFrom(double lat1, double lng1, double lat2, double lng2) {
        double earthRadius = 6371; //kilometers
        double dLat = Math.toRadians(lat2-lat1);
        double dLng = Math.toRadians(lng2-lng1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLng/2) * Math.sin(dLng/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        int dist = (int) (earthRadius * c);

        return dist;
    }


    static double validcord(Scanner s, String type){

        double cord = -999;
        boolean isdob = s.hasNextDouble();

        if(!isdob) {
            System.out.println("is not a valid number please retry");
            //return -999;
        }else {
            cord = s.nextDouble();
            if(type.equals("lat")){
                if(cord<-90.0d || cord>90.0d){
                    System.out.println("insert a number between -90 and 90 degrees");
                    cord = -999;
                }
            }else if(type.equals("lon")){
                if(cord<-180.0d || cord>180.0d){
                    System.out.println("insert a number between -180 and 180 degrees");
                    cord = -999;
                }
            }else {
                System.out.println("unable to understand coordinates please check input");
                System.exit(0);
            }

        }

        return cord;
    }

}
