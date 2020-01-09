package com.example.dagger2rxjav2mvm.di;

import com.example.dagger2rxjav2mvm.data.model.User;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Irfan Ul Haq on 09/01/2020.
 */

@Module
public class AppModule {
    @Singleton
    @Provides
    public static User providerUser(){
       return new User("I am login");
    }

}
