package com.weather.application;

import android.app.Application;

/**
 * Created by prudhvi on 1/27/2018.
 */
public class WeatherApplication extends Application {

    private static WeatherApplication weatherApplication;

    @Override
    public void onCreate() {
        super.onCreate();

        weatherApplication = this;

    }

    public static WeatherApplication getInstance() {
        return weatherApplication;
    }

}
