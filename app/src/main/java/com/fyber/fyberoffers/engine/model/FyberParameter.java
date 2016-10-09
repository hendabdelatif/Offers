package com.fyber.fyberoffers.engine.model;

/**
 * Created by Hend-PC on 10/8/2016.
 */
public class FyberParameter<T> {
    private T mValue;
    private String mName;

    public FyberParameter(String name, T value) {
        mValue = value;
        mName = name;
    }

    public String getName () {
        return mName;
    }

    public String getValue() {
        return mValue.toString();
    }
}
