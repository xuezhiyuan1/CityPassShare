package com.example.think.citypass.activity;

import android.content.SharedPreferences;
import android.os.Handler;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.think.citypass.App;
import com.example.think.citypass.R;
import com.example.think.citypass.common.base.BaseActivity;
import com.example.think.citypass.utils.sharepreferencesutil.SharedPreferencesUtils;

public class MainActivity extends BaseActivity {
  ImageView  imageView;
    String roleimg;
    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
    imageView= (ImageView) findViewById(R.id.main_Icon);
    }

    @Override
    protected void initData() {
        SharedPreferences  share=getSharedPreferences("data",MODE_PRIVATE);
       roleimg = share.getString("roleimg", "");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Glide.with(MainActivity.this).load(roleimg).into(imageView);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //是否进入引导页
                if (!(Boolean) SharedPreferencesUtils.getParam(App.activity, "guideKey", false)) {
                    setIntent(App.activity, GuideActivity.class);
                } else {
                    setIntent(App.activity, HomeActivity.class);
                }
                finish();
            }
        }, 2000);
    }

}
