package com.example.think.citypass.model.http;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by think on 2017/5/14.
 */

public interface NetWork {
    @GET()
    Call<ResponseBody> getLoad();

    @POST("")
    @FormUrlEncoded
    Call<ResponseBody> getLoadpost(@FieldMap Map<String, String> params);
}