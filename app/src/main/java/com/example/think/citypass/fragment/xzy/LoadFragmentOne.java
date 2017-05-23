package com.example.think.citypass.fragment.xzy;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import com.example.think.citypass.App;
import com.example.think.citypass.R;
import com.example.think.citypass.activity.lxl.job.MyMoneyActivity;
import com.example.think.citypass.activity.zxm.CityChoiceActivity;
import com.example.think.citypass.common.base.BaseFragment;
import com.example.think.citypass.common.config.FragmentBuilder;
import com.example.think.citypass.common.config.Urls;
import com.example.think.citypass.fragment.zzh.naonao.NaonaoDiFragment;
import com.example.think.citypass.model.entity.FindBean;
import com.example.think.citypass.model.http.callback.ResaultCallBack;
import com.example.think.citypass.utils.retrofitutils.RetrofitUtil;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;

/**
 * Created by think on 2017/5/16.
 */

public class LoadFragmentOne extends BaseFragment implements View.OnClickListener {

    private LinearLayout city_money_choujiang;
    private LinearLayout talk_city;
    private LinearLayout linearLayout;


    @Override
    protected int layoutId() {
        return R.layout.find_main;
    }
    //发送空消息2秒后显示界面  即  隐藏Load布局
//    这是一个测试
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if(msg.what == 200){
                linearLayout.setVisibility(View.GONE);
            }
            return true;
        }
    });
    @Override
    protected void initView(View view) {
        linearLayout = (LinearLayout) view.findViewById(R.id.in_loading);
        talk_city = (LinearLayout) view.findViewById(R.id.talk_city);
        city_money_choujiang = (LinearLayout) view.findViewById(R.id.city_money_choujiang);
    }

    @Override
    protected void initData() {
        handler.sendEmptyMessageDelayed(200,2000);
    }

    @Override
    protected void initListener() {
        city_money_choujiang.setOnClickListener(this);
        talk_city.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
        /*JSONObject jo = new JSONObject();
        try {
            jo.put("siteID",2422);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(new Date().getTime());

        JSONObject pp = new JSONObject();
        try {
            pp.put("customerID",8001);
            pp.put("requestTime", time);
            pp.put("Method", "PHSocket_GetFindNavigationInfo");
            pp.put("customerKey", "+6Hp9X5zR39SOI6oP0685Bk77gG56m7PkV89xYvl86A=PHSocket_GetFindNavigationInfo"+time);
            pp.put("appName", "CcooCity");
            pp.put("version","1.0");
            pp.put("Param", jo);
            pp.put("Statis", createTongji());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String str=pp.toString();

        Log.d("FXFragment", str);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        FormBody.Builder formBody = new FormBody.Builder();
        Map<String, String> param = new HashMap<>();
        param.put("param",str);
        if (param != null && param.size() > 0) {
            Set<String> set = param.keySet();
            for (String key : set) {
                String value = param.get(key);
                formBody.add(key, value);
            }
        }
        Request request = new Request.Builder()
                .url("http://appnew.ccoo.cn/appserverapi.ashx")
                .post(formBody.build())
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.d("FXFragment", string);
                Gson gson=new Gson();
                FindBean fxBean = gson.fromJson(string, FindBean.class);

            }
        });*/
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.city_money_choujiang:
                Intent intent = new Intent(getActivity(),MyMoneyActivity.class);
                startActivity(intent);
                break;

            case R.id.talk_city:
                FragmentBuilder.getInstance().show(NaonaoDiFragment.class).builder();
                break;
        }
    }
}
