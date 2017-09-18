package com.example.coco.mvpwynews.http;

import com.example.coco.mvpwynews.bean.NewsBean;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by coco on 2017/8/13.
 */

public interface Api {
    String HOST = "https://api.tianapi.com/";
    String KEY="d73d3c76a06d24d93645d3fd735bf449";

    @GET("wxnews")
    Observable<NewsBean> getNewsMap(@QueryMap Map<String,String>map);
    @GET("wxnews")
    Observable<NewsBean> getNews(@Query("key")String key,
                                 @Query("page")String page,
                                 @Query("num")String num);

}
