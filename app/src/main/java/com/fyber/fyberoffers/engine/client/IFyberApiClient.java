package com.fyber.fyberoffers.engine.client;

import com.fyber.fyberoffers.engine.model.OfferResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Hend-PC on 10/8/2016.
 */

public interface IFyberApiClient {

    @GET("/feed/v1/offers.json")
    Call<OfferResponse> getOffers(@Query("format") String format,
                                  @Query("appid") Integer appid,
                                  @Query("uid") String uid,
                                  @Query("locale") String locale,
                                  @Query("os_version") String os_version,
                                  @Query("timestamp") Long timestamp,
                                  @Query("hashkey") String hashkey,
                                  @Query("google_ad_id") String google_ad_id,
                                  @Query("google_ad_id_limited_tracking_enabled") Boolean google_ad_id_limited_tracking_enabled,
                                  @Query("ip") String ip,
                                  @Query("pub0") String pub0,
                                  @Query("page") Integer page,
                                  @Query("offer_types") String offer_types,
                                  @Query("ps_time") Long ps_time,
                                  @Query("device") String device);
}
