package com.example.dagger2rxjav2mvm.reposdetail;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import com.example.dagger2rxjav2mvm.R;
import com.example.dagger2rxjav2mvm.base.BaseFragment;
import com.example.dagger2rxjav2mvm.util.ViewModelFactory;

import javax.inject.Inject;

import butterknife.BindView;

public class DetailsFragment extends BaseFragment {


    @BindView(R.id.tv_repo_name)
    TextView repoNameTextView;
    @BindView(R.id.tv_repo_description) TextView repoDescriptionTextView;
    @BindView(R.id.tv_forks) TextView forksTextView;
    @BindView(R.id.tv_stars) TextView starsTextView;

    @Inject
    ViewModelFactory viewModelFactory;
    private DetailsViewModel mViewModel;

    public static DetailsFragment newInstance() {
        return new DetailsFragment();
    }


    @Override
    protected String getTitle() {
        return "Detail";
    }

    @Override
    protected int getLayout() {
        return R.layout.screen_details;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this,viewModelFactory).get(DetailsViewModel.class);
        displayRepo();
    }
    private void displayRepo() {
        mViewModel.getSlectedRepo().observe(this, repo -> {
            if (repo != null) {
                repoNameTextView.setText(repo.name);
                repoDescriptionTextView.setText(repo.description);
                forksTextView.setText(String.valueOf(repo.forks));
                starsTextView.setText(String.valueOf(repo.stars));
            }
        });
    }
}
