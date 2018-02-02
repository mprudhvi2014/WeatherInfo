package com.weather.utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by prudhvi on 1/27/2018.
 */
public class HttpUtils {

    private final static String CONTENT_TYPE = "Content-Type";
    private final static String APPLICATION_JSON = "application/json";
    private final static String NEW_LINE = "\n";


    public static JSONObject processRequestandGetResponse(URL weatherApiURL) throws IOException, JSONException{
        HttpURLConnection connection =
                (HttpURLConnection) weatherApiURL.openConnection();
        connection.setDoOutput(true);
        connection.setRequestProperty(CONTENT_TYPE, APPLICATION_JSON);

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));

        StringBuffer json = new StringBuffer();
        String tmp = WeatherUtils.EMPTY;
        while ((tmp = reader.readLine()) != null)
            json.append(tmp).append(NEW_LINE);
        reader.close();

        JSONObject weatherData = new JSONObject(json.toString());
        return weatherData;
    }
}
