package com.mahmoud.mostafa.pockemonapp.ui.details;

import com.mahmoud.mostafa.pockemonapp.data.network.AppApiHelper;
import com.mahmoud.mostafa.pockemonapp.data.network.model.PockemonDetail;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DetailsPresenter implements DetailsMvpPresenter {
    AppApiHelper appApiHelper;
    DetailsMvpView detailsView;
    CompositeDisposable compositeDisposable;

    public DetailsPresenter(DetailsMvpView detailsView) {
        this.detailsView = detailsView;
    }

    @Override
    public void getPockemonDetails(String url) {
        appApiHelper = new AppApiHelper();
        compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(appApiHelper.getPockemonDetails(url).observeOn(AndroidSchedulers.mainThread()).
                subscribeOn(Schedulers.io()).subscribe(new Consumer<PockemonDetail>() {
            @Override
            public void accept(PockemonDetail details) throws Exception {
                detailsView.setData(details);

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {


            }
        }));

    }
}
