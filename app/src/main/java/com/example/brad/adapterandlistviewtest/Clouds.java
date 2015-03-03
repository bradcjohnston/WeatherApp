package com.example.brad.adapterandlistviewtest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


    public class Clouds {

        private int all;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The all
         */
        public int getAll() {
            return all;
        }

        /**
         * @param all The all
         */
        public void setAll(int all) {
            this.all = all;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }



    public static class Coord {

        private double lon;
        private double lat;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The lon
         */
        public double getLon() {
            return lon;
        }

        /**
         * @param lon The lon
         */
        public void setLon(double lon) {
            this.lon = lon;
        }

        /**
         * @return The lat
         */
        public double getLat() {
            return lat;
        }

        /**
         * @param lat The lat
         */
        public void setLat(double lat) {
            this.lat = lat;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    public static class Main {

        private double temp;
        private double tempMin;
        private double tempMax;
        private double pressure;
        private double seaLevel;
        private double grndLevel;
        private int humidity;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The temp
         */
        public double getTemp() {
            return temp;
        }

        /**
         * @param temp The temp
         */
        public void setTemp(double temp) {
            this.temp = temp;
        }

        /**
         * @return The tempMin
         */
        public double getTempMin() {
            return tempMin;
        }

        /**
         * @param tempMin The temp_min
         */
        public void setTempMin(double tempMin) {
            this.tempMin = tempMin;
        }

        /**
         * @return The tempMax
         */
        public double getTempMax() {
            return tempMax;
        }

        /**
         * @param tempMax The temp_max
         */
        public void setTempMax(double tempMax) {
            this.tempMax = tempMax;
        }

        /**
         * @return The pressure
         */
        public double getPressure() {
            return pressure;
        }

        /**
         * @param pressure The pressure
         */
        public void setPressure(double pressure) {
            this.pressure = pressure;
        }

        /**
         * @return The seaLevel
         */
        public double getSeaLevel() {
            return seaLevel;
        }

        /**
         * @param seaLevel The sea_level
         */
        public void setSeaLevel(double seaLevel) {
            this.seaLevel = seaLevel;
        }

        /**
         * @return The grndLevel
         */
        public double getGrndLevel() {
            return grndLevel;
        }

        /**
         * @param grndLevel The grnd_level
         */
        public void setGrndLevel(double grndLevel) {
            this.grndLevel = grndLevel;
        }

        /**
         * @return The humidity
         */
        public int getHumidity() {
            return humidity;
        }

        /**
         * @param humidity The humidity
         */
        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    public static class Sys {

        private double message;
        private String country;
        private int sunrise;
        private int sunset;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The message
         */
        public double getMessage() {
            return message;
        }

        /**
         * @param message The message
         */
        public void setMessage(double message) {
            this.message = message;
        }

        /**
         * @return The country
         */
        public String getCountry() {
            return country;
        }

        /**
         * @param country The country
         */
        public void setCountry(String country) {
            this.country = country;
        }

        /**
         * @return The sunrise
         */
        public int getSunrise() {
            return sunrise;
        }

        /**
         * @param sunrise The sunrise
         */
        public void setSunrise(int sunrise) {
            this.sunrise = sunrise;
        }

        /**
         * @return The sunset
         */
        public int getSunset() {
            return sunset;
        }

        /**
         * @param sunset The sunset
         */
        public void setSunset(int sunset) {
            this.sunset = sunset;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    public static class Weather {

        private Coord coord;
        private Sys sys;
        private List<Weather_> weather = new ArrayList<Weather_>();
        private String base;
        private Main main;
        private Wind wind;
        private Clouds clouds;
        private int dt;
        private int id;
        private String name;
        private int cod;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The coord
         */
        public Coord getCoord() {
            return coord;
        }

        /**
         * @param coord The coord
         */
        public void setCoord(Coord coord) {
            this.coord = coord;
        }

        /**
         * @return The sys
         */
        public Sys getSys() {
            return sys;
        }

        /**
         * @param sys The sys
         */
        public void setSys(Sys sys) {
            this.sys = sys;
        }

        /**
         * @return The weather
         */
        public List<Weather_> getWeather() {
            return weather;
        }

        /**
         * @param weather The weather
         */
        public void setWeather(List<Weather_> weather) {
            this.weather = weather;
        }

        /**
         * @return The base
         */
        public String getBase() {
            return base;
        }

        /**
         * @param base The base
         */
        public void setBase(String base) {
            this.base = base;
        }

        /**
         * @return The main
         */
        public Main getMain() {
            return main;
        }

        /**
         * @param main The main
         */
        public void setMain(Main main) {
            this.main = main;
        }

        /**
         * @return The wind
         */
        public Wind getWind() {
            return wind;
        }

        /**
         * @param wind The wind
         */
        public void setWind(Wind wind) {
            this.wind = wind;
        }

        /**
         * @return The clouds
         */
        public Clouds getClouds() {
            return clouds;
        }

        /**
         * @param clouds The clouds
         */
        public void setClouds(Clouds clouds) {
            this.clouds = clouds;
        }

        /**
         * @return The dt
         */
        public int getDt() {
            return dt;
        }

        /**
         * @param dt The dt
         */
        public void setDt(int dt) {
            this.dt = dt;
        }

        /**
         * @return The id
         */
        public int getId() {
            return id;
        }

        /**
         * @param id The id
         */
        public void setId(int id) {
            this.id = id;
        }

        /**
         * @return The name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name The name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * @return The cod
         */
        public int getCod() {
            return cod;
        }

        /**
         * @param cod The cod
         */
        public void setCod(int cod) {
            this.cod = cod;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    public static class Weather_ {

        private int id;
        private String main;
        private String description;
        private String icon;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The id
         */
        public int getId() {
            return id;
        }

        /**
         * @param id The id
         */
        public void setId(int id) {
            this.id = id;
        }

        /**
         * @return The main
         */
        public String getMain() {
            return main;
        }

        /**
         * @param main The main
         */
        public void setMain(String main) {
            this.main = main;
        }

        /**
         * @return The description
         */
        public String getDescription() {
            return description;
        }

        /**
         * @param description The description
         */
        public void setDescription(String description) {
            this.description = description;
        }

        /**
         * @return The icon
         */
        public String getIcon() {
            return icon;
        }

        /**
         * @param icon The icon
         */
        public void setIcon(String icon) {
            this.icon = icon;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    public static class Wind {

        private double speed;
        private double deg;
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * @return The speed
         */
        public double getSpeed() {
            return speed;
        }

        /**
         * @param speed The speed
         */
        public void setSpeed(double speed) {
            this.speed = speed;
        }

        /**
         * @return The deg
         */
        public double getDeg() {
            return deg;
        }

        /**
         * @param deg The deg
         */
        public void setDeg(double deg) {
            this.deg = deg;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

    }
}
