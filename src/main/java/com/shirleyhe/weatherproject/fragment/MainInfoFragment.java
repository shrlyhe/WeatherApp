package com.shirleyhe.weatherproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shirleyhe.weatherproject.DetailsActivity;
import com.shirleyhe.weatherproject.R;

/**
 * Created by shirleyhe on 12/2/16.
 */
public class MainInfoFragment extends Fragment{

    private TextView tvCurrentTemp;
    private TextView tvDescription;
    ImageView imageWeather;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main_info_fragment, null);

        //current temp
        tvCurrentTemp = (TextView) rootView.findViewById(R.id.tvCurrentTemp);
        tvCurrentTemp.setText("Current Temperature: " + ((DetailsActivity)getActivity()).getWeatherData().getMain().getTemp() + " degrees");

        //description
        tvDescription = (TextView) rootView.findViewById(R.id.tvDescription);
        tvDescription.setText("Description: " + ((DetailsActivity)getActivity()).getWeatherData().getWeather().get(0).getDescription());

        imageWeather = (ImageView) rootView.findViewById(R.id.imageWeather);
        Glide.with(this).load("http://openweathermap.org/img/w/10d.png").into(imageWeather);



        return rootView;
    }
}
