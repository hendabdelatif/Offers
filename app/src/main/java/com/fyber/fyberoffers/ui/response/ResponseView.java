package com.fyber.fyberoffers.ui.response;

import com.fyber.fyberoffers.engine.model.Offer;
import com.fyber.fyberoffers.engine.model.OfferResponse;
import com.fyber.fyberoffers.ui.request.RequestView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Hend-PC on 10/9/16.
 */

public interface ResponseView {

    void onResponse(Call call, Response response);
    void onFailure(Throwable throwable);
    void showOffers(List<Offer> offersList);

    void showOfferDialog(int id);


    class EmptyOffersListView implements ResponseView {

        @Override
        public void onResponse(Call call, Response response) {

        }

        @Override
        public void onFailure(Throwable throwable) {

        }

        @Override
        public void showOffers(final List<Offer> customers) {

        }

        @Override
        public void showOfferDialog(final int id) {

        }

    }
}
