package com.mahmoud.mostafa.pockemonapp.ui.details.repository;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.util.Log;

import com.mahmoud.mostafa.pockemonapp.data.network.model.PockemonDetail;
import com.mahmoud.mostafa.pockemonapp.data.network.retrofit.PockemonApi;
import com.mahmoud.mostafa.pockemonapp.data.network.retrofit.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DetailsRepository {
    private static DetailsRepository instance;
    private Retrofit retrofit;
    private PockemonApi api;
    private MutableLiveData<PockemonDetail> details = new MutableLiveData<>();


    public static DetailsRepository getInstance() {
        if (instance == null) {
            instance = new DetailsRepository();
        }
        return instance;
    }

    public void getPockemonDetails(String url) {
        retrofit = RetrofitInstance.getInstance();
        api = retrofit.create(PockemonApi.class);
        Call<PockemonDetail> call = api.getDetails(url);
        call.enqueue(new Callback<PockemonDetail>() {
            @Override
            public void onResponse(Call<PockemonDetail> call, Response<PockemonDetail> response) {
                details.setValue(response.body());
            }

            @Override
            public void onFailure(Call<PockemonDetail> call, Throwable t) {
                Log.d("error", t.getMessage());
            }
        });
    }

    public MutableLiveData<PockemonDetail> getDetialsAsLiveData(String url) {
        getPockemonDetails(url);
        details.observeForever(new Observer<PockemonDetail>() {
            @Override
            public void onChanged(@Nullable PockemonDetail detail) {
            }
        });
        return details;
    }

}
