package com.example.think.citypass.activity.zxm;

import android.content.SharedPreferences;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.think.citypass.R;
import com.example.think.citypass.activity.zxm.popupwindow.ShouyeSendTie;
import com.example.think.citypass.common.base.BaseActivity;
import com.example.think.citypass.erweima.decoding.Intents;

/**
 * Created by 张萌 on 2017/6/5.
 */

public class MyZiliao  extends BaseActivity {
    ImageView    head_imageview;
    TextView top_title;
    @Override
    protected int layoutId() {
        return R.layout.my_zhuye;
    }

    @Override
    protected void initView() {
   head_imageview= (ImageView) findViewById(R.id.head_imageview);
        top_title= (TextView) findViewById(R.id.top_title);
    }

    @Override
    protected void initData() {


    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences  share=getSharedPreferences("data",MODE_PRIVATE);
        SharedPreferences.Editor  editor=share.edit();
        String image = share.getString("image", "");
        String name = share.getString("name", "");
        top_title.setText(name);
        Glide.with(MyZiliao.this).load(image).into(head_imageview);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {

    }
}
