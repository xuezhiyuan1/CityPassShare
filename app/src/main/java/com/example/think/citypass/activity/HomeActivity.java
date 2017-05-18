package com.example.think.citypass.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.think.citypass.R;
import com.example.think.citypass.activity.lxl.job.AllRecruitmentFragment;
import com.example.think.citypass.activity.lxl.job.MyMoneyActivity;
import com.example.think.citypass.common.base.BaseActivity;
import com.example.think.citypass.common.config.FragmentBuilder;
import com.example.think.citypass.fragment.xzy.LoadFragmentOne;
import com.example.think.citypass.fragment.zxm.ShouYeFragment;
import com.example.think.citypass.fragment.zzh.NaonaoFragment;

/**
 * Created by ASUS on 2017/5/15.
 */

public class HomeActivity extends BaseActivity {
    private TextView mCityMoney;

    private RadioGroup mRadioGroup;

    private static boolean isExit = false;

    private final int BACK = 0;

    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                isExit = false;
            }
        }
    };

    private void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(HomeActivity.this, "再次点击退出程序",
                    Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(BACK, 2000);
        } else {
            finish();
            System.exit(0);
        }
    }

    @Override
    protected int layoutId() {
        return R.layout.firstcehuamenu;
    }

    @Override
    protected void initView() {
        mRadioGroup = (RadioGroup) findViewById(R.id.Bottom_Group);
        mCityMoney= (TextView) findViewById(R.id.My_City_Money);
    }

    @Override
    protected void initData() {

//        第一次进入显示的Fragment
        FragmentBuilder.getInstance().show(ShouYeFragment.class).builder();
    }

    @Override
    protected void initListener() {
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.TouTiaoBtn:
                        FragmentBuilder.getInstance().show(ShouYeFragment.class).builder();
                        break;
                    case R.id.NaoNaoBtn:
                        FragmentBuilder.getInstance().show(NaonaoFragment.class).builder();
                        break;
                    case R.id.SheQuBtn:
//
                        break;
                    case R.id.ShengHuoBtn:
                        FragmentBuilder.getInstance().show(AllRecruitmentFragment.class).builder();
                        break;
                    case R.id.DiscoverBtn:
                        FragmentBuilder.getInstance().show(LoadFragmentOne.class).builder();
                        break;

                }
                mCityMoney.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        switch (v.getId()){
                            case R.id.My_City_Money:
                                Intent intent=new Intent(HomeActivity.this, MyMoneyActivity.class);
                                startActivity(intent);
                                break;
                        }
                    }
                });
            }

        });
    }

    @Override
    protected void loadData() {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        FragmentBuilder.clean();
    }
}
