package com.shirleyhe.weatherproject.POJO;

/**
 * Created by shirleyhe on 12/2/16.
 */
//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Clouds {

    @SerializedName("all")
    @Expose
    private Double all;

    /**
     *
     * @return
     * The all
     */
    public Double getAll() {
        return all;
    }

    /**
     *
     * @param all
     * The all
     */
    public void setAll(Double all) {
        this.all = all;
    }

}

