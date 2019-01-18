package com.mancio.HappyQuake;


/**
 * The class Earthquake defines instances, which are representing earthquakes.
 * An instance of this class stores various properties of an earthquake.
 *
 * @author Andrea Mancini
 * @version 1.0
 */
public class Earthquake
{

    private String title;
    private double lon;
    private double lat;
    private int dist;


    /**
     * Constructor of the class Earthquake with the GeoJason parsed variables
     *
     * @param title The title of the Earthquake
     * @param lon The longitude
     * @param lat The latitude
     * @param dist the distance between two cities
     */
    public Earthquake(String title, double lon, double lat, int dist)
    {

        this.title = title;
        this.lon = lon;
        this.lat = lat;
        this.dist = dist;
    }


    /**
     * Get the distance between two cities in Km
     *
     * @return distance in Km
     */
    public double getDist(){

        return(this.dist);

    }



    /**
     * Get title
     *
     * @return title
     */
    public String getTitle()
    {
        return(this.title);
    }





}