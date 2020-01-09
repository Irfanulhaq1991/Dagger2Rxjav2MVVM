package com.example.dagger2rxjav2mvm.repolist;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dagger2rxjav2mvm.R;
import com.example.dagger2rxjav2mvm.base.BaseFragment;
import com.example.dagger2rxjav2mvm.data.model.Repo;
import com.example.dagger2rxjav2mvm.reposdetail.DetailsFragment;
import com.example.dagger2rxjav2mvm.reposdetail.DetailsViewModel;
import com.example.dagger2rxjav2mvm.util.ViewModelFactory;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class ReposListFragment extends BaseFragment implements RepoListAdapter.OnRepoSelect {

    private int counter;
    @BindView(R.id.message)
    TextView message;
    @BindView(R.id.repolist)
    RecyclerView repoList;

    RepolistViewModel viewModel;
    NetworkViewModel networkViewModel;
    DetailsViewModel detailsViewModel;
    RepoListAdapter repoListAdapter;

    @Inject
    ViewModelFactory viewModelFactory;


    public static ReposListFragment newInstance() {
        return new ReposListFragment();
    }

    @Override
    protected int getLayout() {
        return R.layout.repos_list_fragment;
    }

    @Override
    protected String getTitle() {
        return "Repository List";
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        repoListAdapter = new RepoListAdapter();
        repoList.setLayoutManager(new LinearLayoutManager(getContext()));
        repoList.setAdapter(repoListAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        repoListAdapter.setOnRepoSelect(this);
        networkViewModel = ViewModelProviders.of(this, viewModelFactory).get(NetworkViewModel.class);
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(RepolistViewModel.class);
        detailsViewModel = ViewModelProviders.of(this, viewModelFactory).get(DetailsViewModel.class);
        viewModel.getMessage().observe(this, obseMesage());
        networkViewModel.getRepoList().observe(this, showRepoList());
        networkViewModel.getError().observe(this, showToast());
        networkViewModel.loadRepo();

    }

    @OnClick({R.id.btnClick})
    public void setMessage(View view) {
        viewModel.setMessage("counter is " + counter);
        counter++;
    }


    private Observer<String> obseMesage() {
        return new Observer<String>() {
            @Override
            public void onChanged(String ms) {
                message.setText(ms);
            }
        };
    }


    private Observer<List<Repo>> showRepoList() {
        return new Observer<List<Repo>>() {
            @Override
            public void onChanged(List<Repo> repos) {
                repoListAdapter.setData(repos);
            }
        };
    }

    private Observer<String> showToast() {
        return new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getContext(), "", Toast.LENGTH_SHORT).show();
            }
        };
    }

    @Override
    public void onRepoSelected(Repo repo) {
        navigationUtil.replaceFragment(DetailsFragment.newInstance());
        detailsViewModel.setSelectedRepo(repo);
    }
}
