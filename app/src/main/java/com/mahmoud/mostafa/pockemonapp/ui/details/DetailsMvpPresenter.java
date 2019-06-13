package com.mahmoud.mostafa.pockemonapp.ui.details;

import com.mahmoud.mostafa.pockemonapp.data.local.PockemonEntitiy;

public interface DetailsMvpPresenter {
    void getPokemonDetails(String url);

    void insertPokemonDetailsLocal(PockemonEntitiy pockemonDetail);

    void getPokemonDetailsLocal();

    void getPokemonLiveData();

    void deletePokemonFromLocal(int id);


}
