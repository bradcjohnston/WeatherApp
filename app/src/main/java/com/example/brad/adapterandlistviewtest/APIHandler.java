/*package com.example.brad.adapterandlistviewtest;

import android.util.Log;

import retrofit.RestAdapter;

*//**
 * Created by brad on 2/24/15.
 *//*
public class APIHandler {

    private static final String API_URL = "http://api.openweathermap.org/data/2.5";
    private static RestAdapter sRestAdapter;

    public static RestAdapter getRestAdapter() {
        if (sRestAdapter == null) {
            sRestAdapter = new RestAdapter.Builder()
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .setEndpoint(API_URL)
                    .build();
        }
        return sRestAdapter;
    }
    public static Api getApiInterface() {
        //Create an instance of our API Interface
        Api weatherAPI = null;
        try {
            if (sRestAdapter == null) {
                sRestAdapter = getRestAdapter();
            }
            weatherAPI = sRestAdapter.create(Api.class);
            }
         catch (Exception e) {
             e.printStackTrace();
        }
        Log.v("Work","Something is happening");
        return weatherAPI;
    }


}*/
