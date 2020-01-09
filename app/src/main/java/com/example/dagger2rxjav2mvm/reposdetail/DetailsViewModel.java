package com.example.dagger2rxjav2mvm.reposdetail;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dagger2rxjav2mvm.data.model.Repo;

import javax.inject.Inject;

public class DetailsViewModel extends ViewModel {
    private final MutableLiveData<Repo> slectedRepo = new MutableLiveData<Repo>();

    @Inject
    public DetailsViewModel() {
    }

    public MutableLiveData<Repo> getSlectedRepo() {
        return slectedRepo;
    }

    public void setSelectedRepo(Repo repo){
        slectedRepo.setValue(repo);
    }
}
