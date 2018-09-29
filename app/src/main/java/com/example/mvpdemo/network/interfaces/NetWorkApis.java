package com.example.mvpdemo.network.interfaces;

import com.example.mvpdemo.model.Weather;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface NetWorkApis {

    @GET("/geocoding?a=苏州市")
    Observable<Weather> getBaidu();

}
