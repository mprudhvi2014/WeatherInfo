package com.weather.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.weather.R;
import com.weather.model.Forecast10Days;

/**
 * Created by prudhvi on 1/27/2018.
 */

public class WeatherForecastinDetailsFragment extends Fragment {


    private TextView mDay;
    private TextView mHigh;
    private TextView mLow;
    private TextView mConditions;

    private static final String FORECAST_KEY = "foreCastDetails";

    public WeatherForecastinDetailsFragment() {
    }


    public static WeatherForecastinDetailsFragment newInstance(Forecast10Days foreCast10Day) {
        WeatherForecastinDetailsFragment weatherForecastinDetailsFragment = new WeatherForecastinDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(FORECAST_KEY, foreCast10Day);
        weatherForecastinDetailsFragment.setArguments(bundle);
        return weatherForecastinDetailsFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather_forecastin_details, container, false);
        mDay = (TextView) view.findViewById(R.id.day);
        mHigh = (TextView) view.findViewById(R.id.high);
        mLow = (TextView) view.findViewById(R.id.low);
        mConditions = (TextView) view.findViewById(R.id.condition);

        Bundle bundle = getArguments();
        Forecast10Days foreCast10Day = bundle.getParcelable(FORECAST_KEY);
        mDay.setText(foreCast10Day.getDate().getDay());
        mHigh.setText(foreCast10Day.getHigh().getFarenheit());
        mLow.setText(foreCast10Day.getLow().getFarenheit());
        mConditions.setText(foreCast10Day.getFcttext());
        return view;
    }


}
