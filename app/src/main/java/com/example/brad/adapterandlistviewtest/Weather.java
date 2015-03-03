package com.example.brad.adapterandlistviewtest;


public class Weather {

    private int id;
    private String townName;
    private int temp;
    private String shortDescription;

    public Weather(int id, String townName, int temp, String shortDescription) {
        id = this.id;
        townName = this.townName;
        temp = this.temp;
        shortDescription = this.shortDescription;


    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

}


