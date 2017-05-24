package com.example.think.citypass.activity.lxl.job;

import android.view.View;
import android.widget.ImageView;

import com.example.think.citypass.R;
import com.example.think.citypass.common.base.BaseActivity;

/**
 * Created by d on 2017/5/16.
 */

public class JianLiKuActivity extends BaseActivity {
    private ImageView mBack;
    @Override
    protected int layoutId() {
        return R.layout.recruitment_jianliku;
    }
    @Override
    protected void initView() {
        mBack= (ImageView) findViewById(R.id.btn_back);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        mBack.setOnClickListener(new View.OnClickListener() {
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
