package com.example.brad.adapterandlistviewtest;

import android.content.Context;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.util.Date;


public class MainActivity extends ActionBarActivity {

    View mView;
    Context context;
    TextView mTextView;
    TextView mTextView2;
    TextView mTextView3;
    TextView mTextView4;
    TextView mTextView5;
    TextView mTextView6;
    ImageView mImageView;
    String jsonString;

    Button mButton;
    Button mfiveDayForecastButton;

//TODO clean styling

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);


        Typeface helvetica = Typeface.createFromAsset(getAssets(), "fonts/HelveticaNeueThn.ttf");

        mTextView = (TextView) findViewById(R.id.textView_town);
        mTextView.setTypeface(helvetica);
        mTextView.setText("Loading");
        mTextView2 = (TextView) findViewById(R.id.textView2);
        mTextView2.setTypeface(helvetica);
        mTextView2.setText("Load");
        mTextView4 = (TextView) findViewById(R.id.textView4);
        mTextView4.setTypeface(helvetica);
        mTextView4.setText("Loading");
        mImageView = (ImageView) findViewById(R.id.imageView);
        Picasso.with(this).load(R.drawable.black400x400placeholder).into(mImageView);
        mTextView6 = (TextView) findViewById(R.id.textView6);
        mTextView6.setTypeface(helvetica);
        mTextView6.setText("Loading");
        mButton = (Button) findViewById(R.id.button);
        mButton.setTypeface(helvetica);
        mfiveDayForecastButton = (Button) findViewById(R.id.five_day_forecast_button);
        mfiveDayForecastButton.setTypeface(helvetica);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWeatherAndUpdateMainDisplay getweather = new getWeatherAndUpdateMainDisplay();
                getweather.execute();
            }
        });

        mfiveDayForecastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWeatherAndUpdateDisplayFiveDay getweather = new getWeatherAndUpdateDisplayFiveDay();
                getweather.execute();
            }
        });


        // JSONObject weather = getJSONObject("weather");
        // JSONObject weatherJson = new JSONObject(json, "weather");
        // WeatherArrayAdapter adapter = new WeatherArrayAdapter();
        // mListView.setAdapter(adapter);

        //callWeatherAPI();

        // mTextView.setText(test.toString());

        /*RestAdapter restAdapter = n   ew RestAdapter.Builder()
                .setEndpoint("http://www.reddit.com/r/programming")
                .build();


        RedditHotInterface RedditHotService = restAdapter.create(RedditHotInterface.class);

        RedditHotService = restAdapter.create(RedditHotInterface.class);

        RedditHotService.getStreams(new Callback <List<RedditHotResponse>>() {
            @Override
            public void success(RedditHotResponse reddithotresponse, Response response) {
                consumeApiData(RedditHot);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                consumeApiData(null);
            }
        });

        Log.v("index=" + RedditHotResponse.getResults());


        ListView list = (ListView) findViewById(R.id.listView);

        ArrayAdapter adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, items);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = ((TextView)view).getText().toString();

                StringBuilder string = new StringBuilder();
                string.append("http://www.bing.com/search?1=");
                string.append(item);


                Toast.makeText(getBaseContext(), string, Toast.LENGTH_LONG).show();



                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(string.toString()));
                startActivity(intent);

                Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();
            }
        });
    }*/



            }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

    /*public void callWeatherAPI() {
        Api weatherAPI = APIHandler.getApiInterface();
        weatherAPI.getWeather("Muncie.", new Callback<Clouds>() {

            @Override
            public void success(Clouds clouds, Response response) {

                Toast.makeText(getApplicationContext(), clouds.toString(), Toast.LENGTH_LONG)
                        .show();
                Log.v("Clouds", Integer.toString(clouds.getAll()));
                //Log.v("Clouds", Double.toString(clouds.Main.getTemp()));
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                Log.v("hi", retrofitError.getCause().toString());
                Toast.makeText(getApplicationContext(), "OPS, some kind of problem had happend! :(",
                        Toast.LENGTH_LONG).show();
            }
        });
    }*/


    private class getWeatherAndUpdateMainDisplay extends AsyncTask<Void, Void, String> {
        String data;
        int temp;
        Double windSpeed;
        String windDirection;
        String townName;
        String weatherShortDescription;
        String weatherLongDescription;
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());


        @Override
        protected String doInBackground(Void... urls) {

            WeatherHttpClient weatherHttpClient = new WeatherHttpClient();
            try {
                data = weatherHttpClient.getWeatherData("weather?q=Muncie");
            } catch (Exception e) {
                Log.v("ERROR", e.toString());

            }

            try {

                JSONObject json = new JSONObject(data);
                Conversions conversions = new Conversions();

                temp = conversions.tempFromCelciusToFahrenheit(json.getJSONObject("main").getDouble("temp"));
                windSpeed = json.getJSONObject("wind").getDouble("speed");
                windDirection = conversions.windDirectionFromDegrees(json.getJSONObject("wind").getDouble("deg"));
                townName = json.getString("name");
                weatherShortDescription = json.getJSONArray("weather").getJSONObject(0).getString("main");
                weatherLongDescription = json.getJSONArray("weather").getJSONObject(0).getString("description");

                //TODO text graphic
                //TODO 5 day forecast
                //TODO local storage

            } catch (JSONException e) {
                Log.e("MYAPP", "unexpected JSON exception", e);
            }
            return data;
        }

        @Override
        protected void onPostExecute(String result) {

            mTextView.setText(townName);
            mTextView.setVisibility(View.VISIBLE);
            mTextView2.setText(String.valueOf(temp));
            mTextView2.setVisibility(View.VISIBLE);
            //mTextView3.setText(windSpeed.toString());
            mTextView4.setText(weatherShortDescription);
            mTextView4.setVisibility(View.VISIBLE);
            mTextView6.setText("Last updated: " + currentDateTimeString);
            mTextView6.setVisibility(View.VISIBLE);
            //mTextView6.setText(windDirection.toString());
            Picasso.with(context).load(R.drawable.stormyweathericon).resize(300, 300).into(mImageView);
            mImageView.setVisibility(View.VISIBLE);

        }
    }

    private class getWeatherAndUpdateDisplayFiveDay extends AsyncTask<Void, Void, String> {
        String data;
        int temp;
        Double windSpeed;
        String townName;
        String weatherShortDescription;
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());


        @Override
        protected String doInBackground(Void... urls) {

            WeatherHttpClient weatherHttpClient = new WeatherHttpClient();
            try {
                data = weatherHttpClient.getWeatherData("daily?q=Muncie,US&cnt=5");
            } catch (Exception e) {
                Log.v("ERROR", e.toString());

            }

            jsonString = "{\"cod\":\"200\",\"message\":0.1741,\"city\":{\"id\":\"4517009\",\"name\":\"London\",\"coord\":{\"lon\":-83.4481,\"lat\":39.886},\"country\":\"United States of America\",\"population\":0},\"cnt\":35,\"list\":[{\"dt\":1425319200,\"main\":{\"temp\":268.04,\"temp_min\":267.395,\"temp_max\":268.04,\"pressure\":1011.63,\"sea_level\":1048.01,\"grnd_level\":1011.63,\"humidity\":100,\"temp_kf\":0.65},\"weather\":[{\"id\":600,\"main\":\"Snow\",\"description\":\"light snow\",\"icon\":\"13d\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":2.02,\"deg\":318.001},\"snow\":{\"3h\":0.05},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2015-03-02 18:00:00\"},{\"dt\":1425330000,\"main\":{\"temp\":268.65,\"temp_min\":268.041,\"temp_max\":268.65,\"pressure\":1009.92,\"sea_level\":1046.16,\"grnd_level\":1009.92,\"humidity\":93,\"temp_kf\":0.61},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01d\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":1.91,\"deg\":344.502},\"snow\":{\"3h\":0},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2015-03-02 21:00:00\"},{\"dt\":1425340800,\"main\":{\"temp\":261.99,\"temp_min\":261.407,\"temp_max\":261.99,\"pressure\":1009.34,\"sea_level\":1046.17,\"grnd_level\":1009.34,\"humidity\":78,\"temp_kf\":0.58},\"weather\":[{\"id\":801,\"main\":\"Clouds\",\"description\":\"few clouds\",\"icon\":\"02n\"}],\"clouds\":{\"all\":24},\"wind\":{\"speed\":1.16,\"deg\":356.501},\"snow\":{\"3h\":0},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2015-03-03 00:00:00\"},{\"dt\":1425351600,\"main\":{\"temp\":259.11,\"temp_min\":258.562,\"temp_max\":259.11,\"pressure\":1008.52,\"sea_level\":1045.64,\"grnd_level\":1008.52,\"humidity\":57,\"temp_kf\":0.55},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03n\"}],\"clouds\":{\"all\":44},\"wind\":{\"speed\":1.41,\"deg\":12.5043},\"snow\":{\"3h\":0},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2015-03-03 03:00:00\"},{\"dt\":1425362400,\"main\":{\"temp\":263.44,\"temp_min\":262.921,\"temp_max\":263.44,\"pressure\":1005.88,\"sea_level\":1042.93,\"grnd_level\":1005.88,\"humidity\":75,\"temp_kf\":0.52},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":88},\"wind\":{\"speed\":2.37,\"deg\":54.5002},\"snow\":{\"3h\":0},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2015-03-03 06:00:00\"},{\"dt\":1425373200,\"main\":{\"temp\":266.42,\"temp_min\":265.936,\"temp_max\":266.42,\"pressure\":1003.23,\"sea_level\":1040.11,\"grnd_level\":1003.23,\"humidity\":81,\"temp_kf\":0.48},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":88},\"wind\":{\"speed\":2.96,\"deg\":91.0107},\"snow\":{\"3h\":0},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2015-03-03 09:00:00\"},{\"dt\":1425384000,\"main\":{\"temp\":268.15,\"temp_min\":267.702,\"temp_max\":268.15,\"pressure\":1001.08,\"sea_level\":1037.68,\"grnd_level\":1001.08,\"humidity\":87,\"temp_kf\":0.45},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":92},\"wind\":{\"speed\":3.76,\"deg\":109.001},\"snow\":{\"3h\":0},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2015-03-03 12:00:00\"},{\"dt\":1425394800,\"main\":{\"temp\":272.05,\"temp_min\":271.628,\"temp_max\":272.05,\"pressure\":997.79,\"sea_level\":1034.19,\"grnd_level\":997.79,\"humidity\":100,\"temp_kf\":0.42},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":92},\"wind\":{\"speed\":4.09,\"deg\":121.002},\"snow\":{\"3h\":0},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2015-03-03 15:00:00\"},{\"dt\":1425405600,\"main\":{\"temp\":273.47,\"temp_min\":273.08,\"temp_max\":273.47,\"pressure\":994.13,\"sea_level\":1029.83,\"grnd_level\":994.13,\"humidity\":100,\"temp_kf\":0.39},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":92},\"wind\":{\"speed\":3.41,\"deg\":152.503},\"snow\":{\"3h\":0},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2015-03-03 18:00:00\"},{\"dt\":1425416400,\"main\":{\"temp\":275.44,\"temp_min\":275.087,\"temp_max\":275.44,\"pressure\":989.46,\"sea_level\":1024.61,\"grnd_level\":989.46,\"humidity\":94,\"temp_kf\":0.36},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":{\"all\":92},\"wind\":{\"speed\":5.11,\"deg\":189.501},\"snow\":{\"3h\":0},\"rain\":{\"3h\":2.5},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2015-03-03 21:00:00\"},{\"dt\":1425427200,\"main\":{\"temp\":276.93,\"temp_min\":276.61,\"temp_max\":276.93,\"pressure\":987.24,\"sea_level\":1022.22,\"grnd_level\":987.24,\"humidity\":85,\"temp_kf\":0.32},\"weather\":[{\"id\":501,\"main\":\"Rain\",\"description\":\"moderate rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":92},\"wind\":{\"speed\":6.16,\"deg\":213.506},\"snow\":{\"3h\":0},\"rain\":{\"3h\":3.5},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2015-03-04 00:00:00\"},{\"dt\":1425438000,\"main\":{\"temp\":277.24,\"temp_min\":276.948,\"temp_max\":277.24,\"pressure\":986.66,\"sea_level\":1021.72,\"grnd_level\":986.66,\"humidity\":83,\"temp_kf\":0.29},\"weather\":[{\"id\":501,\"main\":\"Rain\",\"description\":\"moderate rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":92},\"wind\":{\"speed\":5.61,\"deg\":241.501},\"snow\":{\"3h\":0},\"rain\":{\"3h\":4.5},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2015-03-04 03:00:00\"},{\"dt\":1425448800,\"main\":{\"temp\":276.5,\"temp_min\":276.246,\"temp_max\":276.5,\"pressure\":986.41,\"sea_level\":1021.41,\"grnd_level\":986.41,\"humidity\":87,\"temp_kf\":0.26},\"weather\":[{\"id\":501,\"main\":\"Rain\",\"description\":\"moderate rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":5.2,\"deg\":278.503},\"snow\":{\"3h\":0},\"rain\":{\"3h\":5},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2015-03-04 06:00:00\"},{\"dt\":1425459600,\"main\":{\"temp\":275.5,\"temp_min\":275.276,\"temp_max\":275.5,\"pressure\":986.17,\"sea_level\":1021.09,\"grnd_level\":986.17,\"humidity\":88,\"temp_kf\":0.23},\"weather\":[{\"id\":501,\"main\":\"Rain\",\"description\":\"moderate rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":92},\"wind\":{\"speed\":2.95,\"deg\":266.001},\"snow\":{\"3h\":0},\"rain\":{\"3h\":5},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2015-03-04 09:00:00\"},{\"dt\":1425470400,\"main\":{\"temp\":275.37,\"temp_min\":275.18,\"temp_max\":275.37,\"pressure\":987.01,\"sea_level\":1022,\"grnd_level\":987.01,\"humidity\":87,\"temp_kf\":0.19},\"weather\":[{\"id\":501,\"main\":\"Rain\",\"description\":\"moderate rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":92},\"wind\":{\"speed\":1.57,\"deg\":222.505},\"snow\":{\"3h\":0},\"rain\":{\"3h\":5.5},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2015-03-04 12:00:00\"},{\"dt\":1425481200,\"main\":{\"temp\":275.88,\"temp_min\":275.717,\"temp_max\":275.88,\"pressure\":988.73,\"sea_level\":1023.86,\"grnd_level\":988.73,\"humidity\":92,\"temp_kf\":0.16},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":{\"all\":92},\"wind\":{\"speed\":3.77,\"deg\":270.005},\"snow\":{\"3h\":0},\"rain\":{\"3h\":3},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2015-03-04 15:00:00\"},{\"dt\":1425492000,\"main\":{\"temp\":274.37,\"temp_min\":274.243,\"temp_max\":274.37,\"pressure\":991.09,\"sea_level\":1026.18,\"grnd_level\":991.09,\"humidity\":100,\"temp_kf\":0.13},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":{\"all\":92},\"wind\":{\"speed\":4.96,\"deg\":319.502},\"snow\":{\"3h\":0},\"rain\":{\"3h\":1},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2015-03-04 18:00:00\"},{\"dt\":1425502800,\"main\":{\"temp\":273.15,\"temp_min\":273.055,\"temp_max\":273.15,\"pressure\":991.56,\"sea_level\":1027.09,\"grnd_level\":991.56,\"humidity\":100,\"temp_kf\":0.1},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":{\"all\":92},\"wind\":{\"speed\":4.86,\"deg\":320.502},\"snow\":{\"3h\":1},\"rain\":{\"3h\":1},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2015-03-04 21:00:00\"},{\"dt\":1425513600,\"main\":{\"temp\":269.24,\"temp_min\":269.18,\"temp_max\":269.24,\"pressure\":994.66,\"sea_level\":1030.57,\"grnd_level\":994.66,\"humidity\":98,\"temp_kf\":0.06},\"weather\":[{\"id\":601,\"main\":\"Snow\",\"description\":\"snow\",\"icon\":\"13n\"}],\"clouds\":{\"all\":92},\"wind\":{\"speed\":6.32,\"deg\":318.5},\"snow\":{\"3h\":2.75},\"rain\":{\"3h\":0},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2015-03-05 00:00:00\"},{\"dt\":1425524400,\"main\":{\"temp\":265.75,\"temp_min\":265.714,\"temp_max\":265.75,\"pressure\":998.63,\"sea_level\":1034.93,\"grnd_level\":998.63,\"humidity\":91,\"temp_kf\":0.03},\"weather\":[{\"id\":600,\"main\":\"Snow\",\"description\":\"light snow\",\"icon\":\"13n\"}],\"clouds\":{\"all\":92},\"wind\":{\"speed\":6.41,\"deg\":324.004},\"snow\":{\"3h\":1.5},\"rain\":{\"3h\":0},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2015-03-05 03:00:00\"},{\"dt\":1425535200,\"main\":{\"temp\":262.88,\"temp_min\":262.88,\"temp_max\":262.88,\"pressure\":1000.54,\"sea_level\":1037.32,\"grnd_level\":1000.54,\"humidity\":86},\"weather\":[{\"id\":600,\"main\":\"Snow\",\"description\":\"light snow\",\"icon\":\"13n\"}],\"clouds\":{\"all\":92},\"wind\":{\"speed\":6.45,\"deg\":330.004},\"snow\":{\"3h\":1},\"rain\":{\"3h\":0},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2015-03-05 06:00:00\"},{\"dt\":1425546000,\"main\":{\"temp\":261.829,\"temp_min\":261.829,\"temp_max\":261.829,\"pressure\":1002.11,\"sea_level\":1039.22,\"grnd_level\":1002.11,\"humidity\":87},\"weather\":[{\"id\":600,\"main\":\"Snow\",\"description\":\"light snow\",\"icon\":\"13n\"}],\"clouds\":{\"all\":92},\"wind\":{\"speed\":5.31,\"deg\":331.002},\"snow\":{\"3h\":1},\"rain\":{\"3h\":0},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2015-03-05 09:00:00\"},{\"dt\":1425556800,\"main\":{\"temp\":261.322,\"temp_min\":261.322,\"temp_max\":261.322,\"pressure\":1003.64,\"sea_level\":1041.09,\"grnd_level\":1003.64,\"humidity\":91},\"weather\":[{\"id\":600,\"main\":\"Snow\",\"description\":\"light snow\",\"icon\":\"13d\"}],\"clouds\":{\"all\":92},\"wind\":{\"speed\":3.51,\"deg\":323.004},\"snow\":{\"3h\":1.25},\"rain\":{\"3h\":0},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2015-03-05 12:00:00\"},{\"dt\":1425567600,\"main\":{\"temp\":261.602,\"temp_min\":261.602,\"temp_max\":261.602,\"pressure\":1005.49,\"sea_level\":1042.83,\"grnd_level\":1005.49,\"humidity\":89},\"weather\":[{\"id\":600,\"main\":\"Snow\",\"description\":\"light snow\",\"icon\":\"13d\"}],\"clouds\":{\"all\":92},\"wind\":{\"speed\":4.14,\"deg\":307},\"snow\":{\"3h\":0.75},\"rain\":{\"3h\":0},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2015-03-05 15:00:00\"},{\"dt\":1425578400,\"main\":{\"temp\":262.263,\"temp_min\":262.263,\"temp_max\":262.263,\"pressure\":1007.05,\"sea_level\":1044.45,\"grnd_level\":1007.05,\"humidity\":97},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":{\"all\":32},\"wind\":{\"speed\":5.72,\"deg\":297.504},\"snow\":{\"3h\":0},\"rain\":{\"3h\":1},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2015-03-05 18:00:00\"},{\"dt\":1425589200,\"main\":{\"temp\":261.883,\"temp_min\":261.883,\"temp_max\":261.883,\"pressure\":1009.43,\"sea_level\":1046.87,\"grnd_level\":1009.43,\"humidity\":87},\"weather\":[{\"id\":801,\"main\":\"Clouds\",\"description\":\"few clouds\",\"icon\":\"02d\"}],\"clouds\":{\"all\":12},\"wind\":{\"speed\":6.41,\"deg\":297.501},\"snow\":{\"3h\":0},\"rain\":{\"3h\":0},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2015-03-05 21:00:00\"},{\"dt\":1425600000,\"main\":{\"temp\":257.311,\"temp_min\":257.311,\"temp_max\":257.311,\"pressure\":1012.72,\"sea_level\":1050.52,\"grnd_level\":1012.72,\"humidity\":73},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01n\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":3.72,\"deg\":295.002},\"snow\":{\"3h\":0},\"rain\":{\"3h\":0},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2015-03-06 00:00:00\"},{\"dt\":1425610800,\"main\":{\"temp\":251.918,\"temp_min\":251.918,\"temp_max\":251.918,\"pressure\":1014.94,\"sea_level\":1053.23,\"grnd_level\":1014.94,\"humidity\":58},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01n\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":3.02,\"deg\":289.502},\"snow\":{\"3h\":0},\"rain\":{\"3h\":0},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2015-03-06 03:00:00\"},{\"dt\":1425621600,\"main\":{\"temp\":247.056,\"temp_min\":247.056,\"temp_max\":247.056,\"pressure\":1015.65,\"sea_level\":1054.41,\"grnd_level\":1015.65,\"humidity\":45},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01n\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":2.21,\"deg\":282.501},\"snow\":{\"3h\":0},\"rain\":{\"3h\":0},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2015-03-06 06:00:00\"},{\"dt\":1425632400,\"main\":{\"temp\":245.007,\"temp_min\":245.007,\"temp_max\":245.007,\"pressure\":1016.06,\"sea_level\":1055.01,\"grnd_level\":1016.06,\"humidity\":27},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01n\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":1.37,\"deg\":289.001},\"snow\":{\"3h\":0},\"rain\":{\"3h\":0},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2015-03-06 09:00:00\"},{\"dt\":1425643200,\"main\":{\"temp\":244.317,\"temp_min\":244.317,\"temp_max\":244.317,\"pressure\":1017.27,\"sea_level\":1056.37,\"grnd_level\":1017.27,\"humidity\":29},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01d\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":1.32,\"deg\":210.003},\"snow\":{\"3h\":0},\"rain\":{\"3h\":0},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2015-03-06 12:00:00\"},{\"dt\":1425654000,\"main\":{\"temp\":256.52,\"temp_min\":256.52,\"temp_max\":256.52,\"pressure\":1018.57,\"sea_level\":1056.88,\"grnd_level\":1018.57,\"humidity\":68},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01d\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":2.16,\"deg\":208.502},\"snow\":{\"3h\":0},\"rain\":{\"3h\":0},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2015-03-06 15:00:00\"},{\"dt\":1425664800,\"main\":{\"temp\":261.229,\"temp_min\":261.229,\"temp_max\":261.229,\"pressure\":1017.39,\"sea_level\":1054.9,\"grnd_level\":1017.39,\"humidity\":100},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01d\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":2.06,\"deg\":215.009},\"snow\":{\"3h\":0},\"rain\":{\"3h\":0},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2015-03-06 18:00:00\"},{\"dt\":1425675600,\"main\":{\"temp\":263.468,\"temp_min\":263.468,\"temp_max\":263.468,\"pressure\":1015.08,\"sea_level\":1052.15,\"grnd_level\":1015.08,\"humidity\":94},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01d\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":1.96,\"deg\":226.505},\"snow\":{\"3h\":0},\"rain\":{\"3h\":0},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2015-03-06 21:00:00\"},{\"dt\":1425686400,\"main\":{\"temp\":254.72,\"temp_min\":254.72,\"temp_max\":254.72,\"pressure\":1014.62,\"sea_level\":1052.23,\"grnd_level\":1014.62,\"humidity\":68},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"sky is clear\",\"icon\":\"01n\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":1.41,\"deg\":187.501},\"snow\":{\"3h\":0},\"rain\":{\"3h\":0},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2015-03-07 00:00:00\"}]}";

            try {

                JSONObject json = new JSONObject(jsonString);
                Conversions conversions = new Conversions();
                String cityName = json.getJSONObject("city").getString("name");

                JSONArray list = json.getJSONArray("list");


                Weather weather0 = new Weather(0, cityName, conversions.tempFromCelciusToFahrenheit(list.getJSONObject(0).getJSONObject("main").getDouble("temp")), list.getJSONObject(0).getJSONArray("weather").getJSONObject(0).getString("main"));
                Weather weather1 = new Weather(1, cityName, conversions.tempFromCelciusToFahrenheit(list.getJSONObject(1).getJSONObject("main").getDouble("temp")), list.getJSONObject(1).getJSONArray("weather").getJSONObject(0).getString("main"));
                Weather weather2 = new Weather(2, cityName, conversions.tempFromCelciusToFahrenheit(list.getJSONObject(2).getJSONObject("main").getDouble("temp")), list.getJSONObject(2).getJSONArray("weather").getJSONObject(0).getString("main"));
                Weather weather3 = new Weather(3, cityName, conversions.tempFromCelciusToFahrenheit(list.getJSONObject(3).getJSONObject("main").getDouble("temp")), list.getJSONObject(3).getJSONArray("weather").getJSONObject(0).getString("main"));
                Weather weather4 = new Weather(4, cityName, conversions.tempFromCelciusToFahrenheit(list.getJSONObject(4).getJSONObject("main").getDouble("temp")), list.getJSONObject(4).getJSONArray("weather").getJSONObject(0).getString("main"));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        return data;
        }

        @Override
        protected void onPostExecute(String result) {

            mTextView.setText(townName);
            mTextView2.setText(String.valueOf(temp));
            //mTextView3.setText(windSpeed.toString());
            mTextView4.setText(weatherShortDescription);
            mTextView6.setText("Last updated: " + currentDateTimeString);
            //mTextView6.setText(windDirection.toString());
            Picasso.with(context).load(R.drawable.stormyweathericon).resize(300, 300).into(mImageView);

        }
    }
}

