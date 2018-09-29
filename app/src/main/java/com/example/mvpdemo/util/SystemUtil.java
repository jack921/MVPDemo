package com.example.mvpdemo.util;

import android.content.Context;
import android.net.ConnectivityManager;

import com.example.mvpdemo.base.MyApplication;

public class SystemUtil {

    /**
     * 检查是否有可用网络
     */
    public static boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager)
                MyApplication.getContext().getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null;
    }


}
