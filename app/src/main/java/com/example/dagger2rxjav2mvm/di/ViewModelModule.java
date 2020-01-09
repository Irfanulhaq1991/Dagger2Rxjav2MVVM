package com.example.dagger2rxjav2mvm.di;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.dagger2rxjav2mvm.di.annotation.ViewModelKey;
import com.example.dagger2rxjav2mvm.repolist.NetworkViewModel;
import com.example.dagger2rxjav2mvm.repolist.RepolistViewModel;
import com.example.dagger2rxjav2mvm.reposdetail.DetailsViewModel;
import com.example.dagger2rxjav2mvm.util.ViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * Created by Irfan Ul Haq on 09/01/2020.
 */

@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel.class)
    abstract ViewModel bindDetailsViewModel(DetailsViewModel detailsViewModel);
    @Binds
    @IntoMap
    @ViewModelKey(RepolistViewModel.class)
    abstract ViewModel bindRepolistViewModel(RepolistViewModel repolistViewModel);
    @Binds
    @IntoMap
    @ViewModelKey(NetworkViewModel.class)
    abstract ViewModel bindNetworkViewModel(NetworkViewModel networkViewModel);
    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory viewModelFactory);
}
