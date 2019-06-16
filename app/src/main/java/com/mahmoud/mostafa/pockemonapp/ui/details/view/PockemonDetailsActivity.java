package com.mahmoud.mostafa.pockemonapp.ui.details.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mahmoud.mostafa.pockemonapp.R;
import com.mahmoud.mostafa.pockemonapp.base.BaseActivity;
import com.mahmoud.mostafa.pockemonapp.data.network.model.PockemonDetail;
import com.mahmoud.mostafa.pockemonapp.databinding.ActivityPockemonDetailsBinding;
import com.mahmoud.mostafa.pockemonapp.ui.details.viewModel.DetailsViewModel;
import com.squareup.picasso.Picasso;

public class PockemonDetailsActivity extends BaseActivity {
    String url;
    ActivityPockemonDetailsBinding binding;
    String pockemonName;
    private DetailsViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pockemon_details);
        url = getIntent().getStringExtra("URL");
        pockemonName = getIntent().getStringExtra("NAME");
        getSupportActionBar().setTitle(pockemonName);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        viewModel = ViewModelProviders.of(this).get(DetailsViewModel.class);
        viewModel.init();
        viewModel.getDetails(url).observe(this, new Observer<PockemonDetail>() {
            @Override
            public void onChanged(@Nullable PockemonDetail detail) {
                setImageUrl(detail.getSprites().getBack_shiny());
                setPockemonInfo(getAllInfo(detail));
                setPockemonMoves(getAllMoves(detail));
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        disappearBottomRightAnimation(this);
        return super.onSupportNavigateUp();
    }


    public void setImageUrl(String url) {
        Picasso.with(this).load(url).into(binding.ivPockemon);
    }

    public void setPockemonInfo(String info) {
        binding.tvPockemonInfo.append(info + "\n");
    }

    public void setPockemonMoves(String moves) {
        binding.tvPockemonMoves.append(moves);
    }


    //getting all info
    private String getAllInfo(PockemonDetail detail) {
        String info = "";
        for (int i = 0; i < detail.getAbilities().size(); i++) {
            info += (detail.getAbilities().get(i).getAbility().getName() + "\n");
        }
        return info;
    }

    //getting all the moves
    private String getAllMoves(PockemonDetail detail) {
        String moves = " ";
        for (int i = 0; i < detail.getMoves().size(); i++) {
            moves += (detail.getMoves().get(i).getMove().getName());
        }
        return moves;
    }
}
