package com.mahmoud.mostafa.pockemonapp.data.network.fastNetwork;

import com.mahmoud.mostafa.pockemonapp.data.network.model.Pockemon;
import com.mahmoud.mostafa.pockemonapp.data.network.model.PockemonDetail;

import io.reactivex.Observable;

public interface ApiHelper {
    Observable<Pockemon> getPockemons();
    Observable<PockemonDetail> getPockemonDetails(String url);
}
