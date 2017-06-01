package com.example.think.citypass.activity.zxm.findhouse;

import android.webkit.WebView;

import com.example.think.citypass.R;
import com.example.think.citypass.common.base.BaseActivity;

import static com.example.think.citypass.R.id.webview_normal;

/**
 * Created by 张萌 on 2017/5/31.
 */

public class NewHouse extends BaseActivity{
    String  url="http://m.yanqing.ccoo.cn/post/xinloupan";
    WebView  webView;
    @Override
    protected int layoutId() {
        return R.layout.webview;
    }

    @Override
    protected void initView() {
   webView= (WebView) findViewById(webview_normal);
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
