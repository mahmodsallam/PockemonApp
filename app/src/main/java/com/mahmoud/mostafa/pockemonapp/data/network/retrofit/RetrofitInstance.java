package com.mahmoud.mostafa.pockemonapp.data.network.retrofit;

import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.mahmoud.mostafa.pockemonapp.utils.ApiEndPoints;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static Retrofit instance;

    public static Retrofit getInstance() {
        if (instance == null) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
            instance = new Retrofit.Builder().baseUrl("https://pokeapi.co/api/v2/").client(client)
                    .addConverterFactory(GsonConverterFactory.
                            create()).build();
        }
        return instance;
    }


}
