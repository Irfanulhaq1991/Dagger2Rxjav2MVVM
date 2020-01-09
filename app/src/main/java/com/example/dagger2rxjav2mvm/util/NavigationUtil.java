package com.example.dagger2rxjav2mvm.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

/**
 * Created by Irfan Ul Haq on 07/01/2020.
 */
public class NavigationUtil {
    private String TAG = "debug";
    private static NavigationUtil instance;
    private final AppCompatActivity appCompatActivity;
    private int containerId;

    private NavigationUtil(AppCompatActivity appCompatActivity, int containerId) {
        this.appCompatActivity = appCompatActivity;
        this.containerId = containerId;
    }

    public synchronized static NavigationUtil getInstance(AppCompatActivity appCompatActivity, int containerId) {
        if (instance == null)
            instance = new NavigationUtil(appCompatActivity, containerId);
        return instance;
    }

    public void navigateToActivity(Activity activity, Class<?> to, Bundle bundle) {
        Intent intent = new Intent(activity, to);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }


    public void navigateFmBack() {
        if (appCompatActivity.getSupportFragmentManager().getBackStackEntryCount() > 0) {
            appCompatActivity.getSupportFragmentManager().popBackStackImmediate();
            Log.d(TAG, "Fragment is navigated back");
        }
    }

    public void replaceFragment(Fragment targetFragment) {
        appCompatActivity.getSupportFragmentManager()
                .beginTransaction()
                .replace(containerId, targetFragment)
                .addToBackStack(null)
                .commit();
        Log.d(TAG, "Fragment " + targetFragment.getClass().getSimpleName() + " is replaced");
    }


    public void addFragment(Fragment targetFragment) {
        appCompatActivity.getSupportFragmentManager()
                .beginTransaction()
                .replace(containerId, targetFragment)
                .addToBackStack(null)
                .commit();
        Log.d(TAG, "Fragment " + targetFragment.getClass().getSimpleName() + " is added");
    }

    public NavigationUtil setContainerId(int containerId) {
        this.containerId = containerId;
        return this;
    }
}