package com.example.think.citypass.activity.zzh;

import android.widget.Button;
import android.widget.LinearLayout;

import com.example.think.citypass.R;
import com.example.think.citypass.common.base.BaseActivity;

/**
 * Created by ASUS on 2017/6/2.
 */

public class PostDetailActivity extends BaseActivity {

    private Button backBtn,fatieBtn,shareBtn;
    private LinearLayout loadLL;


    @Override
    protected int layoutId()  {
        return R.layout.post_detail;
    }

    @Override
    protected void initView() {
        backBtn = (Button) findViewById(R.id.post_btn_back);
        fatieBtn = (Button) findViewById(R.id.post_btn_fatie);
        shareBtn = (Button) findViewById(R.id.post_btn_share);
        loadLL = (LinearLayout) findViewById(R.id.ll_loading);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {

    }
}
