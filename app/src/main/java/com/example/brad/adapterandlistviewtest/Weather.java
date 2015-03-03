package com.example.brad.adapterandlistviewtest;


public class Weather {

    int id;
    String townName;
    Double temp;
    String shortDescription;

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

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }


    public Weather() {


    }
    public Weather(int id, String townName, Double temp, String shortDescription) {
        id = this.id;
        townName = this.townName;
        temp = this.temp;
        shortDescription = this.shortDescription;
    }
}


