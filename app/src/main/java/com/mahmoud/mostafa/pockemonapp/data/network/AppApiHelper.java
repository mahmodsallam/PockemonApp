package com.mahmoud.mostafa.pockemonapp.data.network;

import android.arch.lifecycle.MutableLiveData;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.mahmoud.mostafa.pockemonapp.data.network.model.Pockemon;
import com.mahmoud.mostafa.pockemonapp.data.network.model.PockemonDetail;
import com.mahmoud.mostafa.pockemonapp.utils.ApiEndPoints;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;

public class AppApiHelper implements ApiHelper {
    @Override
    public Observable<Pockemon> getPockemons() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return Rx2AndroidNetworking.get(ApiEndPoints.POCKEMON_API_INSTANCE)
                .setOkHttpClient(new OkHttpClient.Builder()
                        .addInterceptor(interceptor)
                        .build())
                .build()
                .getObjectObservable(Pockemon.class);
    }

    @Override
    public Observable<PockemonDetail> getPockemonDetails(String url) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return Rx2AndroidNetworking.get(url).setOkHttpClient(new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()).build().getObjectObservable(PockemonDetail.class);
    }


}
