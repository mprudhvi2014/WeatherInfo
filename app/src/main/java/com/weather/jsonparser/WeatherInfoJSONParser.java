package com.weather.jsonparser;


import com.weather.model.Date;
import com.weather.model.Forecast10Days;
import com.weather.model.High;
import com.weather.model.Low;
import com.weather.utils.JSONUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prudhvi on 1/27/2018.
 */
public class WeatherInfoJSONParser {

    private static final String FORECAST_DATE = "date";
    private static final String FORECAST = "forecast";
    private static final String FORECAST_DAY = "forecastday";
    private static final String SIMPLE_FORECAST = "simpleforecast";
    private static final String LOW = "low";
    private static final String HIGH = "high";
    private static final String CONDITIONS = "conditions";
    private static final String CELSIUS = "celsius";
    private static final String FARENHEIT = "fahrenheit";
    private static final String MIN = "min";
    private static final String SEC = "sec";
    private static final String ISDST = "isdst";
    private static final String MONTHNAME = "monthname";
    private static final String MONTHNAME_SHORT = "monthname_short";
    private static final String WEEKDAY_SHORT = "weekday_short";
    private static final String WEEKDAY = "weekday";
    private static final String EPOCH = "epoch";
    private static final String YDAY = "yday";
    private static final String HOUR = "hour";
    private static final String PRETTY = "pretty";
    private static final String DAY = "day";
    private static final String YEAR = "year";
    private static final String AMPM = "ampm";
    private static final String TZ_SHORT = "tz_short";
    private static final String TZ_LONG = "tz_long";


    /***
     * Initiates the JSON Object which is to be parsed od the Weather Info.
     * @param data input is the JSON Object which is to be parsed
     * @return List of the Weather Forecast data
     * @throws JSONException  throws the JSON Exception if any error.
     */
    public static List<Forecast10Days> getWeatherForeCast(JSONObject data) throws JSONException {

        JSONObject forecast = JSONUtils.getObject(FORECAST, data);

        JSONObject simpleforecast = JSONUtils.getObject(SIMPLE_FORECAST, forecast);

        return getForeCastfor10Days(JSONUtils.getJsonArray(FORECAST_DAY, simpleforecast));
    }


    /***
     * Iterates the Forecast dataand categorize it accordingly.
     * @param forecastArray JsonArray which is supposed to be categorized
     * @return the List of Forecats data
     * @throws JSONException throws the JSONException if any error.
     */
    private static List<Forecast10Days> getForeCastfor10Days(JSONArray forecastArray) throws JSONException {

        List<Forecast10Days> foreCast10Days = new ArrayList<>();

        for (int i = 0; i < forecastArray.length(); i++) {

            Forecast10Days foreCast10Day = new Forecast10Days();
            JSONObject forecastObject = forecastArray.getJSONObject(i);
            JSONObject date = (JSONObject) forecastObject.get(FORECAST_DATE);
            JSONObject low = (JSONObject) forecastObject.get(LOW);
            JSONObject high = (JSONObject) forecastObject.get(HIGH);

            foreCast10Day.setDate(processForeCastDate(date));
            foreCast10Day.setHigh(processHighCast(high));
            foreCast10Day.setLow(processLowCast(low));
            foreCast10Day.setFcttext(forecastObject.getString(CONDITIONS));
            foreCast10Days.add(foreCast10Day);


        }

        return foreCast10Days;
    }

    private static High processHighCast(JSONObject highCast) throws JSONException{
        High high = new High();
        high.setCelcius(highCast.getString(CELSIUS));
        high.setFarenheit(highCast.getString(FARENHEIT));

        return high;
    }

    private static Low processLowCast(JSONObject lowCast) throws JSONException{
        Low low = new Low();
        low.setCelcius(lowCast.getString(CELSIUS));
        low.setFarenheit(lowCast.getString(FARENHEIT));

        return low;
    }

    private static Date processForeCastDate(JSONObject foreCasteDate) throws JSONException {
        Date forecastDate = new Date();

        forecastDate.setEpoch(foreCasteDate.getString(EPOCH));
        forecastDate.setPretty(foreCasteDate.getString(PRETTY));
        forecastDate.setDay(foreCasteDate.getString(DAY));
        forecastDate.setYear(foreCasteDate.getString(YEAR));
        forecastDate.setYday(foreCasteDate.getString(YDAY));
        forecastDate.setHour(foreCasteDate.getString(HOUR));
        forecastDate.setMin(foreCasteDate.getString(MIN));
        forecastDate.setSec(foreCasteDate.getString(SEC));
        forecastDate.setIsdst(foreCasteDate.getString(ISDST));
        forecastDate.setMonthname(foreCasteDate.getString(MONTHNAME));
        forecastDate.setMonthname_short(foreCasteDate.getString(MONTHNAME_SHORT));
        forecastDate.setWeekday(foreCasteDate.getString(WEEKDAY_SHORT));
        forecastDate.setDay(foreCasteDate.getString(WEEKDAY));
        forecastDate.setWeekday_short(foreCasteDate.getString(AMPM));
        forecastDate.setTz_short(foreCasteDate.getString(TZ_SHORT));
        forecastDate.setTz_long(foreCasteDate.getString(TZ_LONG));

        return forecastDate;
    }


}
