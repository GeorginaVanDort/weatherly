package com.intuition.weatherly.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;
import org.parceler.Parcel;

@Parcel
public class WeatherForecast {
    private String mRealTime;
    private String mSummary;
    private Double mTemp;
    private Double mTempMax;
    private Double mTempMin;
    private String mIcon;
    private ArrayList<RainForecast> mRainForecasts = new ArrayList<>();

    public WeatherForecast () {}


    public WeatherForecast(Long time, String timeZone, String summary,
                           Double temp, Double tempMax, Double tempMin,
                           String icon, ArrayList<RainForecast> rainForecasts) {

        mRealTime = setRealTime(time, timeZone);
        mSummary = summary;
        mTemp = temp;
        mTempMax = tempMax;
        mTempMin = tempMin;
        mIcon = icon;
        mRainForecasts = rainForecasts;
    }

    public String setRealTime(long time, String timeZone) {
        SimpleDateFormat formatter = new SimpleDateFormat("h:mm");

        formatter.setTimeZone(TimeZone.getTimeZone(timeZone));
        Date dateTime = new Date(time * 1000);
        String realTime = formatter.format(dateTime);
        return realTime;
    }


    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String mSummary) {
        this.mSummary = mSummary;
    }

    public int getTemp() {
        return (int)Math.round(mTemp);
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

    public String getRealTime() {
        return mRealTime;
    }

    public String getIcon() {
        return mIcon;
    }

    public ArrayList<RainForecast> getRainForecasts() {
        return mRainForecasts;
    }
}
