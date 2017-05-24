package com.example.think.citypass;

import android.app.Application;
import android.app.Service;
import android.os.Vibrator;

import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.mapapi.SDKInitializer;
import com.example.think.citypass.activity.zxm.baidumap.LocationService;
import com.example.think.citypass.activity.zxm.baidumap.MyLocationListener;
import com.example.think.citypass.common.base.BaseActivity;
import com.example.think.citypass.common.base.BaseFragment;

/**
 * Created by think on 2017/5/14.
 */

public class App extends Application {
    public LocationClient mLocationClient = null;
    public LocationService locationService;
    public Vibrator mVibrator;
    public BDLocationListener myListener = (BDLocationListener) new MyLocationListener();
    public static BaseActivity activity;
    public static BaseFragment lastFragment;

    @Override
    public void onCreate() {
        super.onCreate();

        //开启全局捕获异常
//        MyCrashHandler.getInstance().init(getApplicationContext());

        /***
         * 初始化定位sdk，建议在Application中创建
         */
        locationService = new LocationService(getApplicationContext());
        mVibrator =(Vibrator)getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);
        SDKInitializer.initialize(getApplicationContext());
    }
}
