package com.mancio.HappyQuake;


import java.net.*;
import java.io.*;

public class URLReader {
   // instance variables
   String url;

   /**
    * Constructor for objects of class URLReader
    */
   public URLReader(String url) {
       // initialise instance variables
       this.url = url;
   }

   /**
    * This method returns the URL.
    *
    * @return     url A String with the URL bound to the instance.
    */
   public String getUrl() {
       return(this.url);
   }

   /**
    * This method reads the content found at the URL.
    *
    * @return     jsonFileContent A String with content of website (read-in JSON).
    */
   public String read() {
       String jsonFileContent = "";
       try {
           // Create an url object from the url string
           URL urlobj = new URL(this.url);
           // Define a new buffer for the urlobj
           BufferedReader in = new BufferedReader(
                   new InputStreamReader(urlobj.openStream()));
           // While there is a next line read the line an append it to a long string
           String inputLine;
           while ((inputLine = in.readLine()) != null)
               jsonFileContent += inputLine;
           jsonFileContent += "\n";
           in.close();
       }
       catch (Exception e) {
           System.out.println(e);
       }
       // Return the string (ONE) containing the JSON file content
       return(jsonFileContent);
   }
}


