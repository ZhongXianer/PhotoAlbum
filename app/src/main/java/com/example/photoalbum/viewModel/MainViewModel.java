package com.example.photoalbum.viewModel;

import com.example.photoalbum.model.Photos;
import com.example.photoalbum.view.MainActivity;

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
            mActivity.mPhotoList.add(photos);
        }
    }

    /**
     * FloatingActionButton的点击事件
     */
    public void onClick(){

    }
}
