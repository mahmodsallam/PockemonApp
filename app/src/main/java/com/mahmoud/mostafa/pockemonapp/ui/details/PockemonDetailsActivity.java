package com.mahmoud.mostafa.pockemonapp.ui.details;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mahmoud.mostafa.pockemonapp.R;
import com.mahmoud.mostafa.pockemonapp.base.BaseActivity;
import com.mahmoud.mostafa.pockemonapp.data.local.PockemonEntitiy;
import com.mahmoud.mostafa.pockemonapp.databinding.ActivityPockemonDetailsBinding;
import com.squareup.picasso.Picasso;

public class PockemonDetailsActivity extends BaseActivity implements DetailsMvpView {
    DetailsPresenter mPresenter;
    String url;
    ActivityPockemonDetailsBinding binding;
    String pokemonName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_pockemon_details);
        mPresenter = new DetailsPresenter(this, getApplicationContext());
        url = getIntent().getStringExtra("URL");
        pokemonName = getIntent().getStringExtra("NAME");
        getSupportActionBar().setTitle(pokemonName);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mPresenter.getPokemonDetails(url);

        binding.savePockemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PockemonEntitiy entitiy = new PockemonEntitiy(binding.tvPockemonAbilities.getText().toString(),
                        binding.tvPockemonInfo.getText().toString(),
                        url);
                savePockemon(entitiy);
            }
        });

        binding.deletePockemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.deletePokemonFromLocal(1);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.localPockemons:
                mPresenter.getPokemonDetailsLocal();
                break;
            case R.id.liveData:
                mPresenter.getPokemonLiveData();
                break;
        }
        return super.onOptionsItemSelected(item);
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
        this.url = url;

    }

    @Override
    public void setPockemonInfo(String info) {
        binding.tvPockemonInfo.append(info + "\n");
    }

    @Override
    public void setPockemonMoves(String moves) {
        binding.tvPockemonMoves.append(moves);
    }

    @Override
    public void setImageUrlLocal(String url) {
        Picasso.with(this).load(url).into(binding.ivPockemon);
    }

    @Override
    public void setPockemonInfoLocal(String info) {
        binding.tvPockemonInfo.append(info + "\n");
    }

    @Override
    public void setPockemonMovesLocal(String moves) {
        binding.tvPockemonMoves.append(moves);
    }

    @Override
    public void savePockemon(PockemonEntitiy entitiy) {
        mPresenter.insertPokemonDetailsLocal(entitiy);
    }


    @Override
    public void showInsertedSuccessfully(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showDeletedSuccessfully() {
        Toast.makeText(getApplicationContext(), "deleted", Toast.LENGTH_LONG).show();
    }
}
