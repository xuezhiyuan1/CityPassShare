package com.example.think.citypass.activity.zxm;

import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.think.citypass.R;
import com.example.think.citypass.common.base.BaseActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 张萌 on 2017/5/26.
 */

public class Workdetail  extends BaseActivity{
    private String url="http://m.yanqing.ccoo.cn/post/zhaopin/#andriod_redirect";
     WebView  webView;

    @Override
    protected int layoutId() {
            return R.layout.workdetail;
    }

    @Override
    protected void initView() {
  webView= (WebView) findViewById(R.id.workdetail_);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {
        webView.setWebViewClient(new WebViewClient(){

        });


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


    private void load(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        FormBody.Builder formBody = new FormBody.Builder();
        Map<String, String> param = new HashMap<>();
        param.put("param", RequestData01());
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
    }



    /**
     * TODO 请求网络数据
     */
    private String RequestData01() {
        JSONObject jo = new JSONObject();
        try {
            jo.put("siteID", "2422");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final String params =createParam(
                "PHSocket_GetSiteHotJobKindList", jo);
//        new SocketManager2(requestHandler).request(params, 0);
        return  params;
    }

    private String RequestData02() {
        JSONObject jo = new JSONObject();
        try {
            // jo.put("siteID", cityId);
            jo.put("siteID", "2422");
            // jo.put("areaID",0);
            jo.put("kID", 0);
            jo.put("cID", 0);
            jo.put("salary", 0);
            jo.put("edu", 0);
            jo.put("record", 0);
            jo.put("welfare", "");
            jo.put("keyWord", "");
            jo.put("curPage", 1);
            jo.put("pageSize", 9);
            jo.put("order", 1);

        } catch (JSONException e) {
            e.printStackTrace();
        }
//        MFLAG = flag;
        String params = createParam("PHSocket_GetJobInfoList",
                jo);
//        manager.request(params, 0);
        return params;
    }

    private String RequestData03() {// 请求名企
        JSONObject jo = new JSONObject();
        try {
            jo.put("siteID", "2422");
            jo.put("curPage", 1);
            jo.put("pageSize", 10);

        } catch (JSONException e) {
            e.printStackTrace();
        }
//        MFLAG = flag;
        String params = createParam(
                "PHSocket_GetFamousEnterpriseTopJobList", jo);
//        manager.request(params, 0);
        return params;
    }

    private String RequestData04() {// 请求龙头企业
        JSONObject jo = new JSONObject();
        try {
            jo.put("siteID", "2422");
            jo.put("curPage", 1);
            jo.put("pageSize", 10);

        } catch (JSONException e) {
            e.printStackTrace();
        }
//        MFLAG = flag;
        String params = createParam(
                "PHSocket_GetLongTouTopJobList", jo);
        Log.i("--params",params.toString());
//        manager.request(params, 0);
        return params;

    }




    // 首页下载接口字符串
    public static String createParam(String method, JSONObject params) {
        String time = dateFormat(new Date().getTime());
        JSONObject pp = new JSONObject();
        try {
            pp.put("customerID", 8001);
            pp.put("requestTime", time);
            pp.put("Method", method);
            pp.put("customerKey", encodeByMD5("+6Hp9X5zR39SOI6oP0685Bk77gG56m7PkV89xYvl86A=" + method
                    + time));
            // pp.put("customerKey", Constants.CUSTOMER_KEY);
            pp.put("appName", "CcooCity");
            pp.put("version", "1.0");
            pp.put("Param", params);
            pp.put("Statis", createTongji());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pp.toString();
    }

    // 将毫秒转换为指定格式日期
    public static String dateFormat(long l) {// new Date().getTime()是当前的毫秒数

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
        String date = df.format(l);// 将当前事件转换为指定格式的日期
        System.out.println(date);// 打印指定格式的日期
        return date;
    }

    // 统计接口字符串
    public static JSONObject createTongji() {
        JSONObject pp = new JSONObject();
        try {
            pp.put("SiteId",0);
            pp.put("UserId",0);
            pp.put("PhoneNo", android.os.Build.MODEL);
            pp.put("SystemNo", 2);
            pp.put("System_VersionNo", "Android " + android.os.Build.VERSION.RELEASE);
            pp.put("PhoneId", "");
            pp.put("PhoneNum","0");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return pp;
    }



    /** 对字符串进行MD5加密 */
    public static String encodeByMD5(String originString) {
        if (originString != null) {
            try {
                // 创建具有指定算法名称的信息摘要
                MessageDigest md = MessageDigest.getInstance("MD5");
                // 使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
                byte[] results = md.digest(originString.getBytes());
                // 将得到的字节数组变成字符串返回
                String resultString = byteArrayToHexString(results);
                return resultString.toUpperCase();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    /** 将一个字节转化成十六进制形式的字符串 */
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    // 十六进制下数字到字符的映射数组
    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };






}
