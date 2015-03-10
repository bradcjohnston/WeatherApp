package com.example.brad.adapterandlistviewtest;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;


public class MainActivity extends ActionBarActivity implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    View mView;
    Context context;
    TextView mTownTextView;
    TextView mTempTextView;
    TextView mTextView3;
    TextView mWeatherShortDescTextView;
    TextView mTextView5;
    TextView mLastUpdatedTextView;
    ImageView mWeatherImage;
    String jsonString;

    Button mGetWeatherButton;
    Button mFifteenDayForecastButton;
    Button mGetGpsLocationButton;
    String mCityInputText="";
    ProgressBar mProgressBar;


    //GoogleApiClient mGoogleApiClient;

//TODO clean styling

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);


        Typeface helvetica = Typeface.createFromAsset(getAssets(), "fonts/HelveticaNeueThn.ttf");

        mTownTextView = (TextView) findViewById(R.id.textView_town);
        mTownTextView.setTypeface(helvetica);
        mTownTextView.setText("Loading");
        mTempTextView = (TextView) findViewById(R.id.textView2);
        mTempTextView.setTypeface(helvetica);
        mTempTextView.setText("Load");
        mWeatherShortDescTextView = (TextView) findViewById(R.id.textView4);
        mWeatherShortDescTextView.setTypeface(helvetica);
        mWeatherShortDescTextView.setText("Loading");
        mWeatherImage = (ImageView) findViewById(R.id.imageView);
        Picasso.with(this).load(R.drawable.black400x400placeholder).into(mWeatherImage);
        mLastUpdatedTextView = (TextView) findViewById(R.id.textView6);
        mLastUpdatedTextView.setTypeface(helvetica);
        mLastUpdatedTextView.setText("Loading");
        mGetWeatherButton = (Button) findViewById(R.id.button);
        mGetWeatherButton.setTypeface(helvetica);
        mFifteenDayForecastButton = (Button) findViewById(R.id.fifteen_day_forecast_button);
        mFifteenDayForecastButton.setTypeface(helvetica);
        mGetGpsLocationButton = (Button) findViewById(R.id.gps_location_button);
        mGetGpsLocationButton.setTypeface(helvetica);

        /*GoogleApiClient mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();*/

        mGetWeatherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWeatherAndUpdateMainDisplay getweather = new getWeatherAndUpdateMainDisplay();
                getweather.execute();
            }
        });

        mFifteenDayForecastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWeatherAndUpdateDisplayFiveDay getweather = new getWeatherAndUpdateDisplayFiveDay();
                getweather.execute();
            }
        });

        mGetGpsLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayCityDialog();
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

     private void onDisplay() {
         /*Location mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
         String lastKnownLocationString = mLastLocation.toString();
         Toast.makeText(getBaseContext(),lastKnownLocationString, Toast.LENGTH_LONG).show();*/

         //TODO:Check for install of Google Play Services
     }

    @Override
    protected void onStart() {
        super.onStart();
      //  mGoogleApiClient.connect();
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
    private void displayCityDialog() {
        final EditText input = new EditText(this);

        new AlertDialog.Builder(MainActivity.this)
                .setTitle("Input City")
                .setMessage("Please input city")
                .setView(input)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        mCityInputText = input.getText().toString();
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Do nothing.
            }
        }).show();

    }

    private class getWeatherAndUpdateMainDisplay extends AsyncTask<Void, Void, String> {
        String data;
        String temp;
        Double windSpeed;
        String windDirection;
        String townName;
        String weatherShortDescription;
        String weatherLongDescription;
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        String cityName;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressBar = (ProgressBar)findViewById(R.id.progress_bar);
            mProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(Void... urls) {

            if (mCityInputText.equals("")) {
                cityName = "Muncie";
            }
                else {
                cityName = mCityInputText;
            }

            WeatherHttpClient weatherHttpClient = new WeatherHttpClient();
            try {
                data = weatherHttpClient.getWeatherData("weather?q=" + cityName);
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
            mProgressBar.setVisibility(View.INVISIBLE);

            mTownTextView.setText(townName);
            mTownTextView.setVisibility(View.VISIBLE);
            mTempTextView.setText(temp);
            mTempTextView.setVisibility(View.VISIBLE);
            //mTextView3.setText(windSpeed.toString());
            mWeatherShortDescTextView.setText(weatherShortDescription);
            mWeatherShortDescTextView.setVisibility(View.VISIBLE);
            mLastUpdatedTextView.setText("Last updated: " + currentDateTimeString);
            mLastUpdatedTextView.setVisibility(View.VISIBLE);
            //mTextView6.setText(windDirection.toString());
            if (weatherShortDescription.equals("Clouds")) {
                Picasso.with(context).load(R.drawable.cloudy).resize(350, 350).into(mWeatherImage);
            }
            else if (weatherShortDescription.equals("Clear")) {
                Picasso.with(context).load(R.drawable.sunny).resize(350, 350).into(mWeatherImage);
            }
            else if (weatherShortDescription.equals("Rain")) {
                Picasso.with(context).load(R.drawable.rain).resize(350, 350).into(mWeatherImage);
            }
            else if (weatherShortDescription.equals("Mist")) {
                Picasso.with(context).load(R.drawable.rain).resize(350, 350).into(mWeatherImage);
            }

            else {
                Picasso.with(context).load(R.drawable.black400x400placeholder).resize(350, 350).into(mWeatherImage);
            }
            mWeatherImage.setVisibility(View.VISIBLE);

        }
    }

    private class getWeatherAndUpdateDisplayFiveDay extends AsyncTask<Void, Void, String> {
        String data;
        ArrayList<String> weather = new ArrayList<>();
        String cityName;

        JSONObject json;
        Conversions conversions;
        JSONArray list;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressBar = (ProgressBar)findViewById(R.id.progress_bar);
            mProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(Void... urls) {

            if (mCityInputText.equals("")) {
                cityName = "Muncie";
            }
            else {
                cityName = mCityInputText;
            }


            WeatherHttpClient weatherHttpClient = new WeatherHttpClient();
            try {
                data = weatherHttpClient.getWeatherData("forecast?q=" + cityName + ",US&cnt=15");
            } catch (Exception e) {
                Log.v("ERROR", e.toString());

            }
           return data;
        }


        @Override
        protected void onPostExecute(String data) {
            mProgressBar.setVisibility(View.INVISIBLE);

            jsonString = data;
            try {

                json = new JSONObject(jsonString);
                conversions = new Conversions();
                cityName = json.getJSONObject("city").getString("name");
                list = json.getJSONArray("list");

                for (int i = 0; i < 15; i++) {
                    weather.add(cityName);
                    weather.add(conversions.tempFromCelciusToFahrenheit(list.getJSONObject(i).getJSONObject("main").getDouble("temp")));
                    weather.add(list.getJSONObject(i).getJSONArray("weather").getJSONObject(0).getString("main"));
                }

            }
            catch (JSONException e) {
                e.printStackTrace();
            }


            startActivity(new Intent(MainActivity.this, ForecastActivity.class).putStringArrayListExtra("weatherArray", weather));



        }
    }
    @Override
    public void onConnected(Bundle connectionHint) {

    }

    @Override
    public void onConnectionSuspended(int cause) {
        //The connection has been interruped
        //disable any UI components that depend on google apis until onconnected is called
    }
    @Override
    public void onConnectionFailed(ConnectionResult result) {
        //callback important for handling errors
    }

}




