package com.weather.asynctasks;

import android.os.AsyncTask;

import com.weather.services.WeatherForecastHTTPClient;
import com.weather.ui.fragments.WeatherInfoActivityFragment;

import org.json.JSONObject;

/**
 * Created by prudhvi on 1/27/2018.
 */
public class WeatherAsyncTask extends AsyncTask<String, Void, JSONObject> {


    public interface IWeatherInfoCallBack {

        public void onWeatherForecastCallBack(JSONObject weather);
    }

    private WeatherInfoActivityFragment mWeatherInfoActivityFragment;

    public WeatherAsyncTask(WeatherInfoActivityFragment weatherInfoActivityFragment) {

        this.mWeatherInfoActivityFragment = weatherInfoActivityFragment;
    }

    @Override
    protected JSONObject doInBackground(String... params) {
        WeatherForecastHTTPClient weather = new WeatherForecastHTTPClient();
        JSONObject weatherData = ((weather).getWeatherDataJSON(params[0]));

        return weatherData;

    }


    @Override
    protected void onPostExecute(JSONObject weather) {
        super.onPostExecute(weather);

        mWeatherInfoActivityFragment.onWeatherForecastCallBack(weather);
    }


}