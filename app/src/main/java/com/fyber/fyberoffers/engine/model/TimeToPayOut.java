package com.fyber.fyberoffers.engine.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Hend-PC on 10/8/2016.
 */
public class TimeToPayOut implements Serializable {
    @SerializedName("amount")
    private int mAmount;
    @SerializedName("readable")
    private String mReadable;
}
