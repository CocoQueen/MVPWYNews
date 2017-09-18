package com.example.coco.mvpwynews.view;

import com.example.coco.mvpwynews.ui.adapter.HomeRecAdapter;

import java.util.HashMap;

/**
 * Created by coco on 2017/8/14.
 */

public interface HomeViewI extends BaseFragmentViewI{

    void showViewPager(HashMap map);
    void showList(HomeRecAdapter adapter);
}
