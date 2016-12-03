package com.shirleyhe.weatherproject.fragment;

import android.media.Image;
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

import org.w3c.dom.Text;

/**
 * Created by shirleyhe on 12/2/16.
 */
public class DetailsFragment extends Fragment {

    TextView tvTempMin;
    TextView tvTempMax;
    TextView tvHumidity;





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.details_fragment, null);

        tvTempMin = (TextView) rootView.findViewById(R.id.tvTempMin);
        tvTempMin.setText("Temp min: " + ((DetailsActivity)getActivity()).getWeatherData().getMain().getTempMin() + " degrees");

        tvTempMax = (TextView) rootView.findViewById(R.id.tvTempMax);
        tvTempMax.setText("Temp max: " + ((DetailsActivity)getActivity()).getWeatherData().getMain().getTempMax() + " degrees");

        tvHumidity = (TextView) rootView.findViewById(R.id.tvHumidity);
        tvHumidity.setText("Humidity: " + ((DetailsActivity)getActivity()).getWeatherData().getMain().getHumidity());





        return rootView;
    }
}
