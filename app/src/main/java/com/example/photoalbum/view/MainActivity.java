package com.example.photoalbum.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.photoalbum.BR;
import com.example.photoalbum.R;
import com.example.photoalbum.databinding.ActivityMainBinding;
import com.example.photoalbum.model.Photos;
import com.example.photoalbum.others.PhotoAdapter;
import com.example.photoalbum.others.PhotosAdapter;
import com.example.photoalbum.viewModel.MainViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public ActivityMainBinding mActivityMainBinding;
    private MainViewModel mViewModel;

    private PhotoAdapter mPhotoAdapter;
    public List<Photos> mPhotoList = new ArrayList<>();
    private FloatingActionButton addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mViewModel = new MainViewModel(this);
        mActivityMainBinding.setViewModel(mViewModel);
        //初始化RecyclerView
        PhotosAdapter<Photos> photosAdapter=new PhotosAdapter<>(this,getLayoutInflater(),
                R.layout.recycler_view_item, BR.photos,mPhotoList);
        mActivityMainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mActivityMainBinding.recyclerView.setAdapter(photosAdapter);
        //加载数据
        mViewModel.loadPhotos();
    }
}
