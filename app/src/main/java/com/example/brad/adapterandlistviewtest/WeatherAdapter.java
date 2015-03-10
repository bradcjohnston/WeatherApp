package com.example.brad.adapterandlistviewtest;


import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


    public class WeatherAdapter extends ArrayAdapter<Weather> {

        private static String TAG = "RecycleAdapter";

        final Typeface helvetica = Typeface.createFromAsset(getContext().getAssets(), "fonts/HelveticaNeueThn.ttf");

        private Activity mContext;
        private LayoutInflater mInflater;

        public WeatherAdapter(Activity context, int textViewResourceId) {
            super(context, textViewResourceId);
            mContext = context;
            mInflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        static class ViewHolder {
            TextView temp;
            TextView townName;
            TextView shortDesc;
            ImageView mWeatherImage;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            Log.d(TAG, "position=" + position);

            ViewHolder holder;

            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.fifteen_day_forecast_listview, parent, false);
                holder = new ViewHolder();
                holder.temp = (TextView) convertView.findViewById(R.id.temp);
                holder.temp.setTypeface(helvetica);
               // holder.townName = (TextView) convertView.findViewById(R.id.textView_town);
                holder.shortDesc = (TextView) convertView.findViewById(R.id.shortDesc);
                holder.shortDesc.setTypeface(helvetica);
                holder.mWeatherImage = (ImageView) convertView.findViewById(R.id.list_image);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            Weather data = getItem(position);
            holder.temp.setText(data.getTemp());
            //holder.townName.setText(data.);

            holder.shortDesc.setText(data.getShortDescription());
            holder.mWeatherImage.setImageResource(data.getWeatherImage());

            return convertView;

        }

    }