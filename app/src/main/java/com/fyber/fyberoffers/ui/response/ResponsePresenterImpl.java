package com.fyber.fyberoffers.ui.response;

import android.util.Log;

import com.fyber.fyberoffers.engine.client.FyberApiClient;
import com.fyber.fyberoffers.engine.model.OfferResponse;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Admin on 10/9/16.
 */

public class ResponsePresenterImpl implements ResponsePresenter {

private ResponseView mResponseView = new ResponseView.EmptyOffersListView();

    private FyberApiClient mFyberApiClient = new FyberApiClient();


    @Override
    public void setView(ResponseView view) {

    }

    @Override
    public void clearView() {

    }

    @Override
    public void onOfferClick() {

    }
}
