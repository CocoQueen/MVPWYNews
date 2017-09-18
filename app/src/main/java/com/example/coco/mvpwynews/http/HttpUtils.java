package com.example.coco.mvpwynews.http;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by coco on 2017/8/13.
 *
 * 网络数据下载工具类
 */

public class HttpUtils {
    private static HttpUtils utils = new HttpUtils();
    private String baseurl = "";
    private Api api;

    private HttpUtils() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        api = retrofit.create(Api.class);

    }

    public static HttpUtils getInstance() {
        return utils;
    }

    public Api getApi() {
        return api;
    }
}
