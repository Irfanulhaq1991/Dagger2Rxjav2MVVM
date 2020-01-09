package com.example.dagger2rxjav2mvm.repolist;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dagger2rxjav2mvm.data.model.Repo;
import com.example.dagger2rxjav2mvm.data.rest.RepoRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Irfan Ul Haq on 09/01/2020.
 */
public class NetworkViewModel extends ViewModel {
    private final MutableLiveData<String> error = new MutableLiveData<>();
    private final MutableLiveData<List<Repo>> repoList = new MutableLiveData<>();
    private final RepoRepository repoRepository;
    CompositeDisposable compositeDisposable;

    @Inject
    public NetworkViewModel(RepoRepository repoRepository) {
        this.repoRepository = repoRepository;
        this.compositeDisposable = new CompositeDisposable();
    }

    public MutableLiveData<String> getError() {
        return error;
    }

    public MutableLiveData<List<Repo>> getRepoList() {
        return repoList;
    }

    public void loadRepo() {
        compositeDisposable.add(repoRepository
                .getRepositories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(repos -> repoList.setValue(repos), throwable -> error.setValue(throwable.getMessage()))
        );
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (compositeDisposable != null)
            compositeDisposable.clear();
        compositeDisposable = null;
    }
}
