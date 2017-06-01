package com.intuition.weatherly.services;


import com.intuition.weatherly.Constants;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class ForecastService {
    public static void getForecast (double latitude, double longitude, Callback callback) {
        String apiKey = Constants.API_KEY;
        String forecastUrl = Constants.FORECAST_URL;
        String url = forecastUrl + apiKey + "/" + latitude + "," + longitude;

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(forecastUrl).build();

        Call call = client.newCall(request);
    }

}
