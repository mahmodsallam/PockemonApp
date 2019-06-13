package com.mahmoud.mostafa.pockemonapp.ui.details;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;

import com.mahmoud.mostafa.pockemonapp.data.local.PockemonDao;
import com.mahmoud.mostafa.pockemonapp.data.local.PockemonDatabse;
import com.mahmoud.mostafa.pockemonapp.data.local.PockemonEntitiy;
import com.mahmoud.mostafa.pockemonapp.data.network.AppApiHelper;
import com.mahmoud.mostafa.pockemonapp.data.network.model.PockemonDetail;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DetailsPresenter implements DetailsMvpPresenter {

    private AppApiHelper appApiHelper;
    private PockemonDatabse database;
    private DetailsMvpView detailsView;
    private CompositeDisposable compositeDisposable;
    private Context context;
    private PockemonDao pockemonDao;
    private List<PockemonEntitiy> pockemonsList;


    public DetailsPresenter(DetailsMvpView detailsView, Context context) {
        this.context = context;
        this.detailsView = detailsView;
        database = PockemonDatabse.getInstance(context.getApplicationContext());
        pockemonDao = database.getPockemonsDao();
    }

    @Override
    public void getPokemonDetails(String url) {
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

    //insert
    @Override
    public void insertPokemonDetailsLocal(final PockemonEntitiy entitiy) {
        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                pockemonDao.insertPockemon(entitiy);
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onComplete() {
                detailsView.showInsertedSuccessfully("added");
            }

            @Override
            public void onError(Throwable e) {
                detailsView.showInsertedSuccessfully(e.getMessage());
            }
        });
    }

    //getting data
    @Override
    public void getPokemonDetailsLocal() {

        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                pockemonsList = pockemonDao.getPockemonsRx();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onComplete() {
                detailsView.showInsertedSuccessfully("Loaded form local ");
                detailsView.setImageUrlLocal(pockemonsList.get(0).getUrl());
                detailsView.setPockemonInfoLocal(pockemonsList.get(0).getPockemonUtilities());
                detailsView.setPockemonMovesLocal(pockemonsList.get(0).getPockemonMoves());
            }

            @Override
            public void onError(Throwable e) {
                detailsView.showInsertedSuccessfully(e.getMessage());
            }
        });
    }

    //getting data as a live data
    @Override
    public void getPokemonLiveData() {
        pockemonDao.getAllPockemonsLiveData().observeForever(new Observer<List<PockemonEntitiy>>() {
            @Override
            public void onChanged(@Nullable List<PockemonEntitiy> pockemons) {
                detailsView.showInsertedSuccessfully("Loaded from Local as a live data ");
                detailsView.setImageUrlLocal(pockemons.get(0).getUrl());
                detailsView.setPockemonInfoLocal(pockemons.get(0).getPockemonUtilities());
                detailsView.setPockemonMovesLocal(pockemons.get(0).getPockemonMoves());
            }
        });
    }

    //delete
    @Override
    public void deletePokemonFromLocal(final int id) {
        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                pockemonDao.deleteById(id);
            }
        }).observeOn(AndroidSchedulers.mainThread()).
                subscribeOn(Schedulers.io())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onComplete() {
                        detailsView.showDeletedSuccessfully();
                    }

                    @Override
                    public void onError(Throwable e) {
                    }
                });
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
