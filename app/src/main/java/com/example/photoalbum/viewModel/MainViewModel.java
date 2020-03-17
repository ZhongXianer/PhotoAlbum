package com.example.photoalbum.viewModel;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.view.View;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.cktim.camera2library.Camera2Config;
import com.cktim.camera2library.camera.Camera2RecordActivity;
import com.example.photoalbum.R;
import com.example.photoalbum.model.Photos;
import com.example.photoalbum.view.DescribeActivity;
import com.example.photoalbum.view.MainActivity;

import java.io.File;

public class MainViewModel {

    private MainActivity mActivity;


    public MainViewModel(MainActivity mainActivity){
        mActivity=mainActivity;
    }

    /**
     * 更新recyclerView的photoList
     */
    public void loadPhotos(){
        for (int i = 0; i < 10; i++) {
            Photos photos = new Photos();
            photos.setTitle("测试标题" + i);
            photos.setDescribe("测试描述" + i);
            mActivity.photoList.add(photos);
        }
    }

    /**
     * FloatingActionButton的点击事件
     */
    public void onClick(View view){
       initCamera2();
       checkPermission();
    }

    /**
     * 初始化Camera2的一些设置
     */
    @SuppressLint("SdCardPath")
    private void initCamera2(){
        Camera2Config.RECORD_MAX_TIME=10; //最长录制时间
        Camera2Config.RECORD_MIN_TIME=2; //最短录制时间
        Camera2Config.RECORD_PROGRESS_VIEW_COLOR= R.color.colorAccent; //录制条颜色
        Camera2Config.PREVIEW_MAX_HEIGHT=1000; //最大高度预览尺寸，默认大于1000的第一个

        @SuppressLint("SdCardPath") File file=new File("/mnt/sdcard/picture/");
        file.mkdirs(); //创建文件夹

        Camera2Config.PATH_SAVE_PIC="/mnt/sdcard/picture/"; //图片保存地址，注意要以/结束
        Camera2Config.PATH_SAVE_VIDEO="/mnt/sdcard/picture/"; //视频保存地址，注意要以/结束
        Camera2Config.ENABLE_CAPTURE=true; //是否开启拍照功能
        Camera2Config.ENABLE_RECORD=true; //是否开启录像功能
        //TODO
        //拍完照需要跳转的Activity，可以获取到保存的视频或者图像地址
        Camera2Config.ACTIVITY_AFTER_CAPTURE= DescribeActivity.class;
    }

    private void checkPermission(){
        if (ContextCompat.checkSelfPermission(mActivity, Manifest.permission.CAMERA)!=
                PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(mActivity,new String[]{Manifest.permission.CAMERA},1);
        }
        if (ContextCompat.checkSelfPermission(mActivity,Manifest.permission.RECORD_AUDIO)!=
                PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(mActivity,new String[]{Manifest.permission.RECORD_AUDIO},2);
        }
        if (ContextCompat.checkSelfPermission(mActivity,Manifest.permission.WRITE_EXTERNAL_STORAGE)!=
                PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(mActivity,new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},3);
        }
    }




}
