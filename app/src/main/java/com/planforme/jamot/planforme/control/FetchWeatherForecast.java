package com.planforme.jamot.planforme.control;

import android.app.Activity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FetchWeatherForecast {

    public String date;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private Calendar calendar;
    private String basicURL = "https://api.data.gov.sg/v1/environment/4-day-weather-forecast?date=";
    public Activity clientActivity;
    private JSONArray forecasts;

    public FetchWeatherForecast(Activity client) {
        clientActivity = client;
        calendar = Calendar.getInstance();
        date = dateFormat.format(calendar.getTime());
        getAPIResult();
    }

    private void getAPIResult() {
        RequestQueue queue = Volley.newRequestQueue(this.clientActivity);
        StringRequest request = new StringRequest(Request.Method.GET, basicURL + date,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject json = new JSONObject(response);
                            JSONArray items = new JSONArray(json.getString("items"));
                            forecasts = items.getJSONObject(0).getJSONArray("forecasts");
                        } catch (JSONException jse) {
                            System.err.println("JSON problems");
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.err.println("Volley error :(");
                    }
        });
        queue.add(request);
    }

    //Days 0-3
    public String getForecast(int day) {
        try {
            return forecasts.getJSONObject(day).getString("forecast");
        } catch(JSONException jse) {
            return "JSON error";
        }
    }

}
