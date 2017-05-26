package com.example.think.citypass.activity.lxl.job;

import android.view.View;
import android.widget.TextView;

import com.example.think.citypass.R;
import com.example.think.citypass.common.base.BaseActivity;
/**
 * Created by d on 2017/5/24.
 */

public class TwoHouseActivity extends BaseActivity {
    private TextView mCloseText;
    @Override
    protected int layoutId() {
        return R.layout.twohouse_activity;
    }

    @Override
    protected void initView() {
        mCloseText= (TextView) findViewById(R.id.Close_Two);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        mCloseText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void loadData() {

    }
}
