package com.example.think.citypass.activity.lxl.job;

import android.view.View;
import android.widget.ImageView;

import com.example.think.citypass.R;
import com.example.think.citypass.common.base.BaseActivity;

/**
 * Created by d on 2017/5/18.
 */

public class MyMoneyActivity extends BaseActivity implements View.OnClickListener {

    private ImageView imageView;
    @Override
    protected int layoutId() {
        return R.layout.mymoney_layout;
    }

    @Override
    protected void initView() {
        imageView = (ImageView) findViewById(R.id.btn_back_line);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
       imageView.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back_line:
               finish();
                break;
        }
    }
}
