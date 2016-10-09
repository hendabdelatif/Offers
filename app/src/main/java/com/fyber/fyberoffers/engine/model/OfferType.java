package com.fyber.fyberoffers.engine.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Hend-PC on 10/8/2016.
 */

public class OfferType implements Serializable {
    @SerializedName("offer_type_id")
    private String mOfferTypeId;
    @SerializedName("readable")
    private String mReadable;
}
