package com.example.dagger2rxjav2mvm.repolist;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.dagger2rxjav2mvm.data.model.User;

import javax.inject.Inject;

/**
 * Created by Irfan Ul Haq on 09/01/2020.
 */
public class RepolistViewModel extends ViewModel {
    private MutableLiveData<String> message = new MutableLiveData<>();
    private User user;

    @Inject
    public RepolistViewModel(User user) {
        this.user = user;
        message.setValue(user.login);
    }

    public MutableLiveData<String> getMessage(){
        message.setValue(user.login);
        return message;
    }


    public void setMessage(String message){
        this.message.setValue(message);
    }

}
