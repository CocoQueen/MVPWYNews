package com.example.coco.mvpwynews.widget;

import android.app.Activity;
import android.support.v7.app.AlertDialog;

import com.example.coco.mvpwynews.R;

/**
 * Created by coco on 2017/8/14.
 *
 * 对话框类
 */

public class MyDialog {
    private static AlertDialog dialog;

    public static void showDialog(Activity activity){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(R.layout.process_dialog);
        dialog=builder.create();
        dialog.show();
    }
    public static void hideDialog(){
        if (dialog!=null&&dialog.isShowing()){
            dialog.dismiss();
        }
    }
}
