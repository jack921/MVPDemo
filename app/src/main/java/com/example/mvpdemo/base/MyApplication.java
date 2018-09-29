package com.example.mvpdemo.base;

import android.app.Application;

import com.example.mvpdemo.network.RetrofitHelper;

public class MyApplication extends Application {

    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
    }

    public static MyApplication getContext() {
        return instance;
    }

}
