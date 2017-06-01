package com.example.think.citypass;

import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.os.Vibrator;
import android.telephony.TelephonyManager;

import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.mapapi.SDKInitializer;
import com.example.think.citypass.activity.zxm.baidumap.LocationService;
import com.example.think.citypass.activity.zxm.baidumap.MyLocationListener;
import com.example.think.citypass.common.base.BaseActivity;
import com.example.think.citypass.common.base.BaseFragment;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * Created by think on 2017/5/14.
 */

public class App extends Application {
    public  static  Integer  TAG=0;
    public LocationClient mLocationClient = null;
    public LocationService locationService;
    public Vibrator mVibrator;
    public BDLocationListener myListener = (BDLocationListener) new MyLocationListener();
    public static BaseActivity activity;
    public static BaseFragment lastFragment;
    public static BaseFragment banquFragment;
    public static String phoneNumber = "0";
    public static String PHONEID;

    @Override
    public void onCreate() {
        super.onCreate();
        Config.DEBUG = true;
        //友盟分享
        UMShareAPI.get(this);
        //开启全局捕获异常
//        MyCrashHandler.getInstance().init(getApplicationContext());

        /***
         * 初始化定位sdk，建议在Application中创建
         */
        locationService = new LocationService(getApplicationContext());
        mVibrator = (Vibrator) getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);
        SDKInitializer.initialize(getApplicationContext());


        phoneNumber = getPhoneNumber();
        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        PHONEID = tm.getDeviceId();


    }

    private String getPhoneNumber() {
        TelephonyManager mTelephonyMgr;
        mTelephonyMgr = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        if (mTelephonyMgr.getLine1Number() == null) {
            return "";
        }
        return mTelephonyMgr.getLine1Number();
    }


    {
        //分享
        PlatformConfig.setWeixin("wx4c93b58a42957cf8", "8afb5d7fc0cf39fa638d0815deb0ae48");
//        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
//        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
    }


}
