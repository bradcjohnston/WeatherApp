package com.example.brad.adapterandlistviewtest;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by brad on 2/24/15.
 */
public interface Api {
    @GET("/weather")
    void getWeather(@Query("q") String cityName, Callback<Clouds> cloudsCallback);
}
