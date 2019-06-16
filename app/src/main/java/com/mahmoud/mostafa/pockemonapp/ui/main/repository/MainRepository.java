package com.mahmoud.mostafa.pockemonapp.ui.main.repository;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.util.Log;

import com.mahmoud.mostafa.pockemonapp.data.network.model.Pockemon;
import com.mahmoud.mostafa.pockemonapp.data.network.model.Results;
import com.mahmoud.mostafa.pockemonapp.data.network.retrofit.PockemonApi;
import com.mahmoud.mostafa.pockemonapp.data.network.retrofit.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainRepository {
    private static MainRepository instance;
    private MutableLiveData<ArrayList<Results>> dataSet = new MutableLiveData<>();
    private PockemonApi api;
    private Retrofit retrofitInstance;
    private ArrayList<Results> pockemons = new ArrayList<>();


    public static MainRepository getInstance() {
        if (instance == null) {
            instance = new MainRepository();
        }
        return instance;
    }

    private void getPockemonsFromRemote() {
        retrofitInstance = RetrofitInstance.getInstance();
        api = retrofitInstance.create(PockemonApi.class);
        Call<Pockemon> call = api.getPockemons();
        call.enqueue(new Callback<Pockemon>() {
            @Override
            public void onResponse(Call<Pockemon> call, Response<Pockemon> response) {
                pockemons = (ArrayList<Results>) response.body().getResults();
                dataSet.setValue(pockemons);
            }

            @Override
            public void onFailure(Call<Pockemon> call, Throwable t) {
                Log.d("error", t.getMessage());
            }
        });
    }

    public MutableLiveData<ArrayList<Results>> getPokemonAsLiveData() {
        getPockemonsFromRemote();
        dataSet.observeForever(new Observer<ArrayList<Results>>() {
            @Override
            public void onChanged(@Nullable ArrayList<Results> results) {
            }
        });
        return dataSet;
    }


}
