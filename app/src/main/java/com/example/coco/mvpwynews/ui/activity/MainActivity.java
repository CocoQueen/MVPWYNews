package com.example.coco.mvpwynews.ui.activity;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MotionEvent;
import android.widget.RadioGroup;

import com.example.coco.mvpwynews.R;
import com.example.coco.mvpwynews.base.BaseActivity;
import com.example.coco.mvpwynews.ui.fragment.GankFragment;
import com.example.coco.mvpwynews.ui.fragment.HomeFragment;
import com.example.coco.mvpwynews.ui.fragment.WYFragment;
import com.example.coco.mvpwynews.ui.fragment.WeChatFragment;
import com.example.coco.mvpwynews.view.SwichViewMainI;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements SwichViewMainI, RadioGroup.OnCheckedChangeListener {
    private static final String TAG = "MainActivity";
    private String[] tags = {"home", "wechat", "wy", "gank"};
    private FragmentManager manager;
    private HomeFragment home = new HomeFragment();
    private WeChatFragment weChat = new WeChatFragment();
    private GankFragment gank = new GankFragment();
    private WYFragment wy = new WYFragment();
    private RadioGroup group;
    private FragmentTransaction transaction;
    private List<MyOnTouchListener> list = new ArrayList<>(10);

    @Override
    public void initDate() {

    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_main);
        group = (RadioGroup) findViewById(R.id.rg);
        swichPage();
        showFragment(manager, home, "home");

    }

    @Override
    public void swichPage() {
        manager = getSupportFragmentManager();
        group.setOnCheckedChangeListener(this);
    }

    @Override
    public void showFragment(FragmentManager manager, Fragment fragment, String str) {
        transaction = manager.beginTransaction();
        for (String tag :
                tags) {
            if (!tag.equals(str)) {
                Fragment byTag = manager.findFragmentByTag(tag);
                if (byTag != null) {
                    transaction.hide(byTag);
                }
            }
        }
        if (manager.findFragmentByTag(str) == null) {
            transaction.add(R.id.fl, fragment, str);
        }
        transaction.show(fragment);
        transaction.commit();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.home:
                showFragment(manager, home, "home");
                break;
            case R.id.wechat:
                showFragment(manager, weChat, "wechat");
                break;
            case R.id.wy:
                showFragment(manager, wy, "wy");
                break;
            case R.id.gank:
                showFragment(manager, gank, "gank");
                break;
        }
    }

    @Override
    public void showSuccessPage(Object... obj) {
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        for (MyOnTouchListener listener :
                list) {
            listener.onTouch(ev);
        }
        return super.dispatchTouchEvent(ev);

    }

    public void registerListener(MyOnTouchListener listener) {
        list.add(listener);
    }

    public void unregisterListener(MyOnTouchListener listener) {
        list.remove(listener);
    }

    public interface MyOnTouchListener {
        boolean onTouch(MotionEvent event);
    }
}
