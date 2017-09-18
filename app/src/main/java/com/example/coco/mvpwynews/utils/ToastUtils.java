package com.example.coco.mvpwynews.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by coco on 2017/8/13.
 *
 * 吐司工具类
 */

public class ToastUtils {
    private static Toast toast;

    public static void show(Context context,String str){
        if (toast==null){
            toast=Toast.makeText(context,str,Toast.LENGTH_SHORT);
        }else{
            toast.setText(str);
        }
        toast.show();
    }
}
