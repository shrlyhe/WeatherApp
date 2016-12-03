package com.shirleyhe.weatherproject;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import retrofit2.Call;

import android.widget.TextView;
import android.widget.Toast;

import com.shirleyhe.weatherproject.POJO.Model;
import com.shirleyhe.weatherproject.adapter.MainPagerAdapter;
import com.shirleyhe.weatherproject.api.WeatherAPI;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailsActivity extends AppCompatActivity {
    //test
    private TextView tvDetails;
    private String APIKEY = "c0f11608438af4b1491a27cddfdd339d";
    private Model weatherData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        String city = getIntent().getStringExtra("KEY_CITY");

        //init retrofit
        Retrofit retrofit = new Retrofit.Builder().baseUrl(
                "http://api.openweathermap.org/").
                addConverterFactory(GsonConverterFactory.create()).build();

        final WeatherAPI weatherAPI = retrofit.create(WeatherAPI.class);

        Call<Model> call = weatherAPI.getWeather(city, "metric", APIKEY);

        call.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                weatherData = response.body();
                //init view pager..
                ViewPager pager = (ViewPager) findViewById(R.id.pager);
                pager.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Toast.makeText(DetailsActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }

        });


    }

    public Model getWeatherData() {
        return weatherData;
    }

}
