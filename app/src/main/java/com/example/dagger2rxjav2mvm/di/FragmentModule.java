package com.example.dagger2rxjav2mvm.di;

import com.example.dagger2rxjav2mvm.repolist.ReposListFragment;
import com.example.dagger2rxjav2mvm.reposdetail.DetailsFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Irfan Ul Haq on 09/01/2020.
 */
@Module
public abstract class FragmentModule {
    @ContributesAndroidInjector
   abstract ReposListFragment reposListFragment();
    @ContributesAndroidInjector
    abstract DetailsFragment reposDetailsFragment();
}
