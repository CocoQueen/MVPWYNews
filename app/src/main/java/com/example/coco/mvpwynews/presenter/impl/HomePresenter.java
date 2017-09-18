package com.example.coco.mvpwynews.presenter.impl;

import android.content.Context;

import com.example.coco.mvpwynews.presenter.HomePresenterl;
import com.example.coco.mvpwynews.ui.adapter.HomeRecAdapter;
import com.example.coco.mvpwynews.view.BaseFragmentViewI;
import com.example.coco.mvpwynews.view.HomeViewI;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by coco on 2017/8/14.
 */

public class HomePresenter implements HomePresenterl {
    private BaseFragmentViewI baseFragmentViewI;
    private Context context;
    private HomeViewI homeViewI;

    @Override
    public HashMap getViewPagerData() {
        String[] args = {"http://img0.pclady.com.cn/pclady/1607/19/1546921_23.jpg",
                "http://img5.duitang.com/uploads/item/201602/22/20160222162052_8jSfL.jpeg",
                "http://img5q.duitang.com/uploads/item/201504/13/20150413H2605_LYRWc.jpeg",
                "http://img3.duitang.com/uploads/item/201601/09/20160109100712_PayAn.thumb.700_0.jpeg",
                "http://img2.imgtn.bdimg.com/it/u=2893242806,1610137204&fm=23&gp=0.jpg"};

        HashMap<String, String> map = new HashMap<>();
        map.put("1", args[0]);
        map.put("2", args[1]);
        map.put("3", args[2]);
        map.put("4", args[3]);
        map.put("5", args[4]);

        baseFragmentViewI.hideProcessDialog();
        if (homeViewI != null) {
            homeViewI.showViewPager(map);
        }

        return map;
    }

    @Override
    public void getListData() {
        ArrayList<String> list = new ArrayList<>();
        list.add("深入浅出RxJava(一：基础篇)");
        list.add("深入浅出RxJava(二：操作符)");
        list.add("深入浅出RxJava三–响应式的好处");
        list.add("深入浅出RxJava四-在Android中使用响应式编程");
        list.add("给 Android 开发者的 RxJava 详解");
        list.add("Github项目：RxJava-Android-Samples101 Rx Samples");
        list.add("101 Rx Samples");
        list.add("RxJava操作符（一）Creating Observables ");
        list.add("知乎：谁来讲讲Rxjava、rxandroid中的操作符的作用?");

        HomeRecAdapter adapter=new HomeRecAdapter(context,list);
        if (homeViewI!=null){
            homeViewI.showList(adapter);
        }

    }
    public void attachView(BaseFragmentViewI baseFragmentViewI,Context context){
        this.baseFragmentViewI=baseFragmentViewI;
        this.context=context;
        homeViewI= (HomeViewI) this.baseFragmentViewI;
    }
}
