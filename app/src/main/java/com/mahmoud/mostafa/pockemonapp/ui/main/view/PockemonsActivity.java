package com.mahmoud.mostafa.pockemonapp.ui.main.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mahmoud.mostafa.pockemonapp.R;
import com.mahmoud.mostafa.pockemonapp.base.BaseActivity;
import com.mahmoud.mostafa.pockemonapp.data.network.model.Results;
import com.mahmoud.mostafa.pockemonapp.databinding.ActivityPockemonsBinding;
import com.mahmoud.mostafa.pockemonapp.ui.details.view.PockemonDetailsActivity;
import com.mahmoud.mostafa.pockemonapp.ui.main.viewModel.MainViewModel;

import java.util.ArrayList;

public class PockemonsActivity extends BaseActivity implements DetailsIntrerface {

    private PockemonAdapter pockemonAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ActivityPockemonsBinding binding;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pockemons);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        viewModel.init();
        viewModel.getPockemons().observe(this, new Observer<ArrayList<Results>>() {
            @Override
            public void onChanged(@Nullable ArrayList<Results> results) {
                setData();
                pockemonAdapter.notifyDataSetChanged();
            }
        });
    }

    void setData() {
        layoutManager = new LinearLayoutManager(this);
        pockemonAdapter = new PockemonAdapter(viewModel.getPockemons().getValue()
                , this, this);
        binding.rvPokemonsList.setLayoutManager(layoutManager);
        binding.rvPokemonsList.setAdapter(pockemonAdapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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
