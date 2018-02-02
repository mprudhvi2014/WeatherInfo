package com.weather.asynctasks;

import android.os.AsyncTask;

import com.weather.services.AutoCompleteHTTPClient;
import com.weather.ui.WeatherInfoActivity;

import org.json.JSONObject;

/**
 * Created by prudhvi on 1/27/2018.
 */
public class AutoCompleteAsyncTask extends AsyncTask<String, Void, JSONObject> {


    public interface IAutoCompleteInfoCallBack {

        public void onAutoCompleteInfoCallBack(JSONObject autoCompleteData);
    }

    private WeatherInfoActivity mContext;

    public AutoCompleteAsyncTask(WeatherInfoActivity context) {

        mContext = context;
    }

    @Override
    protected JSONObject doInBackground(String... params) {
        AutoCompleteHTTPClient autoCompleteHTTPClient = new AutoCompleteHTTPClient();
        JSONObject weatherData = autoCompleteHTTPClient.getAutoCompleteData(params[0]);

        return weatherData;

    }


    @Override
    protected void onPostExecute(JSONObject autoCompleteData) {
        super.onPostExecute(autoCompleteData);

        mContext.onAutoCompleteInfoCallBack(autoCompleteData);
    }

}
