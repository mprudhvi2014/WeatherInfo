package com.weather.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.weather.R;
import com.weather.model.Forecast10Days;

import java.util.List;

/**
 * Created by prudhvi on 1/27/2018.
 */
public class WeatherListAdapter extends BaseAdapter {

    private List<Forecast10Days> mForeCast10Days;
    private Context mContext;

    public WeatherListAdapter(List<Forecast10Days> foreCast10Days, Context context) {
        mForeCast10Days = foreCast10Days;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mForeCast10Days.size();
    }

    @Override
    public Object getItem(int position) {
        return mForeCast10Days.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final WeatherViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.weather_list_adapter, parent, false);
            viewHolder = new WeatherViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (WeatherViewHolder) convertView.getTag();
        }
        viewHolder.lblDay.setText(mForeCast10Days.get(position).getDate().getDay());
        viewHolder.lblHigh.setText(mForeCast10Days.get(position).getHigh().getFarenheit());
        viewHolder.lblLow.setText(mForeCast10Days.get(position).getLow().getFarenheit());
        viewHolder.arrow.setImageResource(R.drawable.arrow);

        return convertView;

    }

    private class WeatherViewHolder {
        private TextView lblDay;
        private TextView lblHigh;
        private TextView lblLow;
        private ImageView arrow;
        public WeatherViewHolder(@NonNull View convertView) {
            lblDay = (TextView) convertView.findViewById(R.id.day);
            lblHigh = (TextView) convertView.findViewById(R.id.high);
            lblLow = (TextView) convertView.findViewById(R.id.low);
            arrow=(ImageView)convertView.findViewById(R.id.arrow);


        }


    }
}
