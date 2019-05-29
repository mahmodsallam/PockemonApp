package com.mahmoud.mostafa.pockemonapp.ui.main;

import com.mahmoud.mostafa.pockemonapp.data.network.model.Results;

import java.util.List;

public interface PockemonMvpView {
    void updateUi(List<Results> list);

    void destroydisposal();


}
