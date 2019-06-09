package com.mahmoud.mostafa.pockemonapp.ui.splash;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.mahmoud.mostafa.pockemonapp.R;
import com.mahmoud.mostafa.pockemonapp.base.BaseActivity;
import com.mahmoud.mostafa.pockemonapp.databinding.ActivitySplashBinding;
import com.mahmoud.mostafa.pockemonapp.ui.main.PockemonsActivity;

public class SplashActivity extends BaseActivity implements SplashMvpView {

    SplashMvpPresenter mPresenter;
    ActivitySplashBinding binding;
    ObjectAnimator animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);
        mPresenter = new SplashPresenter(this);
        mPresenter.explorePockemons();

    }

    @Override
    public void animateViews() {
        animationMaker(binding.tvTitle, 100f, animation, 2000, "translationY");
        animationMaker(binding.tvMotivation, -100f, animation, 2000, "translationY");

    }

    @Override
    public void openPockemonsActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), PockemonsActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);

    }

    public void animationMaker(View view, float value, ObjectAnimator animator, int duration,
                               String propertyName) {
        animator = ObjectAnimator.ofFloat(view, propertyName, value);
        animator.setDuration(duration);
        animator.start();
    }
}
