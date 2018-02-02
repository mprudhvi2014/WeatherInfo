package com.weather.ui.fragments;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.weather.R;
import com.weather.adapters.WeatherListAdapter;
import com.weather.application.WeatherApplication;
import com.weather.asynctasks.WeatherAsyncTask;
import com.weather.jsonparser.WeatherInfoJSONParser;
import com.weather.model.Forecast10Days;
import com.weather.preferences.LocationPreference;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by prudhvi on 1/27/2018.
 */

public class WeatherInfoActivityFragment extends Fragment implements WeatherAsyncTask.IWeatherInfoCallBack, AdapterView.OnItemClickListener {


    private ListView mWeekDayWeatherList;
    private TextView mNoResultsfound;
    private List<Forecast10Days> mforeCast10Days;
    private WeatherListAdapter mweatherListAdapter;
    private ProgressDialog mDialog;


    public WeatherInfoActivityFragment() {
    }


    public static WeatherInfoActivityFragment newInstance() {
        return new WeatherInfoActivityFragment();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View weatherView = (View) inflater.inflate(R.layout.fragment_weather_info, container, false);
        mWeekDayWeatherList = (ListView) weatherView.findViewById(R.id.weather_list);
        mWeekDayWeatherList.setOnItemClickListener(this);
        mNoResultsfound = (TextView) weatherView.findViewById(R.id.noResults);
        String location = LocationPreference.getLocation(WeatherApplication.getInstance());
        AsyncTask<String, Void, JSONObject> weatherAsyncTask = new WeatherAsyncTask(WeatherInfoActivityFragment.this);
        weatherAsyncTask.execute(location);
        showWeatherProgressDialog();
        return weatherView;
    }


    @Override
    public void onWeatherForecastCallBack(JSONObject weather) {

        try {
            if (weather != null) {
                mWeekDayWeatherList.setVisibility(View.VISIBLE);
                mforeCast10Days = WeatherInfoJSONParser.getWeatherForeCast(weather);
                mweatherListAdapter = new WeatherListAdapter(mforeCast10Days, getActivity());
                mWeekDayWeatherList.setAdapter(mweatherListAdapter);
            } else {
                mWeekDayWeatherList.setVisibility(View.GONE);
                mNoResultsfound.setVisibility(View.VISIBLE);
            }
            dismissProgressDialog();

        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mweatherListAdapter != null)
            mWeekDayWeatherList.setAdapter(mweatherListAdapter);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        WeatherForecastinDetailsFragment weatherForecastinDetailsFragment = WeatherForecastinDetailsFragment.newInstance(mforeCast10Days.get(position));
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(
                        R.id.activity_container,
                        weatherForecastinDetailsFragment)
                .addToBackStack(null)
                .commit();

        getActivity().getSupportFragmentManager().executePendingTransactions();
    }


    /***
     * This method will show the ProgressDialog before the WeatherInfo ListView is populated with Weatherdata.
     */
    private void showWeatherProgressDialog() {
        mDialog = new ProgressDialog(getActivity());
        mDialog.setMessage(getString(R.string.loading_progress_text));
        mDialog.show();
    }

    /***
     * This method will dismiss the Progress Dialog after the WeatherInfo ListView is populated with Weatherdata.
     */
    private void dismissProgressDialog() {
        if (mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }
}
