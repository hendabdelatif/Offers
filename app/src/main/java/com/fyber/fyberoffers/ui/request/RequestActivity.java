package com.fyber.fyberoffers.ui.request;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.fyber.fyberoffers.R;
import com.fyber.fyberoffers.ui.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Hend-PC on 10/7/2016.
 */

public class RequestActivity extends BaseActivity implements RequestView, View.OnClickListener {

    private String mFormat = "hend";
    private int mAppId = 123;
    private String mUid = "hend";
    private String mLocale = "hend";
    private String mOsVersion = "hend";
    private long mTimestamp = 123;
    private String mGoogleAdId = "hend";
    private Boolean mGoogleAdIdLimitedTrackingEnabled = true;
    private String mHashKey = "hend";
    private String mIp = "hend";
    private String mPub0 = "hend";
    private Integer mPage = 2;
    private String mOfferTypes = "hend";
    private Long mPsTime = 123L;
    private String mDevice = "hend";

    private RequestPresenter mRequestPresenter;

    @Bind(R.id.btn_submit)
    Button mbtnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        ButterKnife.bind(this);
        mRequestPresenter = new RequestPresenterImpl(mFormat, mAppId, mUid, mLocale, mOsVersion, mTimestamp, mGoogleAdId, mGoogleAdIdLimitedTrackingEnabled, mIp, mPub0, mPage, mOfferTypes, mPsTime, mDevice);

        mbtnSubmit.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mRequestPresenter.setView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mRequestPresenter.clearView();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn_submit:
                mRequestPresenter.submit();
                break;
            default:
                break;
        }

    }
}
