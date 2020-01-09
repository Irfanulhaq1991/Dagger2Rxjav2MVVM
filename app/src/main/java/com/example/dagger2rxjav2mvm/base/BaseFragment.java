package com.example.dagger2rxjav2mvm.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dagger2rxjav2mvm.R;
import com.example.dagger2rxjav2mvm.util.NavigationUtil;
import com.example.dagger2rxjav2mvm.util.PopUpMessagesUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerFragment;

/**
 * Created by Irfan Ul Haq on 07/01/2020.
 */
public abstract class BaseFragment extends DaggerFragment {
    @LayoutRes
    protected abstract int getLayout();

    private Unbinder unbinder;
    protected ToolBarCallChangesListener toolbarCallback;
    protected NavigationUtil navigationUtil;
    protected PopUpMessagesUtil popUpMessagesUtil;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(getLayout(), container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        toolbarCallback.setHeader(getTitle());
        navigationUtil = NavigationUtil.getInstance((AppCompatActivity) getActivity(), getContainerId());
        popUpMessagesUtil = PopUpMessagesUtil.getInstance(getContext());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        navigationUtil = null;
        popUpMessagesUtil = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null)
            unbinder.unbind();
        unbinder = null;
    }

    protected int getContainerId() {
        return R.id.containerId;
    }

    protected String getTitle() {
        return null;
    }

    protected boolean getHasBtn() {
        return false;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ToolBarCallChangesListener)
            toolbarCallback = (ToolBarCallChangesListener) context;
        else
            throw new RuntimeException("ToolBarCallChangesListener is not Implemented");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        toolbarCallback = null;
    }

    public interface ToolBarCallChangesListener {
        public void setHeader(String header);
    }
}
