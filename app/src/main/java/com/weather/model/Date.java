package com.weather.model;

/**
 * Created by prudhvi on 1/27/2018.
 */
public class Date {

    private String epoch;

    public String getEpoch() {
        return epoch;
    }

    public void setEpoch(String epoch) {
        this.epoch = epoch;
    }

    public String getPretty() {
        return pretty;
    }

    public void setPretty(String pretty) {
        this.pretty = pretty;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getYday() {
        return yday;
    }

    public void setYday(String yday) {
        this.yday = yday;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getSec() {
        return sec;
    }

    public void setSec(String sec) {
        this.sec = sec;
    }

    public String getIsdst() {
        return isdst;
    }

    public void setIsdst(String isdst) {
        this.isdst = isdst;
    }

    public String getMonthname() {
        return monthname;
    }

    public void setMonthname(String monthname) {
        this.monthname = monthname;
    }

    public String getMonthname_short() {
        return monthname_short;
    }

    public void setMonthname_short(String monthname_short) {
        this.monthname_short = monthname_short;
    }

    public String getWeekday_short() {
        return weekday_short;
    }

    public void setWeekday_short(String weekday_short) {
        this.weekday_short = weekday_short;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public String getAmpm() {
        return ampm;
    }

    public void setAmpm(String ampm) {
        this.ampm = ampm;
    }

    public String getTz_short() {
        return tz_short;
    }

    public void setTz_short(String tz_short) {
        this.tz_short = tz_short;
    }

    public String getTz_long() {
        return tz_long;
    }

    public void setTz_long(String tz_long) {
        this.tz_long = tz_long;
    }

    private String pretty;
    private String day;
    private String month;
    private String year;
    private String yday;
    private String hour;
    private String min;
    private String sec;
    private String isdst;
    private String monthname;
    private String monthname_short;
    private String weekday_short;
    private String weekday;
    private String ampm;
    private String tz_short;
    private String tz_long;


}
