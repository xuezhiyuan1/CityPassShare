package com.example.think.citypass.activity.lxl.job;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.think.citypass.App;
import com.example.think.citypass.R;
import com.example.think.citypass.activity.zxm.FindworkActivity;
import com.example.think.citypass.common.base.BaseFragment;

/**
 * Created by d on 2017/5/16.
 * 这是我的“生活”模块
 * 李祥磊
 */

public class AllRecruitmentFragment extends BaseFragment {
    private TextView QuanZhi,JianZhi,JianLiKu,worker,house;
    //无网络加载试图
    LinearLayout linearLayout;
//    private ViewPa
    @Override
    protected int layoutId() {
        return R.layout.all_life_all;
    }

    @Override
    protected void initView(View view) {
        QuanZhi= (TextView) view.findViewById(R.id.QuanZhizhaopin_text1);
        JianZhi= (TextView) view.findViewById(R.id.JianZhizhaopin_text2);
        JianLiKu= (TextView) view.findViewById(R.id.JianLiKuzhaopin_text3);
        worker= (TextView) view.findViewById(R.id.job_textworker);
        house= (TextView) view.findViewById(R.id.house_textHouse);
        //无网络加载试图
        linearLayout = (LinearLayout) view.findViewById(R.id.ll_loading);
    }

    @Override
    protected void initData() {

    }

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if(msg.what == 200){
                linearLayout.setVisibility(View.GONE);
                Toast.makeText(getContext(), "加载成功", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    });
    @Override
    protected void initListener() {
           QuanZhi.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent=new Intent(App.activity,JianLiKuActivity.class);
                  startActivity(intent);
               }
           });
        JianZhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(getContext(),Recruitment_JianZhiActivity.class);
                startActivity(in);
            }
        });
        JianLiKu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getContext(),JianLiKuActivity.class);
                startActivity(intent1);
            }
        });
        worker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(getContext(), FindworkActivity.class);
                startActivity(intent2);
            }
        });
        house.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(getContext(), FingSouseActivity.class);
                startActivity(intent3);
            }
        });
    }

    @Override
    protected void loadData() {
        handler.sendEmptyMessageDelayed(200,2000);
    }
}
