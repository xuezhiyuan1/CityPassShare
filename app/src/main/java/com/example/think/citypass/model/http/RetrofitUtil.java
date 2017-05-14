package com.example.think.citypass.model.http;

import com.google.gson.Gson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by think on 2017/5/14.
 */

public class RetrofitUtil {

    private Retrofit retrofit;
    private static RetrofitUtil retrofitUtil = null;
    private RetrofitUtil(){
        retrofit = new Retrofit.Builder().build();
    }
    public synchronized static RetrofitUtil getRetrofitUtil(){
        if(retrofitUtil == null){
            retrofitUtil = new RetrofitUtil();
        }
        return retrofitUtil;
    }

    private <T>void getRetrofit(String url, Map<String,String> params, final ResaultCallBack<T> callBack){
        if(params.size() == 0 || params == null){
            callBack.onErrorParams("参数错误");
        }else{
            Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
            NetWork netWork = retrofit.create(NetWork.class);
            Call<ResponseBody> call = netWork.getLoad();
            call.enqueue(new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                      if(response.isSuccessful()){
                          T t = getGeneric(response.body().toString(),callBack);
                          callBack.onSuccess(t);
                      }else {
                          callBack.notNet("无网络连接");
                      }
                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    callBack.onError("网络请求错误");
                }
            });
        }
    }


    private <T>void postRetrofit(String url, Map<String,String> params, final ResaultCallBack<T> callBack){
        if(params.size() == 0 || params == null){
            callBack.onErrorParams("参数错误");
        }else{
            Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
            NetWork netWork = retrofit.create(NetWork.class);
            Call<ResponseBody> loadpost = netWork.getLoadpost(params);
            loadpost.enqueue(new Callback() {
                @Override
                public void onResponse(Call call, Response response) {
                     if(response.isSuccessful()){
                         T t = getGeneric(response.body().toString(),callBack);
                         callBack.onSuccess(t);
                     }else {
                         callBack.notNet("没有网络连接");
                     }
                }

                @Override
                public void onFailure(Call call, Throwable t) {
                     callBack.onError("网络请求错误");
                }
            });
        }

    }

    private <T> T getGeneric(String jsonData,ResaultCallBack<T> callBack){
        Gson gson = new Gson();
        Type[] types = callBack.getClass().getGenericInterfaces();
        Type[] typeArguments = ((ParameterizedType) types[0]).getActualTypeArguments();
        T t = gson.fromJson(jsonData, typeArguments[0]);
        return t;
    }


}
