package com.example.dagger2rxjav2mvm.di;

import com.example.dagger2rxjav2mvm.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Irfan Ul Haq on 09/01/2020.
 */
@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector(modules = {FragmentModule.class})
    abstract MainActivity mainActivity();
}
