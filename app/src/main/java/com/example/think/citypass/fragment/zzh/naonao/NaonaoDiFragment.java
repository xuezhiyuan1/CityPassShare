package com.example.think.citypass.fragment.zzh.naonao;

import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.example.think.citypass.App;
import com.example.think.citypass.R;
import com.example.think.citypass.common.base.BaseFragment;
import com.example.think.citypass.myview.XListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ASUS on 2017/5/16.
 */

public class NaonaoDiFragment extends BaseFragment {
    private XListView xListView;

    private MyRush1 myRush1;// 下拉刷新

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                xListView.stopRefresh();
            }
        }
    };
    private List<String> data;
    private View view;

    @Override
    protected int layoutId() {
        return R.layout.naonao_refreshlist;
    }

    @Override
    protected void initView(View view) {
        xListView = (XListView) view.findViewById(R.id.lv);
    }

    @Override
    protected void initData() {
        data = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            data.add("hello");
        }
        myRush1 = new MyRush1();// 下拉刷新
        view = View.inflate(App.activity, R.layout.cover_ranking_item, null);
        view.findViewById(R.id.top_relay).setBackgroundResource(R.drawable.tieba_top_bg2);
    }

    @Override
    protected void initListener() {
        xListView.setXListViewListener(myRush1);// 下拉
    }

    @Override
    protected void loadData() {
        xListView.addHeaderView(view);
        xListView.setAdapter(new MyAdapter(App.activity, data));
    }

    private class MyRush1 implements XListView.IXListViewListener {

        @Override
        public void onRefresh() {
            handler.sendEmptyMessageDelayed(0, 2000);
        }
    }
}
