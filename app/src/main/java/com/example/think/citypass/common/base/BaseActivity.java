package com.example.think.citypass.common.base;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.example.think.citypass.App;
import com.example.think.citypass.R;
import com.example.think.citypass.utils.Zhuangtailan.StatusBarCompat;

import static com.example.think.citypass.App.activity;
import static com.zhy.autolayout.utils.ScreenUtils.getStatusBarHeight;

/**
 * Created by think on 2017/5/14.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = this;
        setContentView(layoutId());
        fragmentManager = getSupportFragmentManager();
        initView();
        initData();
        initListener();
        loadData();
    }

    /**
     * 返回View对象
     */

    protected abstract int layoutId();

    /**
     * 初始化资源Id
     */
    protected abstract void initView();

    /**
     * 初始化对象
     */
    protected abstract void initData();

    /**
     * 初始化监听
     */
    protected abstract void initListener();


    /**
     * 加载数据
     */
    protected abstract void loadData();

    public void setIntent(Context context, Class<? extends BaseActivity> toClass) {
        Intent intent = new Intent(context, toClass);
        context.startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        activity = this;
    }
}
