package com.example.brad.adapterandlistviewtest;


import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


    public class FiveDayForecastAdapter extends ArrayAdapter<String> {
        private final Context context;
        private final String[] values;
        Activity mActivity;

        public FiveDayForecastAdapter(Context context, String[] values) {
            super(context, R.layout.activity_five_day_forecast, values);
            this.context = context;
            this.values = values;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.activity_five_day_forecast, parent, false);


            Typeface helvetica = Typeface.createFromAsset(mActivity.getAssets(), "fonts/HelveticaNeueThn.ttf");
            TextView shortDesc = (TextView) rowView.findViewById(R.id.shortDesc);
            shortDesc.setTypeface(helvetica);
            TextView temp = (TextView) rowView.findViewById(R.id.temp);
            temp.setTypeface(helvetica);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.list_image);
            temp.setText(values[position]);
            // change the icon for Windows and iPhone
           /* String s = values[position];
            if (s.startsWith("iPhone")) {
                imageView.setImageResource(R.drawable.no);
            } else {
                imageView.setImageResource(R.drawable.ok);
            }*/

            return rowView;
        }
    }