package com.example.think.citypass.fragment.zzh.community.banqu;

import android.view.View;
import android.widget.ListView;

import com.example.think.citypass.R;
import com.example.think.citypass.common.base.BaseFragment;

/**
 * Created by ASUS on 2017/5/22.
 */

public class ZhaokefuFragment extends BaseFragment {
    private ListView mListView;

    private BanquAdapter banquAdapter;

    @Override
    protected int layoutId() {
        return R.layout.myfollow_fragment;
    }

    @Override
    protected void initView(View view) {
        mListView = (ListView) view.findViewById(R.id.banqu_listview);
    }

    @Override
    protected void initData() {
        banquAdapter = new BanquAdapter(2);
        mListView.setAdapter(banquAdapter);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {

    }
}
