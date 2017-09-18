package com.example.coco.mvpwynews.presenter.impl;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;

import com.example.coco.mvpwynews.presenter.BasePresenterl;
import com.example.coco.mvpwynews.view.BaseActivityViewI;

/**
 * Created by coco on 2017/8/14.
 */

public class WeChatDetailPresenter implements BasePresenterl {
    BaseActivityViewI baseActivityViewI;
    private String url;

    @Override
    public Object getData(Object o) {
        Activity activity = (Activity) o;
        Intent intent = activity.getIntent();
        if (intent!=null){
            url=intent.getStringExtra("url");
            if (TextUtils.isEmpty(url)){
                if (baseActivityViewI!=null){
                    baseActivityViewI.showEmptyPage();
                }
            }else{
                baseActivityViewI.showSuccessPage(url);
            }
        }

        return null;
    }

    @Override
    public Object getData() {
        return null;
    }
    public void attachView(BaseActivityViewI baseActivityViewI){
        this.baseActivityViewI=baseActivityViewI;
    }
}
