package com.weather.services;

import android.util.Log;

import com.weather.utils.HttpUtils;
import com.weather.utils.WeatherUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;

/**
 * Created by prudhvi on 1/27/2018.
 */
public class WeatherForecastHTTPClient {

    private static final String TAG = WeatherForecastHTTPClient.class.getSimpleName();



    private static final String WEATHER_MAP_API =
            "http://api.wunderground.com/api/" + WeatherUtils.WEATHER_API_KEY + "/forecast10day/q/";
    private JSONObject weatherForeCastData;

    public JSONObject getWeatherDataJSON(String location) {
        try {
            weatherForeCastData = HttpUtils.processRequestandGetResponse(new URL(WEATHER_MAP_API + location));
        } catch (IOException ioException) {
            Log.e(TAG, ioException.getMessage());
        } catch (JSONException jsonException) {
            Log.e(TAG, jsonException.getMessage());

        }
        return weatherForeCastData;

    }
}
