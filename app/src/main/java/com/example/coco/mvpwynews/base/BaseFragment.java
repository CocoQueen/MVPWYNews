package com.example.coco.mvpwynews.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.coco.mvpwynews.R;
import com.example.coco.mvpwynews.ui.fragment.EmptyFragment;
import com.example.coco.mvpwynews.ui.fragment.ErrrorFragment;
import com.example.coco.mvpwynews.utils.NetUtils;
import com.example.coco.mvpwynews.utils.ToastUtils;
import com.example.coco.mvpwynews.view.BaseFragmentViewI;
import com.example.coco.mvpwynews.widget.MyDialog;

/**
 * Created by coco on 2017/8/14.
 */

public abstract class BaseFragment extends Fragment implements BaseFragmentViewI {

    private String[] tags = {"home", "wechat", "wy", "gank", "wrong", "empty"};
    private BasePresenter presenter;
    private EmptyFragment emptyFragment = new EmptyFragment();
    private ErrrorFragment errrorFragment = new ErrrorFragment();
    public LayoutInflater inflater;

    public void setPresenter(BasePresenter presenter) {
        this.presenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.inflater = inflater;
        View view = initView();
        initData();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        showErrorNetWorkInfo(getActivity());
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            showErrorNetWorkInfo(getActivity());
        }
    }

    public void initData() {
        showProcessDialog();
    }

    public abstract View initView();

    @Override
    public void showWrongPage(FragmentManager manager) {
        showFragment(manager, errrorFragment, "wrong");
    }

    private void showFragment(FragmentManager manager, Fragment fragment, String wrong) {
        FragmentTransaction transaction;
        transaction = manager.beginTransaction();
        for (String tag :
                tags) {
            if (!tag.equals(wrong)) {
                Fragment byTag = manager.findFragmentByTag(tag);
                if (byTag != null) {
                    transaction.hide(byTag);
                }
            }

        }
        if (manager.findFragmentByTag(wrong) == null) {
            transaction.add(R.id.fl, fragment, wrong);
        }
        transaction.show(fragment);
        transaction.commit();
    }


    @Override
    public void showEmptyPage(FragmentManager manager) {
        showFragment(manager, emptyFragment, "empty");
    }

    @Override
    public void showSuccessPage(Object o) {
        showSuccessFragment(o);
    }

    protected abstract void showSuccessFragment(Object o);


    @Override
    public void showProcessDialog() {
        MyDialog.showDialog(getActivity());
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
                if (!NetUtils.isNet(activity)) {
                    ToastUtils.show(activity, "网络不可用");
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.unsubcrible();
        }
    }
}
