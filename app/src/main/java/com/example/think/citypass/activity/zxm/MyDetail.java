package com.example.think.citypass.activity.zxm;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.think.citypass.R;
import com.example.think.citypass.common.base.BaseActivity;

public class MyDetail extends BaseActivity {
    TextView zhanghao,nicheng,name,sex,old,work,mood,loc,sign,phonebind,wechat,qq,dengji,xunzhang,chengshibi;
    ImageView  image;
    @Override
    protected int layoutId() {
        return R.layout.activity_my_detail;
    }

    @Override
    protected void initView() {
        image= (ImageView) findViewById(R.id.logindetail_image);
        dengji= (TextView) findViewById(R.id.logindetail_dengji);
        zhanghao= (TextView) findViewById(R.id.logindetail_zhanghao);
        nicheng= (TextView) findViewById(R.id.logindetail_nicheng);
        name= (TextView) findViewById(R.id.logindetail_name);
        sex= (TextView) findViewById(R.id.logindetail_sex);
        old= (TextView) findViewById(R.id.logindetail_old);
        work= (TextView) findViewById(R.id.logindetail_work);
        mood= (TextView) findViewById(R.id.logindetail_mood);
        loc= (TextView) findViewById(R.id.logindetail_loc);
        sign= (TextView) findViewById(R.id.logindetail_sign);
        phonebind= (TextView) findViewById(R.id.logindetail_bindphone);
        wechat= (TextView) findViewById(R.id.logindetail_WeChat);
        qq= (TextView) findViewById(R.id.logindetail_QQ);
        dengji= (TextView) findViewById(R.id.logindetail_dengji);
        xunzhang= (TextView) findViewById(R.id.logindetail_xunzhang);
        chengshibi= (TextView) findViewById(R.id.logindetail_citybi1);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences  share=getSharedPreferences("data",MODE_PRIVATE);
        zhanghao.setText(share.getString("zhanghao",""));
        nicheng.setText(share.getString("name",""));
        name.setText(share.getString("name",""));
        sex.setText(share.getString("sex",""));
        old.setText(share.getString("xingzuo",""));
        work.setText(share.getString("work",""));
        loc.setText(share.getString("loc",""));
        sign.setText(share.getString("sign",""));
        phonebind.setText(share.getString("mobile",""));
        dengji.setText(share.getString("honorname",""));
        Glide.with(MyDetail.this).load(share.getString("image","")).into(image);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {

    }
}
