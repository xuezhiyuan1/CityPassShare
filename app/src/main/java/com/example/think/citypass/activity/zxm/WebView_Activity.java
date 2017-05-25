package com.example.think.citypass.activity.zxm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import com.example.think.citypass.App;
import com.example.think.citypass.R;
import com.example.think.citypass.activity.zxm.shareboard.MainActivity;
import com.example.think.citypass.activity.zxm.shareboard.ShareboardActivity;
import com.example.think.citypass.common.base.BaseActivity;
import com.example.think.citypass.model.bean.ShouyeDetailBean;
import com.example.think.citypass.utils.LinuxUtils;
import com.example.think.citypass.utils.sharepreferencesutil.SharedPreferencesUtils;
import com.google.gson.Gson;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import okhttp3.*;

/**

 * <p>
 * <p>
 * <p>
 * <p>
 * param	{"customerID":8001,"requestTime":"2017-05-24 08:34:25","
 * Method":"PHSocket_GetCityNewsBody","customerKey":"62B6838F07BDFDB45859565CA512EBB3","
 * appName":"CcooCity","version":"4.5","Param":{"siteID":2422,"userID":29051757,"newsID":8208642,"sourceType":1},"
 * Statis":{"SiteId":2422,"UserId":29051757,"PhoneNo":"SM-C7000","SystemNo":2,"System_VersionNo":"Android 6.0.1","
 * PhoneId":"358811070949050","PhoneNum":""}}
 */


public class WebView_Activity extends BaseActivity {
    private JSONObject dbJson = new JSONObject();
    private int id;
    //progressbar  加载 2秒消失
    private LinearLayout layoutInflater;
    //titbar 上的字体
    private TextView textView;
    private WebView webView;
    private String url;
    private ProgressBar progressBar;

    CheckBox  zanCheck,commentCheck,shareCheck;

    //返回
    private ImageView backimage;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 200) {
                layoutInflater.setVisibility(View.GONE);
            } else {
                //loadData();
            }

        }

    };


    @Override
    protected int layoutId() {
        return R.layout.webview_activity;
    }

    @Override
    protected void initView() {
        layoutInflater = (LinearLayout) findViewById(R.id.ll_loading);
        backimage = (ImageView) findViewById(R.id.ViebView_backImg);

        progressBar = (ProgressBar) findViewById(R.id.webView_Progress);
        textView = (TextView) findViewById(R.id.ViebView_TextView);
        textView.setText("城事详情");
        webView = (WebView) findViewById(R.id.NewsList_WebView);
        shareCheck= (CheckBox) findViewById(R.id.detail_share);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        progressOnclike();
        backimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        /***
         *分享
         */
        shareBoard();
    }

    /***
     * 当网络数据在加载时,就让这个progressbar显示
     */
    private void progressOnclike() {

        webView.setWebChromeClient(new WebChromeClient() {

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) {
                    progressBar.setProgress(newProgress);
                    progressBar.setVisibility(View.INVISIBLE);
                } else {
                    progressBar.setProgress(newProgress);
                    progressBar.setVisibility(View.VISIBLE);
                }
            }
        });
    }


    /***
     * 通过前面传过来的newsID  在这里进行网络请求  然后返回一个对象里面的URI   webview直接加载
     */
    @Override
    protected void loadData() {
        Intent intent = getIntent();
        id = intent.getIntExtra("id", 123);
        Log.d("WebView_Activity", "id:" + id);
        handler.sendEmptyMessageDelayed(200, 2000);


        JSONObject jo = new JSONObject();
        try {
            jo.put("siteID", 2422);
            jo.put("newsID", id);
            jo.put("userID", 0);
            jo.put("sourceType", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JSONObject pp = new JSONObject();
        try {
            pp.put("customerID", "8001");//LinuxUtils.customerID
            pp.put("requestTime", LinuxUtils.requestTime);
            pp.put("Method", "PHSocket_GetCityNewsBody");//LinuxUtils.Method_WB
            pp.put("customerKey", LinuxUtils.encodeByMD5(LinuxUtils.CUSTOMER_KEY + LinuxUtils.Method_WB) + LinuxUtils.requestTime);//encodeByMD5(CUSTOMER_KEY+"PHSocket_GetCityNewsBody +time)"
            pp.put("appName", LinuxUtils.appName);
            pp.put("version", "4.5");
            pp.put("Param", jo);
            pp.put("Statis", LinuxUtils.createTongji());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final String str = pp.toString();
        Log.d("WebView_Activity", str);


        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        FormBody.Builder formBody = new FormBody.Builder();
        Map<String, String> param = new HashMap<>();
        param.put("param", str);
        if (param != null && param.size() > 0) {
            Set<String> set = param.keySet();
            for (String key : set) {
                String value = param.get(key);
                formBody.add(key, value);
            }
        }
        Request request = new Request.Builder()
                .url("http://appnew.ccoo.cn/appserverapi.ashx")
                .post(formBody.build())
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(WebView_Activity.this, "加载失败，请重新加载。。。", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String string = response.body().string();
               Log.i("---detailstring--",string);

                App.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        Gson gson = new Gson();
                        ShouyeDetailBean webBean = gson.fromJson(string, ShouyeDetailBean.class);

                        url = webBean.getServerInfo().getNewsInfo().get(0).getBody();
                        SharedPreferencesUtils.setParam(WebView_Activity.this,"url",url);
                        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
                        webView.getSettings().setJavaScriptEnabled(true);


                        //设置自适应屏幕，两者合用
                        webView.getSettings().setUseWideViewPort(true); //将图片调整到适合webview的大小
                        webView.getSettings().setLoadWithOverviewMode(true); // 缩放至屏幕的大小

                        webView.loadDataWithBaseURL("file:///android_assets/", WebView_Activity.this.url.replace("file:///", ""), "text/html", "utf-8", null);

                    }
                });

            }
        });


    }


    /**
     * 打开面板分享
     */
    private void shareBoard(){
    shareCheck.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            initFenXiang();
//            Intent  in=new Intent(WebView_Activity.this, ShareboardActivity.class);
//            startActivity(in);
        }
    });
    }

    private void   initFenXiang(){
        UMImage image = new UMImage(WebView_Activity.this, R.drawable.city);
//        String urla = (String) SharedPreferencesUtils.getParam(WebView_Activity.this, "url", "");
//        UMWeb  web=new UMWeb(urla);
        new ShareAction(WebView_Activity.this).setPlatform(SHARE_MEDIA.WEIXIN)
                .withText("城市通")
//                .withFollow(urla)
//                .withMedia(web)
                .withMedia(image)
                .setCallback(umShareListener)
                .open();
    }
    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //分享开始的回调
        }
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Log.d("plat","platform"+platform);

            Toast.makeText(WebView_Activity.this, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(WebView_Activity.this,platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
            if(t!=null){
                Log.d("throw","throw:"+t.getMessage());
            }
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(WebView_Activity.this,platform + " 分享取消了", Toast.LENGTH_SHORT).show();
        }
    };
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }

}
