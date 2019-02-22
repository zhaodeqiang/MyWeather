package com.zdq.myweather.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;


public class HttpUtil {
    /**
     * 发送Http请求
     * @param address 地址
     * @param callback 回调函数
     */
    public static  void sendOkHttpRequest(String address,okhttp3.Callback callback){
        OkHttpClient okHttpClient = new OkHttpClient();
        //默认get请求
        Request request = new Request.Builder().url(address).build();
        okHttpClient.newCall(request).enqueue(callback);
    }
}
