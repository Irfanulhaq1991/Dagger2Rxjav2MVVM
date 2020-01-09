package com.example.dagger2rxjav2mvm.base;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * @CreatedBy: Irfan Khan
 * @Date: 12/31/2019
 */
public abstract class RecyclyViewBaseAdapter<T> extends RecyclerView.Adapter<RecyclyViewBaseAdapter<T>.BaseViewHolder> {

    protected abstract BaseViewHolder getViewHolder(LayoutInflater layoutInflater, ViewGroup viewGroup, int viewType);

    private List<T> data = new ArrayList<>();

    public RecyclyViewBaseAdapter() {

    }

    public RecyclyViewBaseAdapter(List<T> data) {
        this.data = data;
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(List<T> newData) {
        this.data = newData;
        notifyDataSetChanged();
    }

    protected T getItem(int position) {
        return data.get(position);
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return getViewHolder(LayoutInflater.from(parent.getContext()), parent, viewType);
    }

    @Override
    public int getItemViewType(int position) {
        /**
         * @Default: Handler the view type with respect to position in getViewHolder.
         */
        return position;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    protected abstract class BaseViewHolder extends RecyclerView.ViewHolder {
        protected abstract void bind(T t);

        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
