package com.mancio.HappyQuake;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The class EarthquakeGroup represents a group of earthquakes. An instance
 * of type EarthquakeGroup is empty when it is newly constructed, but it can
 * be filled with objects of type Earthquake
 *
 * @author Andrea Mancini
 * @version 1.0
 */
public class EarthquakeGroup
{

    private ArrayList<Earthquake> al;


    /**
     * Constructor for objects of class EarthquakeGroup
     */
    public EarthquakeGroup()
    {
        // initialise instance variables
        al = new ArrayList<>();
    }


    /**
     * This methods adds an object of type Earthquake to the EarthquakeGroup.
     *
     * @param  eq  an object of type Earthquake
     */
    public void add(Earthquake eq)
    {
        // Add an earthquake
        this.al.add(eq);
    }

    /**
     * This method returns an object of type Earthquake at a specific position "i" (index)
     * in the "al" ArrayList, which contains the object of type Earthquake.
     *
     * @param  i  index of Earthquake
     * @return  eq  Earthquake
     */
    public Earthquake getEQ(int i)
    {
        // Add an earthquake
        return(this.al.get(i));
    }


    /**
     * Sort the ArrayList<Earthquake> from the smaller distance from the bigger
     */
    public void order(){

        Collections.sort(this.al, new distSorter());


    }

    // Function to remove duplicates from an ArrayList
    public void removeDuplicates() {

        int count = 1;
        // Create a new ArrayList
        ArrayList<Earthquake> newearth = new ArrayList<>();

        // Traverse through the first list
        for (int i = 0; i<al.size();i++){
            for (int j = 0 ; j<al.size(); j++){
                if(i!=j && al.get(i).getLat() == al.get(j).getLat()
                && al.get(i).getLon() == al.get(j).getLon()){
                    count++;
                    //test
                    System.out.println("duplicate " + al.get(i).getTitle()
                            + "lat = " + al.get(i).getLat() + "lon = " +
                            al.get(i).getLon());
                }
            }

            if(count==3){
                newearth.add(al.get(i));
                count = 1;
            }

        }

        al = newearth;

        // return the new list
        //return newearth;

    }
}