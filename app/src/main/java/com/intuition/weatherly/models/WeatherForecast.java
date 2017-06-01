package com.intuition.weatherly.models;

public class WeatherForecast {
    private String mIcon;
    private String mTime;
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

    public String getTime() {
        return mTime;
    }

    public void setTime(String mTime) {
        this.mTime = mTime;
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

    public Double getTemp() {
        return mTemp;
    }

    public void setTemp(Double mTemp) {
        this.mTemp = mTemp;
    }

    public Double getTempMax() {
        return mTempMax;
    }

    public void setTempMax(Double mTempMax) {
        this.mTempMax = mTempMax;
    }

    public Double getTempMin() {
        return mTempMin;
    }

    public void setTempMin(Double mTempMin) {
        this.mTempMin = mTempMin;
    }


}
