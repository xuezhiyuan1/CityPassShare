package com.example.think.citypass.model.http;

import com.example.think.citypass.model.http.callback.ResaultCallBack;

import java.util.Map;

/**
 * Created by ASUS on 2017/5/14.
 */

public interface IHttp {

    /**
     * get请求
     *
     * @param url
     * @param params
     * @param callBack
     */
    void getRetrofit(String url, Map<String, String> params, ResaultCallBack callBack,Class tClass);

    /**
     * post请求
     *
     * @param url
     * @param params
     * @param callBack
     */
    void postRetrofit(String url, Map<String, String> params, final ResaultCallBack callBack,Class tClass);
}
