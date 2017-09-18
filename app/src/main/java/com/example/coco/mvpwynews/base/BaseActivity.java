package com.example.coco.mvpwynews.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.example.coco.mvpwynews.R;
import com.example.coco.mvpwynews.utils.NetUtils;
import com.example.coco.mvpwynews.view.BaseActivityViewI;
import com.example.coco.mvpwynews.widget.MyDialog;

/**
 * Created by coco on 2017/8/14.
 */

public abstract class BaseActivity extends FragmentActivity implements BaseActivityViewI {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initDate();
    }

    public abstract void initDate();

    public abstract void initView();

    @Override
    public void showWrongPage() {
        setContentView(R.layout.wrongpage);

    }

    @Override
    public void showEmptyPage() {
        setContentView(R.layout.emptypage);

    }

    @Override
    public void showSuccessPage(Object... obj) {

    }

    @Override
    public void showProcessDialog() {
        MyDialog.showDialog(this);

    }

    @Override
    public void hideProcessDialog() {
        MyDialog.hideDialog();

    }

    @Override
    public void showErrorNetWorkInfo(final Activity activity) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (NetUtils.isNet(activity)) {
                    Toast.makeText(activity, "网络不可用", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
