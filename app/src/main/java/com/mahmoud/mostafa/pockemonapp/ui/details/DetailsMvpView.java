package com.mahmoud.mostafa.pockemonapp.ui.details;


import com.mahmoud.mostafa.pockemonapp.data.local.PockemonEntitiy;
import com.mahmoud.mostafa.pockemonapp.data.network.model.PockemonDetail;

import java.util.List;

public interface DetailsMvpView {


    void setImageUrl(String url);

    void setPockemonInfo(String info);

    void setPockemonMoves(String moves);


    void setImageUrlLocal(String url);

    void setPockemonInfoLocal(String info);

    void setPockemonMovesLocal(String moves);



    void savePockemon(PockemonEntitiy entitiy);


    void showInsertedSuccessfully(String message );

    void showDeletedSuccessfully();


}
