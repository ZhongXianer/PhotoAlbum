package com.example.photoalbum.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.photoalbum.BR;
import com.example.photoalbum.R;
import com.example.photoalbum.databinding.ActivityMainBinding;
import com.example.photoalbum.model.Photos;
import com.example.photoalbum.viewModel.PhotosAdapter;
import com.example.photoalbum.viewModel.MainViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public ActivityMainBinding mainActivityBinding;
    private MainViewModel mainViewModel;
    private PhotosAdapter<Photos> photoAdapter;

    public List<Photos> photoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivityBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainViewModel = new MainViewModel(this);
        mainActivityBinding.setViewModel(mainViewModel);
        //初始化RecyclerView
        photoAdapter=new PhotosAdapter<>(this,getLayoutInflater(),
                R.layout.recycler_view_item, BR.photos, photoList);
        mainActivityBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mainActivityBinding.recyclerView.setAdapter(photoAdapter);
        //加载数据
        mainViewModel.loadPhotos();
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
//                                           @NonNull int[] grantResults) {
//        switch (requestCode){
//            case 1:
//                if (grantResults.length>0&&grantResults[0]== PackageManager.PERMISSION_GRANTED){
//                    mainViewModel.onClick(mainActivityBinding.addButton);
//                }else {
//                    Toast.makeText(this,"You denied the permission",Toast.LENGTH_SHORT).show();
//                }
//                break;
//            case 2:
//                if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
//                    mainViewModel.onClick(mainActivityBinding.addButton);
//                }else {
//                    Toast.makeText(this,"You denied the permission",Toast.LENGTH_SHORT).show();
//                }
//                break;
//            case 3:
//                if (grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
//                    mainViewModel.onClick(mainActivityBinding.addButton);
//                }else {
//                    Toast.makeText(this,"You denied the permission",Toast.LENGTH_SHORT).show();
//                }
//                break;
//                default:
//        }
//    }
}
