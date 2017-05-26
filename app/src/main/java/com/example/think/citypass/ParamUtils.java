package com.example.think.citypass;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.json.JSONObject;

import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.think.citypass.R.id.time;

/**
 * Created by think on 2017/5/26.
 */

public class ParamUtils {

    public static String createParam(String method, JSONObject params) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(new Date().getTime());
        JSONObject pp = new JSONObject();
        try {
            pp.put("customerID", 8001);//8001
            pp.put("requestTime", time);
            pp.put("Method", method);
            pp.put("customerKey", encodeByMD5("+6Hp9X5zR39SOI6oP0685Bk77gG56m7PkV89xYvl86A=" + method
                    + time));//"+6Hp9X5zR39SOI6oP0685Bk77gG56m7PkV89xYvl86A="
            // pp.put("customerKey", Constants.CUSTOMER_KEY);
            pp.put("appName", "CcooCity");//CcooCity
            pp.put("version", "1.0");//"1.0"
            pp.put("Param", params);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return pp.toString();
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
