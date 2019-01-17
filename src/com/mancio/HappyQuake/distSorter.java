package com.mancio.HappyQuake;

import java.util.Comparator;

public class distSorter implements Comparator<Earthquake> {

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