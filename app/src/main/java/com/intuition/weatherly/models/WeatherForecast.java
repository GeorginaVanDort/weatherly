package com.intuition.weatherly.models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class WeatherForecast {
    private String mIcon;
    private Long mTime;
    private String mTimeZone;
    private String mSummary;
    private Double mTemp;
    private Double mTempMax;
    private Double mTempMin;


    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String mIcon) {
        this.mIcon = mIcon;
    }

    public Long getTime() {
        return mTime;
    }

    public void setTime(Long mTime) {
        this.mTime = mTime;
    }

    public String getRealTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("h:mm");

        formatter.setTimeZone(TimeZone.getTimeZone(getTimeZone()));
        Date dateTime = new Date(getTime() * 1000);
        String realTime = formatter.format(dateTime);
        return realTime;
    }

    public String getTimeZone() {
        return mTimeZone;
    }

    public void setTimeZone(String mTimeZone) {
        this.mTimeZone = mTimeZone;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String mSummary) {
        this.mSummary = mSummary;
    }

    public String getTemp() {
        return (int)Math.round(mTemp) + "";
    }

    public void setTemp(Double mTemp) {
        this.mTemp = mTemp;
    }

    public int getTempMax() {
        return (int)Math.round(mTempMax);
    }

    public void setTempMax(Double mTempMax) {
        this.mTempMax = mTempMax;
    }

    public int getTempMin() {
        return (int)Math.round(mTempMin);
    }

    public void setTempMin(Double mTempMin) {
        this.mTempMin = mTempMin;
    }


}
