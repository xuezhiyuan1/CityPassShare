package com.example.think.citypass.activity.zxm;

import android.os.AsyncTask;
import android.util.Log;

import com.example.think.citypass.R;
import com.example.think.citypass.common.base.BaseActivity;
import com.example.think.citypass.utils.LinuxUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by 张萌 on 2017/5/31.
 */

public class Login  extends BaseActivity {
    @Override
    protected int layoutId() {
            return R.layout.username_login;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

        new AsyncGetNetIp(new getIP() {
            @Override
            public void setIP(String ip) {
                Log.i("ip-----",ip);
            }
        }).execute("");
    }

    @Override
    protected void loadData() {

        final String s = LinuxUtils.createnewsParam("PHSocket_CheckUserLogin",getLogin());

        final String params1 = "param="
                + s.replace(
                "+6Hp9X5zR39SOI6oP0685Bk77gG56m7PkV89xYvl86A=",
                "%2b6Hp9X5zR39SOI6oP0685Bk77gG56m7PkV89xYvl86A=");// 规整编码并且返回





        new Thread(new Runnable() {
                    @Override
                    public void run() {
                        byte[] bytes = doPostSubmit("http://appnew.ccoo.cn/appserverapi.ashx", params1);
                        String string = new String(bytes);
                        Log.i("string", string);
                    }
                }).start();

    }


    public JSONObject getLogin(){
        JSONObject jo = new JSONObject();
        try {
            jo.put("loginName", "18501942142");
            jo.put("userPWD", "123456");
            // jo.put("siteID", siteID);
            jo.put("ip","219.143.131.254");
            jo.put("post", "8000");
            jo.put("version", "android 4.3");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  jo;

    }

    public byte[] doPostSubmit(String url, final String params) {
        BufferedOutputStream bos = null;
        HttpURLConnection httpConn = null;

        try {
            URL urlObj;
            urlObj = new URL(url);
            httpConn = (HttpURLConnection) urlObj.openConnection();
            httpConn.setDoOutput(true);
            httpConn.setRequestMethod("POST");
            httpConn.setConnectTimeout(10000);
            if (params != null) {
                byte[] data = params.getBytes();
                bos = new BufferedOutputStream(httpConn.getOutputStream());
                bos.write(data);
                bos.flush();
            }
            System.out.println("==getResponseCode========="
                    + httpConn.getResponseCode());
            if (httpConn.getResponseCode() == 200) {
                return streamToByte(httpConn.getInputStream());
            } else {
                Log.i("请求失败","失败");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
                httpConn.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public static byte[] streamToByte(InputStream is) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int c = 0;
        byte[] buffer = new byte[8 * 1024];
        try {
            while ((c = is.read(buffer)) != -1) {
                baos.write(buffer, 0, c);
                baos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return baos.toByteArray();
    }
    class AsyncGetNetIp extends AsyncTask<String, String, String> {

        getIP getip;

        public AsyncGetNetIp(getIP getip) {
            super();
            this.getip = getip;
        }

        @Override
        protected String doInBackground(String... params) {
            return GetNetIp();
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if (result != null) {
                getip.setIP(result);
            }
        }

        public String GetNetIp() {
            URL infoUrl = null;
            InputStream inStream = null;
            try {
                infoUrl = new URL("http://apitest.ccoo.cn/GetIPAddress.ashx");
                URLConnection connection = infoUrl.openConnection();
                HttpURLConnection httpConnection = (HttpURLConnection) connection;
                int responseCode = httpConnection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    inStream = httpConnection.getInputStream();
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(inStream, "utf-8"));
                    StringBuilder strber = new StringBuilder();
                    String line = null;
                    while ((line = reader.readLine()) != null)
                        strber.append(line + "\n");
                    inStream.close();
                    // Log.i("IP地址啊", strber.toString().replace("\n", ""));
                    return strber.toString().replace("\n", "");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "";
        }

    }

    interface getIP {
        void setIP(String ip);
    }



}
