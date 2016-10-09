package com.fyber.fyberoffers.engine.tasks;

import android.util.Log;

import com.fyber.fyberoffers.engine.client.FyberApiClient;
import com.fyber.fyberoffers.engine.model.OfferResponse;
import com.fyber.fyberoffers.ui.request.RequestView;
import com.fyber.fyberoffers.ui.response.ResponseView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Hend-PC on 10/7/2016.
 */

public class GetOffersCallback implements Callback<OfferResponse> {

    private static final String HASH_NAME = "X-Sponsorpay-Response-Signature";
    private String mFormat;
    private Integer mAppid;
    private String mUid;
    private String mLocale;
    private String mOsVersion;
    private Long mTimestamp;
    private String mHashkey;
    private String mGoogleAdId;
    private Boolean mGoogleAdIdLimitedTrackingEnabled;
    private String mIp;
    private String mPub0;
    private Integer mPage;
    private String mOfferTypes;
    private Long mPsTime;
    private String mDevice;


    private ResponseView responseView = new ResponseView.EmptyOffersListView();

    public GetOffersCallback() {
    }

    public GetOffersCallback(String format, Integer appid, String uid, String locale, String osVersion, Long timestamp, String hashkey, String googleAdId, Boolean googleAdIdLimitedTrackingEnabled, String ip, String pub0, Integer page, String offerTypes, Long psTime, String device) {
        this.mFormat = format;
        this.mAppid = appid;
        this.mUid = uid;
        this.mLocale = locale;
        this.mOsVersion = osVersion;
        this.mTimestamp = timestamp;
        this.mHashkey = hashkey;
        this.mGoogleAdId = googleAdId;
        this.mGoogleAdIdLimitedTrackingEnabled = googleAdIdLimitedTrackingEnabled;
        this.mIp = ip;
        this.mPub0 = pub0;
        this.mPage = page;
        this.mOfferTypes = offerTypes;
        this.mPsTime = psTime;
        this.mDevice = device;


    }


    @Override
    public void onResponse(Call call, Response response) {

        Log.v("Call onResponse", call+"");
        Log.v("Response onResponse", response+"");
        responseView.onResponse(call, response);
    }

    @Override
    public void onFailure(Call<OfferResponse> call, Throwable t) {

        Log.v("Call onFailure", call+"");
        Log.v("Throwable onFailure", t+"");
    }
}
