package com.shirleyhe.weatherproject;

import android.app.NativeActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.shirleyhe.weatherproject.POJO.Main;
import com.shirleyhe.weatherproject.adapter.WeatherAdapter;
import com.shirleyhe.weatherproject.data.Weather;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private WeatherAdapter weatherAdapter;
    public static final int REQUEST_NEW_WEATHER = 101;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //recycler view stuff....
        List<Weather> weatherList = Weather.listAll(Weather.class);
        weatherAdapter = new WeatherAdapter(weatherList, this);
        RecyclerView recyclerViewWeather = (RecyclerView) findViewById(
                R.id.recyclerViewWeather);
        recyclerViewWeather.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewWeather.setAdapter(weatherAdapter);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCreateWeatherActivity();
            }
        });

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                switch (item.getItemId()) {
                    case R.id.action_add:
                        showCreateWeatherActivity();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.action_about:
                        Toast.makeText(MainActivity.this, "This app was made for AIT Mobile Course by Shirley He", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
                return false;
            }
        });

    }

    private void showCreateWeatherActivity() {
        Intent intentStart = new Intent(MainActivity.this, CreateWeatherActivity.class);
        startActivityForResult(intentStart, REQUEST_NEW_WEATHER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode) {
            case RESULT_OK:
                if (requestCode == REQUEST_NEW_WEATHER) {
                    Weather weather = (Weather) data.getSerializableExtra(CreateWeatherActivity.KEY_WEATHER);
                    weatherAdapter.addWeather(weather);

                }
                break;
            case RESULT_CANCELED:
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
