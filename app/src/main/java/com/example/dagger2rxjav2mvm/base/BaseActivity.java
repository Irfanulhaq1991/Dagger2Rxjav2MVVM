package com.example.dagger2rxjav2mvm.base;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

import com.example.dagger2rxjav2mvm.util.NavigationUtil;
import com.example.dagger2rxjav2mvm.util.PopUpMessagesUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerAppCompatActivity;

/**
 * Created by Irfan Ul Haq on 07/01/2020.
 */
public abstract class BaseActivity extends DaggerAppCompatActivity {

    @LayoutRes
    protected abstract int getLayout();

    private Unbinder unbinder;
    protected NavigationUtil navigationUtil;
    protected PopUpMessagesUtil popUpMessagesUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        unbinder = ButterKnife.bind(this);
        navigationUtil = NavigationUtil.getInstance(this, getContainerId());
        popUpMessagesUtil = PopUpMessagesUtil.getInstance(this);
        init(savedInstanceState);
    }

    protected int getContainerId() {
        return -1;
    }

    protected void init(Bundle savedInstanceState) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null)
            unbinder.unbind();
        unbinder = null;
        navigationUtil = null;
        popUpMessagesUtil = null;
    }
}
