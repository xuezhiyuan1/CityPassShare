package com.example.think.citypass.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.think.citypass.R;
import com.example.think.citypass.activity.lxl.job.MyMoneyActivity;
import com.example.think.citypass.activity.shezhi.SheZhiActivity;
import com.example.think.citypass.activity.zxm.LoginActivity;
import com.example.think.citypass.activity.zxm.MyLevel;
import com.example.think.citypass.activity.zxm.MyShoucang;
import com.example.think.citypass.activity.zxm.MyZiliao;
import com.example.think.citypass.activity.zxm.ShouyeNotice;
import com.example.think.citypass.activity.zxm.baidumap.LocationActivity;
import com.example.think.citypass.common.base.BaseFragment;
import com.example.think.citypass.model.bean.LoginBean;
import com.example.think.citypass.myview.MysoclListview;
import com.example.think.citypass.utils.sharepreferencesutil.SharedPreferencesUtils;
import com.google.gson.Gson;


/**
 * Created by ASUS on 2017/5/22.
 */

public class HomeFragment extends BaseFragment {
    private TextView mCityMoney,mSheZhi;
    TextView  username,textView;
    ImageView  imageView;
    LinearLayout mainccoo_dengji_layout,mainccoo_xunzhang_layout;

    SharedPreferences  share;
    LinearLayout  user_login_begin,mainccoo_main_layout,mainccoo_collect_layout,mainccoo_message_layout;
    @Override
    protected int layoutId() {
        return com.example.think.citypass.R.layout.activity_home_fragment;
    }

    @Override
    protected void initView(View view) {
        mCityMoney= (TextView)view.findViewById(com.example.think.citypass.R.id.My_City_MoneyText);
        mSheZhi= (TextView)view.findViewById(com.example.think.citypass.R.id.SheZhi);
      username= (TextView) view.findViewById(com.example.think.citypass.R.id.username_meng);
        imageView= (ImageView) view.findViewById(com.example.think.citypass.R.id.userimage_meng);
        textView= (TextView) view.findViewById(com.example.think.citypass.R.id.usersign);
        user_login_begin= (LinearLayout) view.findViewById(com.example.think.citypass.R.id.user_login_begin);
        mainccoo_main_layout= (LinearLayout) view.findViewById(com.example.think.citypass.R.id.mainccoo_main_layout);
        mainccoo_collect_layout= (LinearLayout) view.findViewById(R.id.mainccoo_collect_layout);
        mainccoo_message_layout= (LinearLayout) view.findViewById(R.id.mainccoo_message_layout);
        mainccoo_dengji_layout= (LinearLayout) view.findViewById(R.id.mainccoo_dengji_layout);
        mainccoo_xunzhang_layout= (LinearLayout) view.findViewById(R.id.mainccoo_xunzhang_layout);
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

        user_login_begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent=new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        mainccoo_main_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent=new Intent(getContext(), MyZiliao.class);
                startActivity(intent);
            }
        });
        mainccoo_collect_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent=new Intent(getContext(), MyShoucang.class);
                startActivity(intent);
            }
        });

        mainccoo_message_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent=new Intent(getContext(), ShouyeNotice.class);
                startActivity(intent);
            }
        });
        mainccoo_dengji_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),MyLevel.class);
                startActivity(intent);
            }
        });
        mainccoo_xunzhang_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent=new Intent(getContext(),MyXunzhang.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void loadData() {

        share=getContext().getSharedPreferences("data", Context.MODE_PRIVATE);
    }


    @Override
    public void onResume() {
        super.onResume();
        boolean login = share.getBoolean("login", false);
        if(login){
            String name = share.getString("rolename", "未得到名字");
            String image = share.getString("roleimg", "未得到图片");
            Glide.with(getContext()).load(image).into(imageView);
            username.setText(name);
            textView.setText(share.getString("sign",""));
//            Toast.makeText(this, "home---"+name+image, Toast.LENGTH_SHORT).show();
        }
    }
}
