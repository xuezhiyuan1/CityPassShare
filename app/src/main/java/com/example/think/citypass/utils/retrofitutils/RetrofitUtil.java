package com.example.think.citypass.utils.retrofitutils;

import com.example.think.citypass.model.http.IHttp;
import com.example.think.citypass.model.http.callback.ResaultCallBack;
import com.google.gson.Gson;

import java.io.IOException;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by think on 2017/5/14.
 */

public class RetrofitUtil implements IHttp {

    //公用的Url
    private String baseUrl = "http://www.baidu.com/";
    private Retrofit retrofit;
    private static RetrofitUtil retrofitUtil = null;
    private NetWork netWork;

    private RetrofitUtil() {
        retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        netWork = retrofit.create(NetWork.class);
    }

    public static RetrofitUtil getInstance() {

        if (retrofitUtil == null) {
            synchronized (RetrofitUtil.class) {
                retrofitUtil = new RetrofitUtil();
            }
        }
        return retrofitUtil;
    }

    public void getRetrofit(String url, Map<String, String> params, final ResaultCallBack callBack, final Class tClass) {
        if (params.size() == 0 || params == null) {
            callBack.onErrorParams("参数错误");
            throw  new RuntimeException("参数错误");
        } else
        {
            Call<ResponseBody> call = netWork.getLoad(url, params);
            call.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response.isSuccessful()) {
                        try {
                            callBack.onSuccess(getGeneric(response.body().string(),tClass));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        callBack.notNet("无网络连接");
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    callBack.onError(t.getMessage());
                }
            });
        }
    }


    public  void postRetrofit(String url, Map<String, String> params, final ResaultCallBack callBack, final Class tClass) {
        if (params.size() == 0 || params == null) {
            callBack.onErrorParams("参数错误");
        } else {
            Call<ResponseBody> loadpost =netWork.getLoadpost(url,params);
            loadpost.enqueue(new Callback<ResponseBody>() {
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if (response.isSuccessful()) {
                        try {
                            callBack.onSuccess(getGeneric(response.body().string(),tClass));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        callBack.notNet("无网络连接");
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {
                    callBack.onError(t.getMessage());
                }
            });
        }
    }

    private Object getGeneric(String jsonData, Class c) {
        Gson gson = new Gson();
//        Type[] types = callBack.getClass().getGenericInterfaces();
//        Type[] typeArguments = ((ParameterizedType) types[0]).getActualTypeArguments();
         return gson.fromJson(jsonData, c);
    }
}
