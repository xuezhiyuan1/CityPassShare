package com.example.think.citypass.activity.zxm;

import android.widget.ImageView;

import com.example.think.citypass.R;
import com.example.think.citypass.common.base.BaseActivity;

/**
 * Created by 张萌 on 2017/5/24.
 */

public class ShouyeSendTie   extends BaseActivity {
    ImageView  photoimage;
    @Override
    protected int layoutId() {
        return R.layout.shouye_fatie;
    }

    @Override
    protected void initView() {
    photoimage= (ImageView) findViewById(R.id.tiezi_photo);
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
