package com.example.coco.mvpwynews.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Created by coco on 2017/8/13.
 * <p>
 * 网络连接工具类：检测所有的网络连接（wifi or mobile）
 */

public class NetUtils {
    private static final String TAG = "NetUtils";
    static boolean wifi = false;//wifi连接
    static boolean mobile = false;//数据网络连接

    public static boolean isNet(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo[] info = manager.getAllNetworkInfo();
        for (NetworkInfo net : info) {
            String typeName = net.getTypeName();
            if (typeName.equals("WIFI")) {
                Log.e(TAG, "isNet: wifi");
                if (net.isConnected()) {
                    wifi = true;
                }
            }
            if (typeName.equals("MOBILE")) {
                Log.e(TAG, "isNet: mobile");
                if (net.isConnected()) {
                    mobile = true;
                }
            }
        }
        return wifi || mobile;
    }
}
