package com.mahmoud.mostafa.pockemonapp.ui.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mahmoud.mostafa.pockemonapp.R;
import com.mahmoud.mostafa.pockemonapp.data.network.model.Results;
import com.mahmoud.mostafa.pockemonapp.databinding.ActivityPockemonsBinding;

import java.util.List;

public class PockemonsActivity extends AppCompatActivity implements PockemonMvpView {

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
        pockemonAdapter = new PockemonAdapter(result, this);
        binding.rvPokemonsList.setLayoutManager(layoutManager);
        binding.rvPokemonsList.setAdapter(pockemonAdapter);
    }

    @Override
    public void destroydisposal() {
        mPresenter.compositeDisposable.dispose();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroydisposal();
    }
}
