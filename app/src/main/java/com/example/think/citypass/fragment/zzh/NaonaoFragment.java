package com.example.think.citypass.fragment.zzh;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.LinearLayout;

import com.example.think.citypass.R;
import com.example.think.citypass.common.base.BaseFragment;
import com.example.think.citypass.fragment.zzh.naonao.NaonaoDiFragment;
import com.example.think.citypass.fragment.zzh.naonao.NaonaoWangFragment;
import com.example.think.citypass.fragment.zzh.naonao.NaonaoXingFragment;
import com.example.think.citypass.fragment.zzh.naonao.SquareFragment;
import com.example.think.citypass.fragment.zzh.naonao.TopicFragment;
import com.example.think.citypass.myview.ChildViewPager;

import java.util.ArrayList;
import java.util.List;

public class NaonaoFragment extends BaseFragment {

    private TabLayout tabLayout;

    private ChildViewPager viewPager;

    private LinearLayout linearLayout;

    private String[] titles = {"闹闹帝", "闹闹王", "闹闹星", "广场", "话题", "推荐", "晒图", "网友自荐"};

    private List<Fragment> data;

    private ZzhPagerAdapter zzhPagerAdapter;

    @Override
    protected int layoutId() {
        return R.layout.fragment_naonao;
    }

    @Override
    protected void initView(View view) {
        linearLayout = (LinearLayout) view.findViewById(R.id.ll_loading);
        tabLayout = (TabLayout) view.findViewById(R.id.naonaoTabLayout);
        viewPager = (ChildViewPager) view.findViewById(R.id.naonaoViewPager);
    }

    @Override
    protected void initData() {
        data = new ArrayList<>();
        initFragment();
        zzhPagerAdapter = new ZzhPagerAdapter(getFragmentManager(), data, titles);
        viewPager.setAdapter(zzhPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initFragment() {
        NaonaoDiFragment naonaoDiFragment = new NaonaoDiFragment();
        NaonaoWangFragment naonaoWangFragment = new NaonaoWangFragment();
        NaonaoXingFragment naonaoXingFragment = new NaonaoXingFragment();
        SquareFragment squareFragment = new SquareFragment();
        TopicFragment topicFragment = new TopicFragment();
        SquareFragment squareFragment1 = new SquareFragment();
        data.add(naonaoDiFragment);
        data.add(naonaoWangFragment);
        data.add(naonaoXingFragment);
        data.add(squareFragment);
        data.add(topicFragment);
        data.add(squareFragment1);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {
        viewPager.setCurrentItem(3);

    }
}
