package com.example.brad.adapterandlistviewtest;


public class Weather {

    private String townName;
    private String temp;
    private String shortDescription;

    private int weatherImage;

    public Weather(String townName, String temp, String shortDescription, int weatherImage) {
        this.townName = townName;
        this.temp = temp;
        this.shortDescription = shortDescription;
        this.weatherImage = weatherImage;
    }

    public Weather(String townName, String temp, String shortDescription) {
        this.townName = townName;
        this.temp = temp;
        this.shortDescription = shortDescription;
        this.weatherImage = 0;

    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public int getWeatherImage() {
          return weatherImage;
    }

    public void setWeatherImage(int weatherImage) {
        this.weatherImage = weatherImage;
    }

}


