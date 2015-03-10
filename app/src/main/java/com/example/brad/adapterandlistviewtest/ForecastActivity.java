package com.example.brad.adapterandlistviewtest;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class ForecastActivity extends ListActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        Log.v("Activity3", "Started");

        Intent intent = getIntent();
        ArrayList<String> weather= intent.getStringArrayListExtra("weatherArray");
        Log.v("Activity3", "Testing " + weather.toString());
        ArrayList<Weather> arrayList = new ArrayList<>();

        for (int i = 0; i < weather.size() - 1; i = i + 3) {
            Weather obj = new Weather(weather.get(i), weather.get(i + 1), weather.get(i + 2), R.drawable.unknown90x90placeholder);
                   Log.v("Short Desc Test", weather.get(i+2));
                    if (obj.getShortDescription().equals("Clouds")) {
                        obj.setWeatherImage(R.drawable.cloudy90x90);
                    }
                    else if (obj.getShortDescription().equals("Rain")) {
                        obj.setWeatherImage(R.drawable.rain90x90);
                    }
                    else if (obj.getShortDescription().equals("Clear")) {
                        obj.setWeatherImage(R.drawable.sunny90x90);
                    }

            arrayList.add(obj);
        }
        WeatherAdapter viewHolder = new WeatherAdapter(ForecastActivity.this, R.id.fifteen_day_forecast_button);
        viewHolder.addAll(arrayList);
        setListAdapter(viewHolder);

    }
}
