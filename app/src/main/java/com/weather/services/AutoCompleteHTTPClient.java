package com.weather.services;

import android.util.Log;

import com.weather.utils.HttpUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;

/**
 * Created by prudhvi on 1/27/2018.
 */
public class AutoCompleteHTTPClient {


    private static final String AUTO_COMPLETE_API =
            "http://autocomplete.wunderground.com/aq?c=US&query=";
    private static final String TAG = WeatherForecastHTTPClient.class.getSimpleName();
    private JSONObject weatherForeCastData;

    public JSONObject getAutoCompleteData(String searchCode) {
        try {
            weatherForeCastData = HttpUtils.processRequestandGetResponse(new URL(AUTO_COMPLETE_API + searchCode));
        } catch (IOException ioException) {
            Log.e(TAG, ioException.getMessage());
        } catch (JSONException jsonException) {
            Log.e(TAG, jsonException.getMessage());

        }
        return weatherForeCastData;

    }
}
