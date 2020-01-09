package com.example.dagger2rxjav2mvm.repolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.dagger2rxjav2mvm.R;
import com.example.dagger2rxjav2mvm.base.RecyclyViewBaseAdapter;
import com.example.dagger2rxjav2mvm.data.model.Repo;

import butterknife.BindView;

/**
 * Created by Irfan Ul Haq on 07/01/2020.
 */
public class RepoListAdapter extends RecyclyViewBaseAdapter<Repo> {
    private OnRepoSelect onRepoSelect;
    @Override
    protected BaseViewHolder getViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, int viewType) {
        return new RepoViewHolder(layoutInflater.inflate(R.layout.view_repo_list_item, viewGroup, false));
    }

    public void setOnRepoSelect(OnRepoSelect onRepoSelect) {
        this.onRepoSelect = onRepoSelect;
    }

    protected final class RepoViewHolder extends BaseViewHolder {
        @BindView(R.id.tv_repo_name)
        TextView repoNameTextView;
        @BindView(R.id.tv_repo_description)
        TextView repoDescriptionTextView;
        @BindView(R.id.tv_forks)
        TextView forksTextView;
        @BindView(R.id.tv_stars)
        TextView starsTextView;

        public RepoViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onRepoSelect.onRepoSelected(getItem(getAdapterPosition()));
                }
            });
        }

        @Override
        protected void bind(Repo repo) {
            repoNameTextView.setText(repo.name);
            repoDescriptionTextView.setText(repo.description);
            forksTextView.setText(String.valueOf(repo.forks));
            starsTextView.setText(String.valueOf(repo.stars));
        }
    }


    public interface OnRepoSelect {
        void onRepoSelected(Repo repo);
    }
}
