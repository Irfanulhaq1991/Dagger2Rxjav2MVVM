package com.example.dagger2rxjav2mvm;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.example.dagger2rxjav2mvm.base.BaseActivity;
import com.example.dagger2rxjav2mvm.base.BaseFragment;
import com.example.dagger2rxjav2mvm.repolist.ReposListFragment;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements BaseFragment.ToolBarCallChangesListener {

    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected int getContainerId() {
        return R.id.containerId;
    }


    @Override
    protected void init(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            setSupportActionBar(toolbar);
            navigationUtil.replaceFragment(ReposListFragment.newInstance());
        }
    }

    @Override
    public void setHeader(String header) {
        if (header != null)
            title.setText(header);
    }
}
