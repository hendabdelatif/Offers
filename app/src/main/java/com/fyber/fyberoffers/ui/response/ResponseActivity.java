package com.fyber.fyberoffers.ui.response;

import android.os.Bundle;
import android.util.Log;

import com.fyber.fyberoffers.R;
import com.fyber.fyberoffers.engine.model.Offer;
import com.fyber.fyberoffers.ui.BaseActivity;

import java.util.List;

import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Hend-PC on 10/9/16.
 */

public class ResponseActivity extends BaseActivity implements ResponseView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);

        ButterKnife.bind(this);
    }

    @Override
    public void onResponse(Call call, Response response) {
        
        Log.e("onResponse Response", response.body().toString());
    }

    @Override
    public void onFailure(Throwable t) {
        Log.v("onFailure Response", t.toString());
    }

    @Override
    public void showOffers(List<Offer> offersList) {

    }

    @Override
    public void showOfferDialog(int id) {

    }
}
