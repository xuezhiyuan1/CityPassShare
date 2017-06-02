package com.example.think.citypass.activity.shezhi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.think.citypass.R;
import com.example.think.citypass.activity.zxm.LoginActivity;
import com.example.think.citypass.activity.zxm.MyDetail;
import com.example.think.citypass.common.base.BaseActivity;

/**
 * Created by d on 2017/5/18.
 */

public class SheZhiActivity extends BaseActivity {
    private TextView mText, mTextMessage,mTiXing,mJianYiFanKui,mPassWorld,My_Persson;
    RelativeLayout  mydetail_relative;
    ImageView  geren_image;
    @Override
    protected int layoutId() {
        return R.layout.shezhi_activity;
    }

    @Override
    protected void initView() {
        mPassWorld= (TextView) findViewById(R.id.My_Passworld);
        mTextMessage= (TextView) findViewById(R.id.Message_TiXing);
        mydetail_relative= (RelativeLayout) findViewById(R.id.mydetail_relative);
        geren_image= (ImageView) findViewById(R.id.geren_image);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        mPassWorld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.My_Passworld:
                        Intent intent=new Intent(SheZhiActivity.this,MyPasswordActivity.class);
                        startActivity(intent);
                        break;

                }
            }
        });
        mTextMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.Message_TiXing:
                        Intent intent=new Intent(SheZhiActivity.this,MessageInfoActivity.class);
                        startActivity(intent);
                        break;

                }
            }
        });




    }


    @Override
    protected void onResume() {
        super.onResume();
        mydetail_relative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences  share=getSharedPreferences("data",MODE_PRIVATE);
                boolean login = share.getBoolean("login", false);
                if(login){
                    Intent  intent=new Intent(SheZhiActivity.this, MyDetail.class);
                    startActivity(intent);
                }else{
                    Intent  intent=new Intent(SheZhiActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

        SharedPreferences  share=getSharedPreferences("data",MODE_PRIVATE);
        Glide.with(SheZhiActivity.this).load(share.getString("image","")).into(geren_image);


    }

    @Override
    protected void loadData() {

    }
}
