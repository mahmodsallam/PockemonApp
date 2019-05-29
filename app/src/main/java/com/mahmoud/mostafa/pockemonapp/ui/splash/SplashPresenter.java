package com.mahmoud.mostafa.pockemonapp.ui.splash;

public class SplashPresenter implements SplashMvpPresenter {
    SplashMvpView splashView;

    public SplashPresenter(SplashMvpView splashView) {
        this.splashView = splashView;
    }

    @Override
    public void explorePockemons() {
        splashView.animateViews();
        splashView.openPockemonsActivity();

    }
}
