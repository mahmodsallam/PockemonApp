package com.mahmoud.mostafa.pockemonapp.data.network.retrofit;

import com.mahmoud.mostafa.pockemonapp.data.network.model.Pockemon;
import com.mahmoud.mostafa.pockemonapp.data.network.model.PockemonDetail;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface PockemonApi {
    @GET("pokemon/")
    Call<Pockemon> getPockemons();

    @GET
    Call<PockemonDetail> getDetails(@Url String url);
}
