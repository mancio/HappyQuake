package com.mancio.HappyQuake;

import java.util.Comparator;

/**
 * Class with the comparator method to sort the cities by crescent distance
 */
public class distSorter implements Comparator<Earthquake> {

    /**
     * Used to compare the distance between cities
     * @param one
     * @param another
     * @return
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