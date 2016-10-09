package com.fyber.fyberoffers.engine.client;

import com.fyber.fyberoffers.BuildConfig;
import com.fyber.fyberoffers.engine.model.OfferResponse;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hend-PC on 10/8/2016.
 */

public class FyberApiClient {

    private Retrofit retrofit;
    private IFyberApiClient mFyberApiClient;

    public FyberApiClient() {
        if (retrofit == null || mFyberApiClient == null) {

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

            Retrofit.Builder builder =
                    new Retrofit.Builder()
                            .baseUrl(BuildConfig.HOST)
                            .addConverterFactory(GsonConverterFactory.create());

            retrofit = builder.client(httpClient.build()).build();
            mFyberApiClient = retrofit.create(IFyberApiClient.class);
        }
    }

    public Call<OfferResponse> getOffers(String format, Integer appid, String uid, String locale, String osVersion, Long timestamp, String hashkey, String googleAdId, Boolean googleAdIdLimitedTrackingEnabled, String ip, String pub0, Integer page, String offerTypes, Long psTime, String device) {
        return mFyberApiClient.getOffers(format, appid, uid, locale, osVersion, timestamp, hashkey, googleAdId, googleAdIdLimitedTrackingEnabled, ip, pub0, page, offerTypes, psTime, device);
    }
}
