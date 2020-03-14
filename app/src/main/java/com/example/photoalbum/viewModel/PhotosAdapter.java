package com.example.photoalbum.viewModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PhotosAdapter<Photos> extends RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder> {

    private Context context;
    private LayoutInflater layoutInflater;
    private int layoutId;
    private int variableId;
    private List<Photos> photosList;

    public PhotosAdapter(Context context, LayoutInflater layoutInflater, int layoutId, int variableId, List<Photos> photosList) {
        this.context = context;
        this.layoutInflater = layoutInflater;
        this.layoutId = layoutId;
        this.variableId = variableId;
        this.photosList = photosList;
    }


    @NonNull
    @Override
    public PhotosAdapter.PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding viewDataBinding = DataBindingUtil.inflate(layoutInflater, layoutId, parent, false);
        PhotoViewHolder photoViewHolder = new PhotoViewHolder(viewDataBinding.getRoot().getRootView());
        photoViewHolder.setViewDataBinding(viewDataBinding);
        return photoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PhotosAdapter.PhotoViewHolder holder, int position) {
        holder.setContent(photosList.get(position));
    }

    @Override
    public int getItemCount() {
        return photosList.size();
    }

    public class PhotoViewHolder extends RecyclerView.ViewHolder {

        ViewDataBinding viewDataBinding;

        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void setViewDataBinding(ViewDataBinding viewDataBinding) {
            this.viewDataBinding = viewDataBinding;
        }

        public void setContent(Photos photos) {
            viewDataBinding.setVariable(variableId, photos);
            viewDataBinding.executePendingBindings();
        }
    }
}
