package com.example.coco.mvpwynews.app;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * Created by coco on 2017/8/13.
 *
 * 全局类：LeakCanary 检测所有的内存泄漏
 */

public class MyApplication extends Application {
    private RefWatcher refWatcher;

    public static RefWatcher getRefWatcher(Context context){
        MyApplication application = (MyApplication) context.getApplicationContext();
        return application.refWatcher;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)){
            return;
        }
        refWatcher= LeakCanary.install(this);
    }
}
