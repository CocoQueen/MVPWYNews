package com.example.coco.mvpwynews.view;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;

import com.example.coco.mvpwynews.utils.NetUtils;

/**
 * Created by coco on 2017/8/14.
 */

public class BaseFragmentView implements BaseFragmentViewI {
    @Override
    public void showWrongPage(FragmentManager manager) {

    }

    @Override
    public void showEmptyPage(FragmentManager manager) {

    }

    @Override
    public void showSuccessPage(Object o) {

    }

    @Override
    public void showProcessDialog() {

    }

    @Override
    public void hideProcessDialog() {

    }

    @Override
    public void showErrorNetWorkInfo(final Activity activity) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (!NetUtils.isNet(activity)){
                    Toast.makeText(activity, "网络不可用", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
