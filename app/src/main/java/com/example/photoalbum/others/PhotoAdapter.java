package com.example.photoalbum.others;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.photoalbum.R;
import com.example.photoalbum.databinding.RecyclerViewItemBinding;
import com.example.photoalbum.model.Photos;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<Photos> mPhotoList;

    static class ViewHolder extends RecyclerView.ViewHolder{

        RecyclerViewItemBinding mRecyclerViewItemBinding;

        public ViewHolder(RecyclerViewItemBinding recyclerViewItemBinding){
            super(recyclerViewItemBinding.getRoot());
            this.mRecyclerViewItemBinding=recyclerViewItemBinding;
        }
    }

    public PhotoAdapter(Context context,List<Photos> photos){
        mContext=context;
        mPhotoList=photos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerViewItemBinding recyclerViewItemBinding= DataBindingUtil.inflate(LayoutInflater.from(mContext),
                R.layout.recycler_view_item,parent,false);
        return new ViewHolder(recyclerViewItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder= (ViewHolder) holder;
        //dataBinding绑定
        Photos photo=mPhotoList.get(position);
        viewHolder.mRecyclerViewItemBinding.setPhotos(photo);
    }


    @Override
    public int getItemCount() {
        return this.mPhotoList.size();
    }
}
