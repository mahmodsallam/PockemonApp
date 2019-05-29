package com.mahmoud.mostafa.pockemonapp.ui.details;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mahmoud.mostafa.pockemonapp.R;
import com.mahmoud.mostafa.pockemonapp.data.network.model.PockemonDetail;
import com.mahmoud.mostafa.pockemonapp.databinding.ActivityPockemonDetailsBinding;
import com.mahmoud.mostafa.pockemonapp.ui.ActivityAnimator;
import com.squareup.picasso.Picasso;

public class PockemonDetailsActivity extends AppCompatActivity implements DetailsMvpView {
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
        new ActivityAnimator().disappearBottomRightAnimation(this);
        return super.onSupportNavigateUp();
    }


    @Override
    public void setData(PockemonDetail detail) {
        Picasso.with(this).load(detail.getSprites().getBack_shiny()).into(binding.ivPockemon);
        for (int i = 0; i < detail.getAbilities().size(); i++) {
            binding.tvPockemonInfo.append(detail.getAbilities().get(i).getAbility().getName() + "\n");
        }
        for (int i = 0; i < detail.getMoves().size(); i++) {
            binding.tvPockemonMoves.append(detail.getMoves().get(i).getMove().getName());
        }

    }
}
