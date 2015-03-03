package com.example.brad.adapterandlistviewtest;


public class Conversions {

    public Conversions() {
    }
    public int tempFromCelciusToFahrenheit(double temp) {
        double result;
        result = 9/5 * (temp - 273) + 32;
        int ret = (int) Math.round(result);
        return ret;
    }
    public String windDirectionFromDegrees(double degrees) {

        if (degrees == 0) {
            return "Calm";
        } else if (degrees >= 1 && degrees <= 10) {
            return "N";
        } else if (degrees >= 11 && degrees <= 34) {
            return "NNE";
        } else if (degrees >= 35 && degrees <= 55) {
            return "NE";
        } else if (degrees >= 56 && degrees <= 79) {
            return "ENE";
        } else if (degrees >= 80 && degrees <= 100) {
            return "E";
        } else if (degrees >= 101 && degrees <= 124) {
            return "ESE";
        } else if (degrees >= 125 && degrees <= 145) {
            return "SE";
        } else if (degrees >= 146 && degrees <= 169) {
            return "SSE";
        } else if (degrees >= 170 && degrees <= 190) {
            return "S";
        } else if (degrees >= 191 && degrees <= 214) {
            return "SSW";
        } else if (degrees >= 215 && degrees <= 235) {
            return "SW";
        } else if (degrees >= 236 && degrees <= 259) {
            return "WSW";
        } else if (degrees >= 260 && degrees <= 280) {
            return "W";
        } else if (degrees >= 281 && degrees <= 304) {
            return "WNW";
        } else if (degrees >= 305 && degrees <= 325) {
            return "NW";
        } else if (degrees >= 326 && degrees <= 349) {
            return "NNW";
        } else if (degrees >= 350 && degrees <= 360) {
            return "N";
        } else if (degrees == -1) {
            return "Variable";
        } else {
            return "Unknown";
        }
    }
}
