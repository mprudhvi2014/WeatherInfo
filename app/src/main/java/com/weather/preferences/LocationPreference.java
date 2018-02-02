package com.weather.preferences;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.weather.application.WeatherApplication;
import com.weather.utils.WeatherUtils;

/**
 * Created by prudhvi on 1/27/2018.
 */
public class LocationPreference {


    private static final String LOCATION = "location";

    private LocationPreference() {
    }


    public static String getLocation(WeatherApplication weatherApplication) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(weatherApplication);
        return preferences.getString(LOCATION, WeatherUtils.EMPTY);
    }

    public static void setLocation(WeatherApplication weatherApplication, String location) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(weatherApplication);
        preferences.edit().putString(LOCATION, location).commit();
    }

    public static void clearLocation(WeatherApplication weatherApplication) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(weatherApplication);
        preferences.edit().putString(LOCATION, WeatherUtils.EMPTY).apply();
    }
}
