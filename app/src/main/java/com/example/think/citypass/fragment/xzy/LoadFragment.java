package com.example.think.citypass.fragment.xzy;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Toast;

import com.example.think.citypass.R;
import com.example.think.citypass.common.base.BaseFragment;
import com.example.think.citypass.common.config.FragmentBuilder;

/**
 * Created by think on 2017/5/16.
 */

public class LoadFragment extends BaseFragment {

    @Override
    protected int layoutId() {
        return R.layout.layout_loading;
    }
    //发送空消息2秒后显示界面  即  隐藏Load布局
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if(msg.what == 200){
                FragmentBuilder.getInstance().show(FindFragment.class).builder();
            }else{
                Toast.makeText(getContext(), "不能跳", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    });
    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(200);
            }
        },2000);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {

    }
}
