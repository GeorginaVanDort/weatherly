package com.intuition.weatherly.services;


import android.util.Log;

import com.intuition.weatherly.Constants;
import com.intuition.weatherly.models.WeatherForecast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ForecastService {

    public static final String TAG = ForecastService.class.getSimpleName();


    public static void getForecast(double latitude, double longitude, Callback callback) {
        String apiKey = Constants.API_KEY;
        String forecastUrl = "https://api.forecast.io/forecast/" + apiKey +
                "/" + latitude + "," + longitude;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(forecastUrl)
                .build();

        Log.v("this", forecastUrl);

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

//    public static WeatherForecast processResults(Response response) {
//        WeatherForecast currentWeather = new WeatherForecast();
//
//        try {
//            String jsonData = response.body().toString();
//            Log.v("HERE", jsonData);
//
//            if (response.isSuccessful()) {
//                JSONObject forecast = new JSONObject(jsonData);
//                JSONObject currently = forecast.getJSONObject("currently");
//                String summary = currently.getString("summary");
//                Log.v("HERE!", summary);
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        return currentWeather;
//    }
}
