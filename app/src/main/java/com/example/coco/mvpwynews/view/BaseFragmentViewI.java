package com.example.coco.mvpwynews.view;

import android.app.Activity;
import android.support.v4.app.FragmentManager;

/**
 * Created by coco on 2017/8/14.
 */

public interface BaseFragmentViewI {
    void showWrongPage(FragmentManager manager);
    void showEmptyPage(FragmentManager manager);
    void showSuccessPage(Object o);
    void showProcessDialog();
    void hideProcessDialog();
    void showErrorNetWorkInfo(Activity activity);

}
