package com.fyber.fyberoffers.engine.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Hend-PC on 10/8/2016.
 */
public class Thumbnail implements Serializable {
    @SerializedName("lowres")
    private String mLowres;
    @SerializedName("hires")
    private String mHires;

    public String getLowres() {
        return mLowres;
    }

    public void setLowres(String lowres) {
        this.mLowres = lowres;
    }

    public String getHires() {
        return mHires;
    }

    public void setHires(String hires) {
        this.mHires = hires;
    }
}
