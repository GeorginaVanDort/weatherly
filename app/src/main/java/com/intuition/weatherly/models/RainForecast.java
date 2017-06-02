package com.intuition.weatherly.models;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class RainForecast {

    private Long mTime;
    private Double mRainIntensity;
    private String mTimeZone;

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

    public void setRainIntensity(Double mRainIntensity) {
        this.mRainIntensity = mRainIntensity;
    }



}

