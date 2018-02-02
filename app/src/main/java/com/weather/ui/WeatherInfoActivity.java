package com.weather.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.weather.R;
import com.weather.application.WeatherApplication;
import com.weather.asynctasks.AutoCompleteAsyncTask;
import com.weather.jsonparser.AutoCompleteJSONParser;
import com.weather.model.Location;
import com.weather.preferences.LocationPreference;
import com.weather.ui.fragments.WeatherInfoActivityFragment;
import com.weather.utils.WeatherUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prudhvi on 1/27/2018.
 */

public class WeatherInfoActivity extends AppCompatActivity implements AutoCompleteAsyncTask.IAutoCompleteInfoCallBack, TextWatcher {

    private static final String TAG = WeatherInfoActivity.class.getSimpleName();


    private List<String> mLocationNames;
    private WeatherInfoActivityFragment mWeatherInfoActivityFragment;
    private MenuItem mLocationItem;
    private ArrayAdapter<String> mLocationAdapter;
    private AutoCompleteTextView mLocationNameView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Initialize the Autocomplete View
        initLocationView();
        // Load the Weather Information if the location is already set, or set the location if it is not set.
        loadWeatherDetailsorSetLocation();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_weather_info, menu);
        mLocationItem = (MenuItem) menu.findItem(R.id.location_item);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.location_item) {
            showSetLocationDialog();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void loadWeatherDetailsorSetLocation() {
        if ((LocationPreference.getLocation(WeatherApplication.getInstance()).equals(WeatherUtils.EMPTY)))
            showSetLocationDialog();
        else {
             showWeatherInfoFragment();
            mLocationNameView.setText(LocationPreference.getLocation(WeatherApplication.getInstance()));
        }
    }

    /***
     * This method will initialize the AutoComplete View which populate the location names.
     */
    private void initLocationView(){
        mLocationNameView = new AutoCompleteTextView(this);
        mLocationNameView.setHint(getString(R.string.location_dialog_hint));
        mLocationNameView.addTextChangedListener(this);
        mLocationNameView.setThreshold(1);

    }

    /***
     * This method displays the Dialog where the location can be set.
     */
    private void showSetLocationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.set_location));
        initLocationView();
        builder.setView(mLocationNameView);
        builder.setPositiveButton(getString(R.string.go), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                LocationPreference.clearLocation(WeatherApplication.getInstance());
                String city = mLocationNameView.getText() != null ? mLocationNameView.getText().toString() : WeatherUtils.EMPTY;
                LocationPreference.setLocation(WeatherApplication.getInstance(), WeatherUtils.formatLocation(city));
                mLocationItem.setTitle(city);

                showWeatherInfoFragment();

            }
        });
        builder.show();
    }

    /***
     * This method navigates to WeatherInfoFragment which show the Weather details for next 10 days.
     */
    private void showWeatherInfoFragment() {


        mWeatherInfoActivityFragment = WeatherInfoActivityFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(
                        R.id.activity_container,
                        mWeatherInfoActivityFragment)
                .commit();

        getSupportFragmentManager().executePendingTransactions();
    }


    @Override
    public void onAutoCompleteInfoCallBack(JSONObject autoCompleteData) {

        ArrayList<Location> autoCompleteList = null;
        try {
            if (autoCompleteData != null) {
                autoCompleteList = (ArrayList) AutoCompleteJSONParser.getAutoCompleteData(autoCompleteData);

                mLocationAdapter = new ArrayAdapter<String>(this,
                        android.R.layout.simple_dropdown_item_1line, processAndRetreiveLocationNames(autoCompleteList));
                mLocationNameView.setAdapter(mLocationAdapter);

            }

        } catch (JSONException jsonException) {
            Log.e(TAG, jsonException.getMessage());
        }

    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        AsyncTask<String, Void, JSONObject> autoCompleteAsyncTask = new AutoCompleteAsyncTask(this);
        autoCompleteAsyncTask.execute(WeatherUtils.trimString(s.toString()));

    }

    /***
     *  this method will process the response from AutoComplete API Call and extract the list of location names
     * @param autoCompleteList ArrayList with Location Details
     * @return List of String with location names
     */
    private List<String> processAndRetreiveLocationNames(ArrayList<Location> autoCompleteList) {

        mLocationNames = new ArrayList<>();

        for (Location location : autoCompleteList)
            mLocationNames.add(location.getName());

        return mLocationNames;
    }



}
