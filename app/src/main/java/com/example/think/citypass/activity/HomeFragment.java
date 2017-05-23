package com.example.think.citypass.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.example.think.citypass.R;
import com.example.think.citypass.activity.lxl.job.MyMoneyActivity;
import com.example.think.citypass.activity.shezhi.SheZhiActivity;
import com.example.think.citypass.common.base.BaseFragment;

/**
 * Created by ASUS on 2017/5/22.
 */

public class HomeFragment extends BaseFragment {
    private TextView mCityMoney,mSheZhi;
    @Override
    protected int layoutId() {
        return R.layout.activity_home_fragment;
    }

    @Override
    protected void initView(View view) {
        mCityMoney= (TextView)view.findViewById(R.id.My_City_MoneyText);
        mSheZhi= (TextView)view.findViewById(R.id.SheZhi);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        mCityMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), MyMoneyActivity.class);
                startActivity(intent);
            }
        });
        mSheZhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getContext(), SheZhiActivity.class);
                startActivity(intent1);
            }
        });

    }

    @Override
    protected void loadData() {

    }
}
