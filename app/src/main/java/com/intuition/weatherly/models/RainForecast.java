package com.intuition.weatherly.models;


import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class RainForecast {

    private Long mTime;
    private Double mRainIntensity;
    private String mTimeZone;
    private String mPrecipType;

    public String getPrecipType() {
        return mPrecipType;
    }

    public void setPrecipType(String precipType) {
        mPrecipType = precipType;
    }

    public String getTimeZone() {
        return mTimeZone;
    }

    public void setTimeZone(String mTimeZone) {
        this.mTimeZone = mTimeZone;
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

    public Double getRainIntensity() {
        return mRainIntensity;
    }

    public void setRainIntensity(Double mRainIntensity) { this.mRainIntensity = mRainIntensity;
    }

    public static String getRainDescription(Double rainIntensity, String precipType){
        String rainDescription = "No Rain";

        if (rainIntensity < 0.1) {
            rainDescription = "Light " + precipType;
        }
        else if (rainIntensity < 0.3) {
            rainDescription = precipType;
        }
        else if (rainIntensity > 0.3) {
            rainDescription = "Heavy " + precipType;
        }
        return rainDescription;
    }

    public RainForecast(Long time, Double rainIntensity, String timeZone, String precipType) {
        mTime = time;
        mRainIntensity = rainIntensity;
        mTimeZone = timeZone;
        mPrecipType = precipType;
    }
}
