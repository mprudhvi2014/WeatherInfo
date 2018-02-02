package com.weather.jsonparser;

import com.weather.model.Location;
import com.weather.utils.JSONUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prudhvi on 1/27/2018.
 */
public class AutoCompleteJSONParser {

    private static final String NAME = "name";
    private static final String TYPE = "type";
    private static final String C = "c";
    private static final String TZ = "tz";
    private static final String TZS = "tzs";
    private static final String L = "l";
    private static final String LAT = "lat";
    private static final String LON = "lon";
    private static final String RESULTS = "RESULTS";


    /***
     * Initiates the AutoComplete Location Data Parsing
     * @param autoCompleteData JsonObject which is supposed to be parsed
     * @return returns the list of Location data which is parsed
     * @throws JSONException throws the JSON Exception if any error.
     */
    public static List<Location> getAutoCompleteData(JSONObject autoCompleteData) throws JSONException {
        return getAutoCompleteData(JSONUtils.getJsonArray(RESULTS, autoCompleteData));

    }

    /***
     * Iterates the JSONObject and returns the Location List
     * @param autoCompleteArray JsonObject which is supposed to be parsed
     * @return returns the list of Location data which is parsed
     * @throws JSONException  throws the JSON Exception if any error.
     */
    private static List<Location> getAutoCompleteData(JSONArray autoCompleteArray) throws JSONException {

        List<Location> autoCompleteList = new ArrayList<>();

        for (int i = 0; i < autoCompleteArray.length(); i++) {

            Location locationAutoComplete = new Location();
            JSONObject autoCompleteObject = autoCompleteArray.getJSONObject(i);
            locationAutoComplete.setName(autoCompleteObject.getString(NAME));
            locationAutoComplete.setType(autoCompleteObject.getString(TYPE));
            locationAutoComplete.setC(autoCompleteObject.getString(C));
            locationAutoComplete.setTz(autoCompleteObject.getString(TZ));
            locationAutoComplete.setTzs(autoCompleteObject.getString(TZS));
            locationAutoComplete.setL(autoCompleteObject.getString(L));
            locationAutoComplete.setLat(autoCompleteObject.getString(LAT));
            locationAutoComplete.setLon(autoCompleteObject.getString(LON));
            autoCompleteList.add(locationAutoComplete);

        }

        return autoCompleteList;
    }
}
