package com.shirleyhe.weatherproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.shirleyhe.weatherproject.CreateWeatherActivity;
import com.shirleyhe.weatherproject.DetailsActivity;
import com.shirleyhe.weatherproject.MainActivity;
import com.shirleyhe.weatherproject.R;
import com.shirleyhe.weatherproject.data.Weather;

import java.util.List;

/**
 * Created by shirleyhe on 11/29/16.
 */
public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvWeather;
        public Button btnView;
        public Button btnDelete;


        public ViewHolder(View view) {
            super(view);
            tvWeather = (TextView) view.findViewById(R.id.tvCity);
            btnView = (Button) view.findViewById(R.id.btnView);
            btnDelete = (Button) view.findViewById(R.id.btnDelete);
        }
    }

    private List<Weather> weatherList;
    private Context context;
    private int lastPosition = -1;

    public WeatherAdapter(List<Weather> weatherList, Context context) {
        this.weatherList = weatherList;
        this.context = context;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_city, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.tvWeather.setText(weatherList.get(position).getCityWeatherName());
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeCity(holder.getAdapterPosition());
            }
        });

        holder.btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsActivity.class);
                //send city name with intent
                intent.putExtra("KEY_CITY",weatherList.get(holder.getAdapterPosition()).getCityWeatherName());
                context.startActivity(intent);
            }
        });


    }

    private void removeCity(int index) {
        weatherList.get(index).delete();
        weatherList.remove(index);
        notifyDataSetChanged();
    }

    public void addWeather(Weather weather) {
        weather.save();
        weatherList.add(weather);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return weatherList.size();
    }

    public Weather getWeather(int i) {
        return weatherList.get(i);
    }


}
