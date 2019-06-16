package com.mahmoud.mostafa.pockemonapp.ui.main.viewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.mahmoud.mostafa.pockemonapp.data.network.model.Pockemon;
import com.mahmoud.mostafa.pockemonapp.data.network.model.Results;
import com.mahmoud.mostafa.pockemonapp.ui.main.repository.MainRepository;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {
    MainRepository repository;
    MutableLiveData<ArrayList<Results>> mPockemons  = new MutableLiveData<>();
    public void init() {
        repository =  MainRepository.getInstance() ;
        mPockemons  = repository.getPokemonAsLiveData() ;
    }

    public MutableLiveData<ArrayList<Results>> getPockemons() {
        return mPockemons;
    }
}
