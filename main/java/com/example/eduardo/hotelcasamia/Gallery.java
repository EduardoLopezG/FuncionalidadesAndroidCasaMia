package com.example.eduardo.hotelcasamia;

public class Gallery {

    private String Name;
    private String ImageURL;

    /* Create the next constructor */

    public Gallery(String name, String imageURL) {
        Name = name;
        ImageURL = imageURL;
    }

    /* Getters and Setters */

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }
}//End class
