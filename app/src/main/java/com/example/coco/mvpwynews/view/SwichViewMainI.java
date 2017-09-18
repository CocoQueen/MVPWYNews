package com.example.coco.mvpwynews.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by coco on 2017/8/14.
 */

public interface SwichViewMainI {
    void swichPage();
    void showFragment(FragmentManager manager, Fragment fragment,String str);
}
