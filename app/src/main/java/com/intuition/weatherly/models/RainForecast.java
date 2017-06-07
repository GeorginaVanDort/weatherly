package com.intuition.weatherly.models;


import android.util.Log;

import org.parceler.Parcel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Parcel
public class RainForecast {

    private String mIcon;
    private String mRealTime;
    private String mRainDescription;

    public RainForecast() {}

    public RainForecast(Long time, String timeZone, Double rainIntensity) {
            mRealTime = setRealTime(time, timeZone);
            mRainDescription = setRainDescription(rainIntensity);
            mIcon = setIcon(rainIntensity);
    }

    public String setRealTime(long time, String timeZone) {
        SimpleDateFormat formatter = new SimpleDateFormat("h:mm");

        formatter.setTimeZone(TimeZone.getTimeZone(timeZone));
        Date dateTime = new Date(time * 1000);
        String realTime = formatter.format(dateTime);
        return realTime;
    }


    public static String setRainDescription(Double rainIntensity){
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

    private String setIcon(Double rainIntensity) {
        String icon = "b";

        if (rainIntensity == 0) {
            icon = ".";
            }
        return icon;
    }

    public String getRealTime(){
        return mRealTime;
    }

    public String getRainDescription() {
        return mRainDescription;
    }

    public String getIcon() { return mIcon; }
}

