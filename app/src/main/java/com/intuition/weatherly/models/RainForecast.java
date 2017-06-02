package com.intuition.weatherly.models;


import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class RainForecast {

    private String mIcon;
    private String mRealTime;
    private String mRainDescription;

    public RainForecast(Long time, String timeZone,  Double rainIntensity, String icon) {
            mRealTime = getRealTime(time, timeZone);
            mRainDescription = getRainDescription(rainIntensity);
            mIcon = setIcon(icon);
    }

    public String getRealTime(long time, String timeZone) {
        SimpleDateFormat formatter = new SimpleDateFormat("h:mm");

        formatter.setTimeZone(TimeZone.getTimeZone(timeZone));
        Date dateTime = new Date(time * 1000);
        String realTime = formatter.format(dateTime);
        return realTime;
    }


    public static String getRainDescription(Double rainIntensity){
        String rainDescription = "Heavy Rain";

        if (rainIntensity < 0.3) {
            rainDescription = "Rain";
            }
        if (rainIntensity < 0.1) {
            rainDescription = "Light Rain";
            }
        if (rainIntensity == 0) {
            rainDescription = "No Rain";
            }
        return rainDescription;
    }

    private String setIcon(String precipType) {
        return null;
    }
//    public void setPrecipType(String precipType) {
//        mPrecipType = precipType;
//    }
//
//
//
//    public void setTimeZone(String mTimeZone) {
//        this.mTimeZone = mTimeZone;
//    }
//
//    public void setTime(Long mTime) {
//        this.mTime = mTime;
//    }





}

