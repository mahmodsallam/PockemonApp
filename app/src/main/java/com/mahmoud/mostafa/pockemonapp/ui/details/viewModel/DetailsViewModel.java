package com.mahmoud.mostafa.pockemonapp.ui.details.viewModel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.mahmoud.mostafa.pockemonapp.data.network.model.PockemonDetail;
import com.mahmoud.mostafa.pockemonapp.ui.details.repository.DetailsRepository;

public class DetailsViewModel extends ViewModel {
    MutableLiveData<PockemonDetail> details  ;
    DetailsRepository repository ;

    public void init (){
        details = new MutableLiveData<>()  ;
        repository = DetailsRepository.getInstance() ;
    }

    public MutableLiveData<PockemonDetail>getDetails(String url ){
        details = repository.getDetialsAsLiveData(url);
        return details ;
    }


}
