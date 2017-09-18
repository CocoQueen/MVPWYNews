package com.example.coco.mvpwynews.ui.activity;

import android.app.ActionBar;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.coco.mvpwynews.R;
import com.example.coco.mvpwynews.app.MyApplication;
import com.example.coco.mvpwynews.base.BaseActivity;
import com.example.coco.mvpwynews.presenter.impl.WeChatDetailPresenter;

/**
 * Created by coco on 2017/8/15.
 */

public class WeChatDetailActivity extends BaseActivity {
    WebView web;
    WeChatDetailPresenter presenter=new WeChatDetailPresenter();

    @Override
    public void initDate() {
    presenter.getData(this);
    }

    @Override
    public void initView() {
        setContentView(R.layout.activity_wechatdetail);
        ActionBar bar = getActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        web= (WebView) findViewById(R.id.mWeb);
        WebSettings settings = web.getSettings();
        settings.setJavaScriptEnabled(true);
        presenter.attachView(this);

    }

    @Override
    public void showSuccessPage(Object... obj) {
        web.loadUrl((String) obj[0]);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MyApplication.getRefWatcher(this).watch(this);
    }
}
