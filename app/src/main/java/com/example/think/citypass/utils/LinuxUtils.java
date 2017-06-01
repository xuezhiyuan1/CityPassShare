package com.example.think.citypass.utils;

import android.graphics.pdf.PdfDocument;


import com.example.think.citypass.App;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;


/**

 */

public class LinuxUtils {
    private LinuxUtils() {
    }
    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
    public static final String customerID = "8001";
    //应用名字
    public static final String appName = "CcooCity";
    public static final String requestTime = getSystemTime();
    public static  final  String Method = "PHSocket_SetRegSendCode";
    //CUSTOMER_ID  用于字符拼接
    public static final int CUSTOMER_ID = 8001;

    //详情加载webview
    public static  final  String Method_WB = "PHSocket_GetCityNewsBody";
    public static String version = "1.0";
    //MD5加密用的key值
    public static  final String CUSTOMER_KEY = "+6Hp9X5zR39SOI6oP0685Bk77gG56m7PkV89xYvl86A=";
    //手机验证码验证
    public static final  String PHSocket_GetPhoneRegCodeCheck = "PHSocket_GetPhoneRegCodeCheck";
    //生活列表1.1请求字符串

    public static final String PHSocket_GetNewPostLiveInfoTwo = "PHSocket_GetNewPostLiveInfoTwo";




    // 首页下载接口字符串
    public static String createnewsParam(String method, JSONObject params) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(new Date().getTime());
        JSONObject pp = new JSONObject();
        try {
            pp.put("customerID", CUSTOMER_ID);
            pp.put("requestTime", getSystemTime());
            pp.put("Method", method);
            pp.put("customerKey", encodeByMD5(CUSTOMER_KEY + method
                    + time));
            // pp.put("customerKey", Constants.CUSTOMER_KEY);
            pp.put("appName", appName);
            pp.put("version", version);
            pp.put("Param", params);
            pp.put("Statis", createTongji());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pp.toString();
    }

    public static JSONObject createTongji() {
        JSONObject pp = new JSONObject();
        try {
            pp.put("SiteId", 2422);
            pp.put("UserId", 0);
            pp.put("PhoneNo", android.os.Build.MODEL);
            pp.put("SystemNo", 2);
            pp.put("System_VersionNo", "Android " + android.os.Build.VERSION.RELEASE);
            pp.put("PhoneId", App.PHONEID);
            pp.put("PhoneNum", App.phoneNumber);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return pp;
    }


    private static String getSystemTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date(System.currentTimeMillis()));
    }


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


    //用户信息获取
    public static String createParamsPerson(String username) {
        JSONObject jo = new JSONObject();
        try {
            jo.put("siteID", 2422);
            jo.put("userName", username);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String params = LinuxUtils.createnewsParam(
                "PHSocket_GetBBSUsersInfoNew", jo);
        return params;
    }




}
