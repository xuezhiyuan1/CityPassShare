package com.example.think.citypass.fragment.zzh.community;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.think.citypass.App;
import com.example.think.citypass.R;
import com.example.think.citypass.common.base.BaseFragment;
import com.example.think.citypass.fragment.zzh.community.banqu.BaixingshiFragment;
import com.example.think.citypass.fragment.zzh.community.banqu.BanquFragmentBuilder;
import com.example.think.citypass.fragment.zzh.community.banqu.MyfollowFragment;
import com.example.think.citypass.fragment.zzh.community.banqu.ShenghuoguanFragment;
import com.example.think.citypass.fragment.zzh.community.banqu.WenshibangFragment;
import com.example.think.citypass.fragment.zzh.community.banqu.XingququanFragment;
import com.example.think.citypass.fragment.zzh.community.banqu.ZhaokefuFragment;
import com.example.think.citypass.myview.MyProgressDialog;

/**
 * Created by ASUS on 2017/5/22.
 */

public class BanquFragment extends BaseFragment {
    private RadioGroup mRadioGroup;
    private RadioButton xingququan;
    private RadioButton zhaokefu;

    private MyProgressDialog dialog;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1) {
                dialog.dismiss();
            }
        }
    };

    @Override
    protected int layoutId() {
        return R.layout.banqu_fragment;
    }

    @Override
    protected void initView(View view) {
        mRadioGroup = (RadioGroup) view.findViewById(R.id.banqu_radiogroup);
        xingququan = (RadioButton) view.findViewById(R.id.xingququan);
        zhaokefu = (RadioButton) view.findViewById(R.id.zhaokefu);
    }

    @Override
    protected void initData() {
        init();
    }

    private void init() {
        dialog = new MyProgressDialog(App.activity);
    }

    @Override
    protected void initListener() {

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.myfollow:
                        BanquFragmentBuilder.getInstance().show(MyfollowFragment.class).builder();
                        break;
                    case R.id.baixingshi:
                        BanquFragmentBuilder.getInstance().show(BaixingshiFragment.class).builder();
                        break;
                    case R.id.xingququan:
                        BanquFragmentBuilder.getInstance().show(XingququanFragment.class).builder();
                        break;
                    case R.id.shenghuoguan:
                        BanquFragmentBuilder.getInstance().show(ShenghuoguanFragment.class).builder();
                        break;
                    case R.id.wenshibang:
                        BanquFragmentBuilder.getInstance().show(WenshibangFragment.class).builder();
                        break;
                    case R.id.zhaokefu:
                        BanquFragmentBuilder.getInstance().show(ZhaokefuFragment.class).builder();
                        break;
                }
            }
        });

        xingququan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
                handler.sendEmptyMessageDelayed(1, 1000);
            }
        });
        zhaokefu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
                handler.sendEmptyMessageDelayed(1, 1000);
            }
        });

    }

    @Override
    protected void loadData() {
        BanquFragmentBuilder.getInstance().show(MyfollowFragment.class).builder();
    }
}
