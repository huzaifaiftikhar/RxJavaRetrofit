package org.huzaifa.rxjavaretrofit;

/**
 * Created by Huzaifa on 22-Jun-17.
 */

public class Country {

    private String country;
    private String population;
    private String rank;
    private String flag;
    public static final String IMAGE_URL = "IMAGE_URL";

    public String getName(){
        return country;
    }

    public String getRank(){
        return rank;
    }

    public String getPopulation(){
        return population;
    }

    public String getImageURL(){
        return flag;
    }
}
