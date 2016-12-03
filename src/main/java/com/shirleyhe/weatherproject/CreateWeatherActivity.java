package com.shirleyhe.weatherproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.shirleyhe.weatherproject.data.Weather;

/**
 * Created by shirleyhe on 11/30/16.
 */
public class CreateWeatherActivity extends AppCompatActivity {
    private EditText etWeather;
    public static final String KEY_WEATHER = "KEY_WEATHER";
    private Weather weatherToEdit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_weather2);

        etWeather = (EditText) findViewById(R.id.etWeatherName);

        Button btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveWeather();
            }
        });
        if (weatherToEdit != null) {
            etWeather.setText(weatherToEdit.getCityWeatherName());
        }
        String checkEmpty = etWeather.getText().toString();
        if (TextUtils.isEmpty(checkEmpty)) {
            etWeather.setError("Please enter a city");
            return;
        }


    }

    private void saveWeather() {
        Intent intentResult = new Intent();
        Weather weatherResult = null;
        if (weatherToEdit != null) {
            weatherResult = weatherToEdit;
        }
        else {
            weatherResult = new Weather();
        }

        weatherResult.setCityWeatherName(etWeather.getText().toString());

        intentResult.putExtra(KEY_WEATHER, weatherResult);
        setResult(RESULT_OK, intentResult);
        finish();
    }

}
