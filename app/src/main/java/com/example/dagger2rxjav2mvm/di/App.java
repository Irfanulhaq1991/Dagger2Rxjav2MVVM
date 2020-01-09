package com.example.dagger2rxjav2mvm.di;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

/**
 * Created by Irfan Ul Haq on 09/01/2020.
 */
public class App extends DaggerApplication {
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.factory().create(this);
    }
}
