package com.example.think.citypass.activity.zxm.findhouse;

import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.think.citypass.R;
import com.example.think.citypass.common.base.BaseActivity;

/**
 * Created by 张萌 on 2017/5/27.
 */

public class HouseQiugou  extends BaseActivity
{

    String  url="http://m.yanqing.ccoo.cn/post/fangwu/fc_qiugou.aspx";
    WebView  webView;
    @Override
    protected int layoutId() {
        return R.layout.webview;
    }

    @Override
    protected void initView() {
  webView= (WebView) findViewById(R.id.webview_normal);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {
        webView.setWebViewClient(new WebViewClient() {
            /* 重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边*/
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String ur) {

                view.loadUrl(url);
                url=ur;
                return true;
            }
        });



        webView.getSettings().setJavaScriptEnabled(true);


        //设置自适应屏幕，两者合用
        webView.getSettings().setUseWideViewPort(true); //将图片调整到适合webview的大小
        webView.getSettings().setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        webView.loadUrl(url);
    }
}
