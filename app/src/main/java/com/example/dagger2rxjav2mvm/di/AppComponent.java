package com.example.dagger2rxjav2mvm.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by Irfan Ul Haq on 09/01/2020.
 */

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,NetworkModule.class,AppModule.class,ActivityModule.class, ViewModelModule.class})
public interface AppComponent extends AndroidInjector<DaggerApplication> {
    @Component.Factory
    interface Factory{
        AppComponent create(@BindsInstance Application application);
    }
}
