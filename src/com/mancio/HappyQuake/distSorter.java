package com.mancio.HappyQuake;

import java.util.Comparator;

/**
 * Class with the comparator method to sort the cities by crescent distance
 */
public class distSorter implements Comparator<Earthquake> {

    /**
     * Used to compare the distance between cities
     * @param one Earthquake class object of the first city to compare
     * @param another Earthquake class object of the second city to compare
     * @return -1, 1 or 0 if the first city is <, > or = to the second
     */
    public int compare(Earthquake one, Earthquake another){
        int returnVal = 0;

        if(one.getDist() < another.getDist()){
            returnVal =  -1;
        }else if(one.getDist() > another.getDist()){
            returnVal =  1;
        }else if(one.getDist() == another.getDist()){
            returnVal =  0;
        }
        return returnVal;
    }
}