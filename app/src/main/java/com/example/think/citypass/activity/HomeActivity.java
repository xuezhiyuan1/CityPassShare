package com.example.think.citypass.activity;

import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.think.citypass.R;
import com.example.think.citypass.common.base.BaseActivity;
import com.example.think.citypass.common.config.FragmentBuilder;
import com.example.think.citypass.fragment.xzy.LoadFragment;
import com.example.think.citypass.fragment.zxm.ShouYeFragment;
import com.example.think.citypass.fragment.zzh.NaonaoFragment;

/**
 * Created by ASUS on 2017/5/15.
 */

public class HomeActivity extends BaseActivity {

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
//                        FragmentBuilder.getInstance().show().builder();
                        break;
                    case R.id.ShengHuoBtn:
//                        FragmentBuilder.getInstance().show().builder();
                        break;
                    case R.id.DiscoverBtn:
                        FragmentBuilder.getInstance().show(LoadFragment.class).builder();
                        break;

                }
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
