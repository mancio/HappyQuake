package com.mancio.HappyQuake;


import org.json.simple.parser.*;
import org.json.simple.*;


public class JSONReader {

    //// initialise instance variables
    private JSONObject jsonObjects;
    private JSONArray features;
    private URLReader urlreader;
    private double startlat;
    private double startlon;


    /**
     * Constructor for objects of class JSONReader.
     * Reads in the the content (one long string) of the passed URLReader
     * and stores its content in jsonObjects.
     *
     * @param urlreader the link with GeoJason data
     * @param startlat latitude in input
     * @param startlon longitude in input
     */
    public JSONReader(URLReader urlreader, double startlat, double startlon)
    {
        this.urlreader = urlreader;
        this.startlat = startlat;
        this.startlon = startlon;

        String jsonFileContent = this.urlreader.read();
        // now that we've stored the content of the JSON file in a single String, we parse it.
        // this turns the original JSON specification into an iterable Java data structure
        // consisting of JSONObject (similar to ArrayList) and JSONArray elements
        JSONParser parser = new JSONParser();
        try {
            Object parsedFile = parser.parse(jsonFileContent);
            jsonObjects = (JSONObject) parsedFile;
        }
        catch(ParseException pe) {
            System.out.println("Error at position: " + pe.getPosition());
            System.out.println(pe);
            System.out.println("unable to parse the file Jason corrupted");
            System.exit(0);
        }
    }



    /**
     * The read() method is used to convert the earthquakes
     * from JSONObjects into instances of type "Earthquake" and store them in a instance of the
     * EarthquakeGroup class.
     *
     * @return eqg  EarthquakeGroup storing objects of type "Earthquake"
     */
    public EarthquakeGroup read() {
        EarthquakeGroup eqg = new EarthquakeGroup();
        features = (JSONArray) jsonObjects.get("features");
        for (int i = 0; i < features.size(); i++) {
            try {
                // get the current feature
                JSONObject object = (JSONObject)  features.get(i);
                // get a feature's properties
                JSONObject properties = (JSONObject) object.get("properties");
                // get a features's geometry
                JSONObject geometry = (JSONObject) object.get("geometry");
                // coordinates are an array with two entries: longitude first, then latitude
                JSONArray coordinates = (JSONArray) geometry.get("coordinates");
                // extract relevant text properties
                String title = properties.get("title").toString();
                // get the latitude
                double lon = Double.parseDouble(coordinates.get(0).toString());
                // get the longitude
                double lat = Double.parseDouble(coordinates.get(1).toString());
                // create object of type "Earthquake"
                Earthquake eq = new Earthquake(title, lon, lat, Calc.distFrom(startlat, startlon, lat, lon));
                eqg.add(eq);

            } catch (NullPointerException npe) {
                System.out.println("Incomplete data record, this particular earthquake is dismissed.");
                System.out.println(npe);
            }

        }

        return(eqg);
    }

    /**
     * Order the Earthquakes from the most far to the nearest
     *
     * @param eqg EarthquakeGroup
     * @return eqg EarthquakeGroup reordered
     */
    public EarthquakeGroup order(EarthquakeGroup eqg){

        eqg.order();

        return eqg;

    }

    /**
     * print the title and distance in km
     * ex. title || distance (km)
     * M 4.5 - 7km E of Ravenna, Italy || 179
     *
     * @param eqg EarthquakeGroup object
     * @param num number of earthquakes to print
     */
    public void print(EarthquakeGroup eqg, int num){

        for (int i = 0; i < num; i++){

            System.out.println(eqg.getEQ(i).getTitle() + " || " + (int) eqg.getEQ(i).getDist());
        }

    }

}

