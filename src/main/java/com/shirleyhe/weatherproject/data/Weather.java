package com.shirleyhe.weatherproject.data;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by shirleyhe on 11/29/16.
 */
public class Weather extends SugarRecord<Weather> implements Serializable{



    private String cityWeatherName;

    public Weather(String cityWeatherName) {
        this.cityWeatherName = cityWeatherName;

    }

    public Weather() {

    }

    public String getCityWeatherName() {
        return cityWeatherName;
    }

    public void setCityWeatherName(String cityWeatherName) {
        this.cityWeatherName = cityWeatherName;
    }
}
