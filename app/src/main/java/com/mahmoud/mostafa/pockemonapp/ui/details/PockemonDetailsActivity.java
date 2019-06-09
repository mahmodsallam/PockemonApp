package com.mahmoud.mostafa.pockemonapp.ui.details;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.mahmoud.mostafa.pockemonapp.R;
import com.mahmoud.mostafa.pockemonapp.base.BaseActivity;
import com.mahmoud.mostafa.pockemonapp.databinding.ActivityPockemonDetailsBinding;
import com.squareup.picasso.Picasso;

public class PockemonDetailsActivity extends BaseActivity implements DetailsMvpView {
    DetailsPresenter mPresenter;
    String url;
    ActivityPockemonDetailsBinding binding;
    String pockemonName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pockemon_details);
        mPresenter = new DetailsPresenter(this);
        url = getIntent().getStringExtra("URL");
        pockemonName = getIntent().getStringExtra("NAME");
        getSupportActionBar().setTitle(pockemonName);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mPresenter.getPockemonDetails(url);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        disappearBottomRightAnimation(this);
        return super.onSupportNavigateUp();
    }


    @Override
    public void setImageUrl(String url) {
        Picasso.with(this).load(url).into(binding.ivPockemon);
    }

    @Override
    public void setPockemonInfo(String info) {
        binding.tvPockemonInfo.append(info + "\n");
    }

    @Override
    public void setPockemonMoves(String moves) {
        binding.tvPockemonMoves.append(moves);

    }
}
