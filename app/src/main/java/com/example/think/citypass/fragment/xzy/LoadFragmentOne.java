package com.example.think.citypass.fragment.xzy;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;

import com.example.think.citypass.App;
import com.example.think.citypass.R;
import com.example.think.citypass.activity.lxl.job.AllRecruitmentFragment;
import com.example.think.citypass.activity.lxl.job.MyMoneyActivity;
import com.example.think.citypass.common.base.BaseFragment;
import com.example.think.citypass.common.config.FragmentBuilder;

/**
 * Created by think on 2017/5/16.
 */

public class LoadFragmentOne extends BaseFragment {
    private LinearLayout city_money_choujiang;
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
        city_money_choujiang = (LinearLayout) view.findViewById(R.id.city_money_choujiang);
    }

    @Override
    protected void initData() {
        handler.sendEmptyMessageDelayed(200,2000);
    }

    @Override
    protected void initListener() {
        city_money_choujiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected void loadData() {

    }
}
