package com.example.think.citypass.fragment.xzy;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
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
import com.example.think.citypass.model.http.callback.ResaultCallBack;
import com.example.think.citypass.utils.retrofitutils.RetrofitUtil;

import java.util.HashMap;
import java.util.Map;

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
