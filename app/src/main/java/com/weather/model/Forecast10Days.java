package com.weather.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by prudhvi on 1/27/2018.
 */
public class Forecast10Days implements Parcelable {

    private Date date;

    public Forecast10Days(Parcel in) {
        fcttext = in.readString();
    }

    public static final Creator<Forecast10Days> CREATOR = new Creator<Forecast10Days>() {
        @Override
        public Forecast10Days createFromParcel(Parcel in) {
            return new Forecast10Days(in);
        }

        @Override
        public Forecast10Days[] newArray(int size) {
            return new Forecast10Days[size];
        }
    };

    public Forecast10Days() {

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public High getHigh() {
        return high;
    }

    public void setHigh(High high) {
        this.high = high;
    }

    public Low getLow() {
        return low;
    }

    public void setLow(Low low) {
        this.low = low;
    }

    private High high;
    private Low low;

    public String getFcttext() {
        return fcttext;
    }

    public void setFcttext(String fcttext) {
        this.fcttext = fcttext;
    }

    private String fcttext;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fcttext);
    }
}
