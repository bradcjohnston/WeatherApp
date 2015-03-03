package com.example.brad.adapterandlistviewtest;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by brad on 2/25/15.
 */
public class WeatherArrayAdapter extends ArrayAdapter<Clouds> {
    public WeatherArrayAdapter(Context context, List<Clouds> objects) {
        super(context, android.R.layout.simple_list_item_1, objects);

    }
}
