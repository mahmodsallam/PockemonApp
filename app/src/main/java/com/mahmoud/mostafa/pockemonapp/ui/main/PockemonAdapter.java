package com.mahmoud.mostafa.pockemonapp.ui.main;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mahmoud.mostafa.pockemonapp.R;
import com.mahmoud.mostafa.pockemonapp.data.network.model.Results;
import com.mahmoud.mostafa.pockemonapp.ui.ActivityAnimator;
import com.mahmoud.mostafa.pockemonapp.ui.details.PockemonDetailsActivity;

import java.util.List;

public class PockemonAdapter extends RecyclerView.Adapter<PockemonAdapter.PockemonViewHolder> {
    List<Results> pockemonList;
    Activity mContext;

    public PockemonAdapter(List<Results> pockemonList, Activity mContext) {
        this.pockemonList = pockemonList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public PockemonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.pockemon_row, viewGroup,
                false);
        return new PockemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PockemonViewHolder pockemonViewHolder, int i) {

        final Results pockemon = pockemonList.get(i);
        pockemonViewHolder.pockemonName.setText(pockemon.getName());
        pockemonViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, PockemonDetailsActivity.class);
                intent.putExtra("URL", pockemon.getUrl());
                intent.putExtra("NAME", pockemon.getName());
                mContext.startActivity(intent);
                new ActivityAnimator().appearBottomRightAnimation(mContext);

            }
        });

    }

    @Override
    public int getItemCount() {
        return pockemonList.size();
    }

    class PockemonViewHolder extends RecyclerView.ViewHolder {
        TextView pockemonName;

        public PockemonViewHolder(@NonNull View itemView) {
            super(itemView);
            pockemonName = itemView.findViewById(R.id.tv_pockemon_name);
        }
    }
}
