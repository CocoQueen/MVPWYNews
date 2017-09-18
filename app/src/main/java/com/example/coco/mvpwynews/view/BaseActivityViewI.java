package com.example.coco.mvpwynews.view;

import android.app.Activity;

/**
 * Created by coco on 2017/8/14.
 */

public interface BaseActivityViewI {
    void showWrongPage();
    void showEmptyPage();
    void showSuccessPage(Object...obj);
    void showProcessDialog();
    void hideProcessDialog();
    void showErrorNetWorkInfo(Activity activity);
}
