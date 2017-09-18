package com.example.coco.mvpwynews.presenter.impl;

import android.content.Context;

import com.example.coco.mvpwynews.base.BasePresenter;
import com.example.coco.mvpwynews.bean.NewsBean;
import com.example.coco.mvpwynews.http.Api;
import com.example.coco.mvpwynews.presenter.WeChatPresenterl;
import com.example.coco.mvpwynews.ui.fragment.WeChatFragment;
import com.example.coco.mvpwynews.view.BaseFragmentViewI;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by coco on 2017/8/14.
 */

public class WeChatPresenter extends BasePresenter implements WeChatPresenterl{
private int pageId=1;
    private static final String TAG = "WeChatPresenter";
    private BaseFragmentViewI baseFragmentViewI;
    private Context context;
    private List<NewsBean>list=new ArrayList<>();


    @Override
    public void getData(Api api) {
        Observable<NewsBean> observable = api.getNews(Api.KEY, pageId + "", "10");
        Subscription subscribe = observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<NewsBean>() {
                    @Override
                    public void call(NewsBean newsBean) {
                        List<NewsBean.NewslistBean> newslist = newsBean.getNewslist();
                        list.addAll(0,list);
                        baseFragmentViewI.showSuccessPage(list);
                        baseFragmentViewI.hideProcessDialog();
                        WeChatFragment fragment = (WeChatFragment) baseFragmentViewI;
                        fragment.spr.setRefreshing(false);
                    }
                });
        addSubscription(subscribe);

    }
    public void attachView(BaseFragmentViewI baseFragmentViewI,Context context){
        this.baseFragmentViewI=baseFragmentViewI;
        this.context=context;
    }
    public void setPageId(int pageId){
        this.pageId=pageId;
    }
}
