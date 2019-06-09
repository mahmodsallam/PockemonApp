package com.mahmoud.mostafa.pockemonapp.ui.main;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mahmoud.mostafa.pockemonapp.R;
import com.mahmoud.mostafa.pockemonapp.base.BaseActivity;
import com.mahmoud.mostafa.pockemonapp.data.network.model.Results;
import com.mahmoud.mostafa.pockemonapp.databinding.ActivityPockemonsBinding;
import com.mahmoud.mostafa.pockemonapp.ui.details.PockemonDetailsActivity;

import java.util.List;

public class PockemonsActivity extends BaseActivity implements PockemonMvpView, DetailsIntrerface {

    PockemonPresenter mPresenter;
    PockemonAdapter pockemonAdapter;
    RecyclerView.LayoutManager layoutManager;
    ActivityPockemonsBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pockemons);
        mPresenter = new PockemonPresenter(this);
        mPresenter.getAllPockemons();
    }


    @Override
    public void updateUi(List<Results> result) {
        layoutManager = new LinearLayoutManager(this);
        pockemonAdapter = new PockemonAdapter(result, this, this);
        binding.rvPokemonsList.setLayoutManager(layoutManager);
        binding.rvPokemonsList.setAdapter(pockemonAdapter);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.destroydisposal();
    }

    @Override
    public void openDetailsActivity(String url, String name) {
        Intent intent = new Intent(this, PockemonDetailsActivity.class);
        intent.putExtra("URL", url);
        intent.putExtra("NAME", name);
        startActivity(intent);
        appearBottomRightAnimation(this);

    }

}
