package com.shirleyhe.weatherproject.api;

import android.support.design.widget.TabLayout;
import android.support.v7.util.SortedList;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.shirleyhe.weatherproject.POJO.Model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by shirleyhe on 12/1/16.
 */
public interface WeatherAPI {
        @GET("data/2.5/weather")
        Call<Model> getWeather(@Query("q") String cityName,
                                 @Query("units") String units,
                                 @Query("appid") String id);

}