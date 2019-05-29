package com.mahmoud.mostafa.pockemonapp.ui.main;

import com.mahmoud.mostafa.pockemonapp.data.network.AppApiHelper;
import com.mahmoud.mostafa.pockemonapp.data.network.model.Pockemon;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class PockemonPresenter implements PockemonMvpPresenter {
    public CompositeDisposable compositeDisposable;
    PockemonMvpView pockemonView;
    AppApiHelper appApiHelper;

    public PockemonPresenter(PockemonMvpView pockemonView) {
        this.pockemonView = pockemonView;
    }

    @Override
    public void getAllPockemons() {
        compositeDisposable = new CompositeDisposable();
        appApiHelper = new AppApiHelper() ;
        compositeDisposable.add(appApiHelper.getPockemons().observeOn(AndroidSchedulers.mainThread()).
                subscribeOn(Schedulers.io()).subscribe(new Consumer<Pockemon>() {
            @Override
            public void accept(Pockemon pockemon) throws Exception {
                pockemonView.updateUi(pockemon.getResults());

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {


            }
        }));

    }
}
