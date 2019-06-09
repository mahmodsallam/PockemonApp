package com.mahmoud.mostafa.pockemonapp.ui.main;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mahmoud.mostafa.pockemonapp.R;
import com.mahmoud.mostafa.pockemonapp.data.network.model.Results;

import java.util.List;

public class PockemonAdapter extends RecyclerView.Adapter<PockemonAdapter.PockemonViewHolder> {
    List<Results> pockemonList;
    Activity mContext;
    DetailsIntrerface detailsIntrerface;

    public PockemonAdapter(List<Results> pockemonList, Activity mContext, DetailsIntrerface detailsIntrerface) {
        this.pockemonList = pockemonList;
        this.mContext = mContext;
        this.detailsIntrerface = detailsIntrerface;
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
                detailsIntrerface.openDetailsActivity(pockemon.getUrl(), pockemon.getName());
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
