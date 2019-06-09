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

                detailsView.setImageUrl(details.getSprites().getBack_shiny());
                detailsView.setPockemonInfo(getAllInfo(details));
                detailsView.setPockemonMoves(getAllMoves(details));

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {


            }
        }));

    }

    private String getAllInfo(PockemonDetail detail) {
        String info = "";
        for (int i = 0; i < detail.getAbilities().size(); i++) {
            info += (detail.getAbilities().get(i).getAbility().getName() + "\n");
        }
        return info;
    }

    private String getAllMoves(PockemonDetail detail) {
        String moves = " ";
        for (int i = 0; i < detail.getMoves().size(); i++) {
            moves += (detail.getMoves().get(i).getMove().getName());
        }
        return moves;
    }
}
