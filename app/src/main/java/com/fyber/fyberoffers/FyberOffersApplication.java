package com.fyber.fyberoffers;

import android.app.Application;

/**
 * Created by Hend-PC on 10/7/2016.
 */

public class FyberOffersApplication extends Application {

    public static FyberOffersApplication sInstance;
    private static String API_KEY = "1c915e3b5d42d05136185030892fbb846c278927";

    public static FyberOffersApplication getInstance() {
        if (sInstance == null)
            sInstance = new FyberOffersApplication();
        return sInstance;
    }

    public static String getApiKey() {
        return API_KEY;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;
    }
}
