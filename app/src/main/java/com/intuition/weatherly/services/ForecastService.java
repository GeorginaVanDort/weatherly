package com.intuition.weatherly.services;


import android.util.Log;

import com.intuition.weatherly.Constants;
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

            //If response if Successful//
            if (response.isSuccessful()) {

                //Calls method to parse response//
                mWeatherForecast = parseJson(jsonData);
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
    public static WeatherForecast parseJson (String jsonData) throws JSONException {

        //Instantiate new Model//
        WeatherForecast weatherForecast = new WeatherForecast();

        //Create JSON Object from response//
        JSONObject forecast = new JSONObject(jsonData);

        //Get Timezone//
        weatherForecast.setTimeZone(forecast.getString("timezone"));
        Log.v(TAG, "From JSON: " + (forecast.getString("timezone")));

        //Drill into JSON "currently" object//
        JSONObject currently = forecast.getJSONObject("currently");

        //Set Model Vars//
        weatherForecast.setSummary(currently.getString("summary"));
        weatherForecast.setIcon(currently.getString("icon"));
        weatherForecast.setTime(currently.getLong("time"));
        weatherForecast.setTemp(currently.getDouble("temperature"));

        //Drill into Daily Array//
        JSONObject daily = forecast.getJSONObject("daily");
        JSONArray dailyArray = daily.getJSONArray("data");
        weatherForecast.setTempMax(dailyArray.getJSONObject(0).getDouble("temperatureMax"));
        weatherForecast.setTempMin(dailyArray.getJSONObject(0).getDouble("temperatureMin"));

        return weatherForecast;
    }

}
