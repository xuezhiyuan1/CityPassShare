package com.example.think.citypass.activity.zxm;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.think.citypass.App;
import com.example.think.citypass.R;
import com.example.think.citypass.activity.HomeActivity;
import com.example.think.citypass.common.base.BaseActivity;
import com.example.think.citypass.common.config.FragmentBuilder;
import com.example.think.citypass.fragment.zxm.ShouYeFragment;
import com.example.think.citypass.model.bean.LoginBean;
import com.example.think.citypass.model.bean.UserMessage;
import com.example.think.citypass.model.http.callback.ResaultCallBack;
import com.example.think.citypass.utils.LinuxUtils;
import com.example.think.citypass.utils.http.HttpCallBack;
import com.example.think.citypass.utils.http.RetrofitImpl;
import com.example.think.citypass.utils.retrofitutils.RetrofitUtil;
import com.example.think.citypass.utils.sharepreferencesutil.SharedPreferencesUtils;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
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
import java.util.HashMap;
import java.util.Map;

import retrofit2.Retrofit;

import static android.R.attr.fragment;

/**
 * Created by 张萌 on 2017/5/22.
 */

public class LoginActivity extends BaseActivity {
    TextView registerText;
    EditText loginnumber, loginpassword;
    TextView loginbutton;
    String string;
    SharedPreferences  share;
    SharedPreferences.Editor  editor;
   ImageView  btn_back_login;
    @Override
    protected int layoutId() {
        return R.layout.username_login;
    }

    @Override
    protected void initView() {
        registerText = (TextView) findViewById(R.id.textView_user_register);
        loginbutton = (TextView) findViewById(R.id.login_button);
        loginnumber = (EditText) findViewById(R.id.login_number);
        loginpassword = (EditText) findViewById(R.id.login_password);
        btn_back_login= (ImageView) findViewById(R.id.btn_back_login);
    }

    @Override
    protected void initData() {
   share=getSharedPreferences("data",MODE_PRIVATE);
        editor=share.edit();
    }

    @Override
    protected void initListener() {
        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        SharedPreferencesUtils.setParam(getBaseContext(), "login", false);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(loginnumber.getText())) {
                    Toast.makeText(LoginActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(loginpassword.getText())) {
                    Toast.makeText(LoginActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (loginnumber.length() < 4) {
                    Toast.makeText(LoginActivity.this, "用户名不合法", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (loginpassword.length() <= 5) {
                    Toast.makeText(LoginActivity.this, "输入的密码不合法", Toast.LENGTH_SHORT).show();
                    return;
                }
                String name = loginnumber.getText().toString().trim();
                String pwd = loginpassword.getText().toString().trim();

                loadDataNet(name, pwd);
                loginbutton.setText("登陆中");



            }
        });

        btn_back_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "--登录成功--", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }



    @Override
    protected void loadData() {

    }

    public void loadDataNet(String number, String password) {

        final String s = LinuxUtils.createnewsParam("PHSocket_CheckUserLogin", getLogin(number, password));

        final String params1 = "param="
                + s.replace(
                "+6Hp9X5zR39SOI6oP0685Bk77gG56m7PkV89xYvl86A=",
                "%2b6Hp9X5zR39SOI6oP0685Bk77gG56m7PkV89xYvl86A=");// 规整编码并且返回


        new Thread(new Runnable() {
            @Override
            public void run() {
                byte[] bytes = doPostSubmit("http://appnew.ccoo.cn/appserverapi.ashx", params1);
                string = new String(bytes);
                Log.i("string", string);
                Gson  gson=new Gson();
                LoginBean loginBean = gson.fromJson(string, LoginBean.class);
                if(loginBean.getMessageList().getCode()==1000){
                    String roleImg = loginBean.getServerInfo().getRoleImg();
                    String roleName = loginBean.getServerInfo().getRoleName();
                    editor.putString("rolename",roleName);
                    editor.putString("roleimg",roleImg);
                    editor.putBoolean("login",true);
                    editor.commit();
                    Map<String, String> map = new HashMap<String, String>();
                    String par = LinuxUtils.createParamsPerson(roleName);
                    map.put("param", par);
                    RetrofitImpl.getInstance().Post(UserMessage.class, "http://appnew.ccoo.cn/appserverapi.ashx", map, new HttpCallBack() {
                        @Override
                        public void onSuccessful(Object success) {
                            UserMessage  ss= (UserMessage) success;
                            String roleName1 =ss.getServerInfo().getName();
                            Log.i("--string222",success.toString()+"----"+roleName1);
                        }

                        @Override
                        public void onError(String errorMessage) {

                        }
                    });

                            LoginActivity.this.finish();
                }else{
//                    Toast.makeText(App.activity, "密码输入错误,请重新输入", Toast.LENGTH_SHORT).show();
                }
            }
        }).start();


    }


    public void loadDataNet2(String number) {
        JSONObject loginMessage = getLoginMessage(number);
        final String s = LinuxUtils.createnewsParam("PHSocket_GetBBSUsersInfoNew",loginMessage);

//        final String params1 = "param="
//                + s.replace(
//                "+6Hp9X5zR39SOI6oP0685Bk77gG56m7PkV89xYvl86A=",
//                "%2b6Hp9X5zR39SOI6oP0685Bk77gG56m7PkV89xYvl86A=");// 规整编码并且返回


        new Thread(new Runnable() {
            @Override
            public void run() {
                byte[] bytes = doPostSubmit2("http://appnew.ccoo.cn/appserverapi.ashx");
                string = new String(bytes);
                Log.i("string222222", string);

            }
        }).start();


    }






    public JSONObject getLogin(String number, String password) {
        JSONObject jo = new JSONObject();
        try {
            jo.put("loginName", number);
            jo.put("userPWD", password);
            // jo.put("siteID", siteID);
            jo.put("ip", "219.143.131.254");
            jo.put("post", "8000");
            jo.put("version", "android 4.3");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jo;

    }

    public JSONObject getLoginMessage(String name) {
        JSONObject jo = new JSONObject();
        try {
            jo.put("siteID", "2422");
            jo.put("userName", name);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String params = LinuxUtils.createnewsParam(
                "PHSocket_GetBBSUsersInfoNew", jo);

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
                Log.i("请求失败", "失败");
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










    public byte[] doPostSubmit2(String url) {
        BufferedOutputStream bos = null;
        HttpURLConnection httpConn = null;

        try {
            URL urlObj;
            urlObj = new URL(url);
            httpConn = (HttpURLConnection) urlObj.openConnection();
            httpConn.setDoOutput(true);
            httpConn.setRequestMethod("POST");
            httpConn.setConnectTimeout(10000);
//            if (params != null) {
//                byte[] data = params.getBytes();
//                bos = new BufferedOutputStream(httpConn.getOutputStream());
//                bos.write(data);
//                bos.flush();
//            }
            System.out.println("==getResponseCode========="
                    + httpConn.getResponseCode());
            if (httpConn.getResponseCode() == 200) {
                return streamToByte(httpConn.getInputStream());
            } else {
                Log.i("请求失败", "失败");
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

        Login.getIP getip;

        public AsyncGetNetIp(Login.getIP getip) {
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



