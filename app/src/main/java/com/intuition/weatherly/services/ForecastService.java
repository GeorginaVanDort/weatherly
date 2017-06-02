package com.intuition.weatherly.services;


import android.util.Log;

import com.intuition.weatherly.Constants;
import com.intuition.weatherly.models.RainForecast;
import com.intuition.weatherly.models.WeatherForecast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ForecastService {

    public static final String TAG = ForecastService.class.getSimpleName();
    private static WeatherForecast mWeatherForecast;
    private static ArrayList<RainForecast> mRainForecasts;



    public static void getForecast(double latitude, double longitude, Callback callback) {
        String apiKey = Constants.API_KEY;
        String forecastUrl = "https://api.forecast.io/forecast/" + apiKey +
                "/" + latitude + "," + longitude;

        //Open client//
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(forecastUrl)
                .build();

        //Check URL//
        Log.v("this", forecastUrl);

        //Create call and enqueue//
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public static WeatherForecast processResults(Response response) {

        //Take response and convert to string//
        try {
            String jsonData = response.body().string();
            Log.v(TAG, jsonData);
            //Create JSON Object from response//
            JSONObject forecast = new JSONObject(jsonData);

            //If response if Successful//
            if (response.isSuccessful()) {

                //Calls method to parse response//
                mWeatherForecast = parseForecast(forecast);
            }

            //Report Errors, catch exceptions//
            else {
                Log.e(TAG, "error");
            }
        }

        catch (IOException e) {
            Log.e(TAG, "Exception caught: ", e);
        }

        catch (JSONException e) {
            Log.e(TAG, "Exception caught: ", e);
        }
        return mWeatherForecast;
    }

    //Parse JSON and set to Model//
    public static WeatherForecast parseForecast(JSONObject forecast) throws JSONException {

        //Get Timezone//
        String timeZone = (forecast.getString("timezone"));

        //Drill into JSON "currently" object//
        JSONObject currently = forecast.getJSONObject("currently");

        //Set Model Vars//
        String summary = (currently.getString("summary"));
        String icon = (currently.getString("icon"));
        Long time = (currently.getLong("time"));
        Double temperature = (currently.getDouble("temperature"));

        //Drill into Daily Array and get Dailys//
        JSONArray dailyArray = forecast.getJSONObject("daily").getJSONArray("data");
        Double tempMax = (dailyArray.getJSONObject(0).getDouble("temperatureMax"));
        Double tempMin = (dailyArray.getJSONObject(0).getDouble("temperatureMin"));

        //Get Minutely Array//
        String rainIcon = forecast.getJSONObject("minutely").getString("icon");
        JSONArray minutely = forecast.getJSONObject("minutely").getJSONArray("data");

        //Loop through each //
        ArrayList<RainForecast> rainForecasts = new ArrayList<>();
        for (int i = 0; i < minutely.length(); i+=5) {
            JSONObject rainForecastJSON = minutely.getJSONObject(i);

            Long rainTime = rainForecastJSON.getLong("time");
            Double rainIntensity = rainForecastJSON.getDouble("precipIntensity");

            //Construct Object and Push to Array//
            RainForecast rainForecast = new RainForecast(rainTime, timeZone, rainIntensity, rainIcon);
            rainForecasts.add(rainForecast);
        }

        //Construct Forecast Object//
        WeatherForecast weatherForecast = new WeatherForecast(time, timeZone, summary, temperature,
                tempMax, tempMin, icon, rainForecasts);

        return weatherForecast;
    }

}
