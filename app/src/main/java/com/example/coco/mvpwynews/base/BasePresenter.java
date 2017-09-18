package com.example.coco.mvpwynews.base;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by coco on 2017/8/14.
 */

public class BasePresenter {
    private CompositeSubscription subscription;

    public void addSubscription(Subscription subscription){
        if (this.subscription!=null){
            this.subscription=new CompositeSubscription();
        }
        this.subscription.add(subscription);
    }
    public void unsubcrible(){
        if (this.subscription!=null){
            this.subscription.unsubscribe();
        }
        this.subscription=null;
    }

}
