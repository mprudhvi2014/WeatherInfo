package com.weather.model;

import com.weather.utils.WeatherUtils;

/**
 * Created by prudhvi on 1/27/2018.
 */
public class Temperature {

    public String getFarenheit() {
        return farenheit+ WeatherUtils.FARENHEIT_SYMBOL;
    }

    public void setFarenheit(String farenheit) {
        this.farenheit = farenheit;
    }

    public String getCelcius() {
        return celcius;
    }

    public void setCelcius(String celcius) {
        this.celcius = celcius;
    }

    private String farenheit;
    private String celcius;
}
